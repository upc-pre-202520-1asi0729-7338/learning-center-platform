package com.acme.center.platform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * Student record id value object.
 * @summary
 * The class is a value object in the Learning bounded context.
 * It is an embeddable object containing a unique identifier for students in ACME Learning Center Platform.
 * It throws an {@link IllegalArgumentException} if the student record id is null or blank.
 * @param studentRecordId The unique identifier for the student record. It cannot be null or blank.
 * @see IllegalArgumentException
 * @since 1.0.0
 */
@Embeddable
public record AcmeStudentRecordId(String studentRecordId) {

    public AcmeStudentRecordId() {
        this(UUID.randomUUID().toString());
    }

    public AcmeStudentRecordId {
        if (studentRecordId == null || studentRecordId.isBlank()) {
            throw new IllegalArgumentException("Student record id cannot be null or blank");
        }
    }
}
