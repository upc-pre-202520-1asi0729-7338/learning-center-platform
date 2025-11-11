package com.acme.center.platform.learning.interfaces.rest.resources;

/**
 * Learning path item resource.
 * @param learningPathItemId the learning path item ID
 * @param courseId the course ID
 * @param tutorialId the tutorial ID
 */
public record LearningPathItemResource(Long learningPathItemId, Long courseId, Long tutorialId) {
}
