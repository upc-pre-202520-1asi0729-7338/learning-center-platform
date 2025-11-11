package com.acme.center.platform.learning.interfaces.rest.resources;

/**
 * Student resource.
 * @param acmeStudentRecordId the ACME student record ID
 * @param profileId the profile ID
 * @param totalCompletedCourses the total completed courses
 * @param totalCompletedTutorials the total completed tutorials
 */
public record StudentResource(String acmeStudentRecordId, Long profileId, Integer totalCompletedCourses, Integer totalCompletedTutorials) {
}
