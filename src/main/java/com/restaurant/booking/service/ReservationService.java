package com.restaurant.booking.service;

import com.restaurant.booking.exception.ReservationException;
import com.restaurant.booking.json.CreateReservationRest;
import com.restaurant.booking.json.ReservationRest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    ReservationRest getReservationById(Long reservationId) throws ReservationException;

    ReservationRest getReservationByName(String name) throws ReservationException;

    public List<ReservationRest> getReservations() throws ReservationException;

    public List<ReservationRest> getReservations(String date) throws ReservationException;

    String addReservation(CreateReservationRest reservationRest) throws ReservationException;

    String cancelReservation(Long reservationId) throws ReservationException;

}
