package com.acme.center.platform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Tutorial ID value object.
 * <p>
 * This record represents the unique identifier for a tutorial, ensuring it is a positive non-null value.
 * </p>
 * @param tutorialId the unique identifier of the tutorial
 */
@Embeddable
public record TutorialId(Long tutorialId) {
    /**
     * Constructor to validate the tutorial ID.
     * @param tutorialId the tutorial ID
     * @throws IllegalArgumentException if tutorialId is null or negative
     */
    public TutorialId {
        if (tutorialId == null || tutorialId < 0) {
            throw new IllegalArgumentException("TutorialId must be a positive non-null value.");
        }
    }
}
