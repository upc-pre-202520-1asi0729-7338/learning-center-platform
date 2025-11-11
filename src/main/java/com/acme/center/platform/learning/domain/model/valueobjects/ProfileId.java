package com.acme.center.platform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Profile id value object.
 * @param profileId The unique identifier for the profile. It must be a positive non-null value.
 */
@Embeddable
public record ProfileId(Long profileId) {
    /**
     * Constructor to validate the profile ID.
     * @param profileId the profile ID
     * @throws IllegalArgumentException if profileId is null or less than 1
     */
    public ProfileId {
        if (profileId == null || profileId < 1) {
            throw new IllegalArgumentException("ProfileId must be a positive non-null value.");
        }
    }
}
