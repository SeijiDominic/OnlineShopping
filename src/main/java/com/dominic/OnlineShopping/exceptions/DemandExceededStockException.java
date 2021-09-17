package com.dominic.OnlineShopping.exceptions;

public class DemandExceededStockException extends RuntimeException {
    public DemandExceededStockException() {
        super("Requested item quantity exceeded the available number of items.");
    }
    public DemandExceededStockException(String message) {
        super(message);
    }
}
