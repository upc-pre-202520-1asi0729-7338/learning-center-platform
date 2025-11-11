package com.acme.center.platform.profiles.interfaces.rest.resources;

/**
 * Resource for a profile.
 * @param id the profile ID
 * @param fullName the full name
 * @param email the email
 * @param streetAddress the street address
 */
public record ProfileResource(
        Long id,
        String fullName,
        String email,
        String streetAddress) {
}
