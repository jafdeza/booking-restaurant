package com.restaurant.booking.controller;

import com.restaurant.booking.exception.ReservationException;
import com.restaurant.booking.json.CreateReservationRest;
import com.restaurant.booking.json.ReservationRest;
import com.restaurant.booking.response.ReservationResponse;
import com.restaurant.booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reservation/"+"v1")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationResponse<ReservationRest> getReservationById(Long reservationId) throws ReservationException {
        return new ReservationResponse<>
                ("Success",
                        String.valueOf(HttpStatus.OK),
                        "OK",
                        reservationService.getReservationById(reservationId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/add",produces = MediaType.TEXT_PLAIN_VALUE)
    public String createReservation(CreateReservationRest createReservationRest) throws ReservationException {
        return reservationService.addReservation(createReservationRest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/name/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationResponse<ReservationRest> getReservationByName(String name) throws ReservationException {
        return new ReservationResponse<>
                ("Success",
                        String.valueOf(HttpStatus.OK),
                        "OK",
                        reservationService.getReservationByName(name));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationResponse<List<ReservationRest>> getReservations() throws ReservationException {
        return new ReservationResponse<>
                ("Success",
                        String.valueOf(HttpStatus.OK),
                        "OK",
                        reservationService.getReservations());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/all/date/{date}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationResponse<List<ReservationRest>> getReservationsByDate(String date) throws ReservationException {
        return new ReservationResponse<>
                ("Success",
                        String.valueOf(HttpStatus.OK),
                        "OK",
                        reservationService.getReservations(date));
    }

}
