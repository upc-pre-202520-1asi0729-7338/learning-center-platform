package com.acme.center.platform.learning.interfaces.rest.transform;

import com.acme.center.platform.learning.domain.model.aggregates.Student;
import com.acme.center.platform.learning.interfaces.rest.resources.StudentResource;

/**
 * Assembler to convert a Student entity to a StudentResource.
 */
public class StudentResourceFromEntityAssembler {
    /**
     * Private constructor to prevent instantiation.
     */
    private StudentResourceFromEntityAssembler() {
        // Utility class
    }

    /**
     * Converts a Student entity to a StudentResource.
     *
     * @param entity The {@link Student} entity to convert.
     * @return The {@link StudentResource} resource that results from the conversion.
     */
    public static StudentResource toResourceFromEntity(Student entity) {
        return new StudentResource(entity.getStudentRecordId(), entity.getProfileId(), entity.getTotalCompletedCourses(), entity.getTotalCompletedTutorials());
    }
}
