package com.acme.center.platform.learning.interfaces.rest.resources;

/**
 * Create course resource record.
 * <p>
 * This record represents the data required to create a new course, including title and description.
 * It includes validation to ensure title and description are not null or blank.
 * </p>
 * @param title the title of the course to create
 * @param description the description of the course to create
 */
public record CreateCourseResource(String title, String description) {
    /**
     * Validates the resource.
     * @throws IllegalArgumentException if the title or description is null or blank.
     */
    public CreateCourseResource {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description is required");
        }
    }
}
