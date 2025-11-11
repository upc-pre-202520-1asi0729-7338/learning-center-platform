package com.acme.center.platform.learning.interfaces.rest.resources;

/**
 * Course resource record.
 * <p>
 * This record represents a course in the REST API, containing the course's ID, title, and description.
 * </p>
 * @param id the unique identifier of the course
 * @param title the title of the course
 * @param description the description of the course
 */
public record CourseResource(Long id, String title, String description) {
}
