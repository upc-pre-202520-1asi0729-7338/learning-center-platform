package com.acme.center.platform.learning.interfaces.rest.resources;

/**
 * Enrollment resource.
 * @param enrollmentId the enrollment ID
 * @param studentRecordId the student record ID
 * @param courseId the course ID
 * @param status the enrollment status
 */
public record EnrollmentResource(Long enrollmentId, String studentRecordId, Long courseId, String status) {
}
