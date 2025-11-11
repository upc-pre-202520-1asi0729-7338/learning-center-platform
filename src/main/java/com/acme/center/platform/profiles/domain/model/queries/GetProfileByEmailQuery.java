package com.acme.center.platform.profiles.domain.model.queries;

import com.acme.center.platform.profiles.domain.model.valueobjects.EmailAddress;

/**
 * Get Profile By Email Query
 * @param emailAddress the email address
 */
public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
