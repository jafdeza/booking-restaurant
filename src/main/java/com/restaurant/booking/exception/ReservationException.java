package com.restaurant.booking.exception;

public class ReservationException extends Exception{
    private final String errorMessage;
    private final int errorCode;

    public ReservationException(String errorMessage, int errorCode, String message) {
        super(message);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
