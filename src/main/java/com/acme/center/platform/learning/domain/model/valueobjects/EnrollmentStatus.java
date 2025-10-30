package com.acme.center.platform.learning.domain.model.valueobjects;

/**
 * Enrollment status value object.
 * @summary
 * The class is a value object in the Learning bounded context.
 * The possible enrollment statuses are: REQUESTED, CONFIRMED, REJECTED, CANCELLED.
 */
public enum EnrollmentStatus {
    REQUESTED,
    CONFIRMED,
    REJECTED,
    CANCELLED
}
