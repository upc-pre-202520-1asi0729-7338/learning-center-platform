package com.acme.center.platform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Profile id value object.
 * @param profileId The unique identifier for the profile. It must be a positive non-null value.
 */
@Embeddable
public record ProfileId(Long profileId) {
    public ProfileId {
        if (profileId == null || profileId < 1) {
            throw new IllegalArgumentException("ProfileId must be a positive non-null value.");
        }
    }
}
