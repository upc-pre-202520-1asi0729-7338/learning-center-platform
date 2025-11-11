package com.acme.center.platform.learning.domain.model.valueobjects;

/**
 * Enrollment status value object.
 * <p>
 * The class is a value object in the Learning bounded context.
 * The possible enrollment statuses are: REQUESTED, CONFIRMED, REJECTED, CANCELLED.
 * </p>
 */
public enum EnrollmentStatus {
    /** The enrollment has been requested but not yet processed. */
    REQUESTED,
    /** The enrollment has been confirmed and is active. */
    CONFIRMED,
    /** The enrollment has been rejected. */
    REJECTED,
    /** The enrollment has been cancelled. */
    CANCELLED
}
