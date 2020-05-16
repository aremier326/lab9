package com.lab9.exceptions;

/**
 * Exception class for incorrect salary.
 */
public class IncorrectSalaryException extends Exception {

    /**
     * Constructs a new exception with {@code null} as its detail message.
     */
    public IncorrectSalaryException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.
     * @param   message   the detail message.
     */
    public IncorrectSalaryException(String message) {
        super(message);
    }
}
