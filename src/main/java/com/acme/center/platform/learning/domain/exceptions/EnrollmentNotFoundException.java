package com.acme.center.platform.learning.domain.exceptions;

/**
 * Exception thrown when an enrollment is not found.
 * <p>
 * This exception is thrown when an enrollment is not found in the database.
 * </p>
 * @see RuntimeException
 */
public class EnrollmentNotFoundException extends RuntimeException {
    /**
     * Constructor for the exception.
     * @param enrollmentId The ID of the enrollment that was not found.
     */
    public EnrollmentNotFoundException(Long enrollmentId) {
        super(String.format("Enrollment with ID %s not found.", enrollmentId));
    }
}
