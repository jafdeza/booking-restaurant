package com.restaurant.booking.service.Impl;

import com.restaurant.booking.exception.InternalServerException;
import com.restaurant.booking.exception.NotFoundException;
import com.restaurant.booking.exception.ReservationException;
import com.restaurant.booking.json.CreateReservationRest;
import com.restaurant.booking.json.ReservationRest;
import com.restaurant.booking.model.Reservation;
import com.restaurant.booking.repository.ReservationRepository;
import com.restaurant.booking.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReservationServiceImpl implements ReservationService {

    private static final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    ReservationRepository reservationRepository;
    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ReservationRest getReservationById(Long reservationId) throws ReservationException {
        return modelMapper.map(getReservation(reservationId), ReservationRest.class);
    }

    @Override
    public List<ReservationRest> getReservations() throws ReservationException {
        final List<Reservation> reservationList = reservationRepository.findAll();
        return reservationList.stream().map(s -> modelMapper.map(s, ReservationRest.class)).collect(toList());
    }

    @Override
    public List<ReservationRest> getReservations(String date) throws ReservationException {
        final List<Reservation> reservationList = reservationRepository.findAllByDate(date);
        return reservationList.stream().map(s -> modelMapper.map(s, ReservationRest.class)).collect(toList());
    }

    @Override
    public String addReservation(CreateReservationRest reservationRest) throws ReservationException {
        Reservation reservation = new Reservation();
        reservation.setName(reservationRest.getName());
        reservation.setDate(reservationRest.getDate());
        reservation.setTime(reservationRest.getTime());
        reservation.setPeople(reservationRest.getPeople());
        Reservation newReservation = null;
        try {
            newReservation = reservationRepository.save(reservation);
        } catch (Exception e) {
            log.error("INTERNAL SERVER ERROR", e);
            throw new InternalServerException("INTERNAL SERVER ERROR", "INTERNAL_SERVER_ERROR");
        }
        return String.valueOf(newReservation.getId());
    }

    @Override
    public String cancelReservation(Long reservationId) throws ReservationException {

        reservationRepository.findById(reservationId)
                .orElseThrow(() ->
                        new NotFoundException("Not Found - 404 - 1", "RESERVATION NOT FOUND"));
        try {
            reservationRepository.deleteById(reservationId);
        } catch (Exception e) {
            log.error("INTERNAL SERVER ERROR", e);
            throw new InternalServerException("INTERNAL SERVER ERROR", "INTERNAL_SERVER_ERROR");
        }
        return "RESERVATION CANCELED";
    }


    @Override
    public ReservationRest getReservationByName(String name) throws ReservationException {
        return modelMapper.map(getReservation(name), ReservationRest.class);
    }

    private Reservation getReservation(Long reservationId) throws ReservationException {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() ->
                        new NotFoundException("Not Found - 404 - 1", "RESERVATION NOT FOUND"));
    }

    private Reservation getReservation(String name) throws ReservationException {
        return reservationRepository.findByName(name)
                .orElseThrow(() ->
                        new NotFoundException("Not Found - 404 - 1", "RESERVATION NOT FOUND"));
    }
}
