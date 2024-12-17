package com.restaurant.booking.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends ReservationException {
    public InternalServerException(String errorMessage, String message) {
        super(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }
}
