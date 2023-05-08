package com.shop.choisi.exception;

public class ChoisiNotFoundException extends RuntimeException{
    public ChoisiNotFoundException() {
        super();
    }

    public ChoisiNotFoundException(String message) {
        super(message);
    }

    public ChoisiNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChoisiNotFoundException(Throwable cause) {
        super(cause);
    }
}
