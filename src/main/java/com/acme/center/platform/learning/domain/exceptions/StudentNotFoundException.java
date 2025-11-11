package com.acme.center.platform.learning.domain.exceptions;

import com.acme.center.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;

/**
 * Exception thrown when a student is not found.
 * <p>
 * This exception is thrown when a student is not found in the database.
 * </p>
 * @see RuntimeException
 */
public class StudentNotFoundException extends RuntimeException {
    /**
     * Constructor for the exception.
     * @param studentRecordId The ACME student record ID of the student that was not found.
     */
    public StudentNotFoundException(AcmeStudentRecordId studentRecordId) {
        super("Student with Acme student record id %s not found".formatted(studentRecordId.studentRecordId()));
    }
}
