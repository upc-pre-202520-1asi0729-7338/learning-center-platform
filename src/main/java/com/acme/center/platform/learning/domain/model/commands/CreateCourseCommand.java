package com.acme.center.platform.learning.domain.model.commands;

/**
 * Create course command record.
 * <p>
 * This record represents the command to create a new course, containing the title and description.
 * </p>
 * @param title the title of the course
 * @param description the description of the course
 */
public record CreateCourseCommand(String title, String description) {
}
