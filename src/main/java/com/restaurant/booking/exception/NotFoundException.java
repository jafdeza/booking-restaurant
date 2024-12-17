package com.restaurant.booking.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ReservationException {
    public NotFoundException(String errorMessage, String message) {
        super(errorMessage, HttpStatus.NOT_FOUND.value(), message);
    }
}
