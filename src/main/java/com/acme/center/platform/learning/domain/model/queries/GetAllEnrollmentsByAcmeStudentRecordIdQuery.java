package com.acme.center.platform.learning.domain.model.queries;

import com.acme.center.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;

/**
 * Query to get all enrollments by Acme student record id.
 * @param studentRecordId Acme student record id.
 */
public record GetAllEnrollmentsByAcmeStudentRecordIdQuery(AcmeStudentRecordId studentRecordId) {
    /**
     * Constructor to validate the query.
     * @param studentRecordId Acme student record id.
     * @throws IllegalArgumentException if student record id is null or blank.
     */
    public GetAllEnrollmentsByAcmeStudentRecordIdQuery {
        if (studentRecordId == null || studentRecordId.studentRecordId() == null || studentRecordId.studentRecordId().isBlank())
            throw new IllegalArgumentException("Student record id is required.");
    }
}
