package com.acme.center.platform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Student performance metric set value object.
 * <p>
 * This record tracks the total number of completed courses and tutorials for a student.
 * </p>
 * @param totalCompletedCourses the total number of completed courses
 * @param totalCompletedTutorials the total number of completed tutorials
 */
@Embeddable
public record StudentPerformanceMetricSet(Integer totalCompletedCourses, Integer totalCompletedTutorials) {
    /**
     * Default constructor initializing metrics to zero.
     */
    public StudentPerformanceMetricSet() {
        this(0, 0);
    }

    /**
     * Compact constructor with validation.
     * Ensures that both metrics are non-negative.
     */
    public StudentPerformanceMetricSet {
        if (totalCompletedCourses == null || totalCompletedCourses < 0)
            throw new IllegalArgumentException("totalCompletedCourses must be non-negative");
        if (totalCompletedTutorials == null || totalCompletedTutorials < 0)
            throw new IllegalArgumentException("totalCompletedTutorials must be non-negative");
    }

    /**
     * Increments the total completed courses by one.
     * @return a new instance with incremented courses
     */
    public StudentPerformanceMetricSet incrementCompletedCourses() {
        return new StudentPerformanceMetricSet(totalCompletedCourses + 1, totalCompletedTutorials);
    }

    /**
     * Increments the total completed tutorials by one.
     * @return a new instance with incremented tutorials
     */
    public StudentPerformanceMetricSet incrementCompletedTutorials() {
        return new StudentPerformanceMetricSet(totalCompletedCourses, totalCompletedTutorials + 1);
    }
}
