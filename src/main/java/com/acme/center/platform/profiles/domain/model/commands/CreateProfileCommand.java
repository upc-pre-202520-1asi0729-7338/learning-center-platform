package com.acme.center.platform.profiles.domain.model.commands;

/**
 * Create Profile Command
 *
 * @param firstName the first name
 * @param lastName  the last name
 * @param email     the email
 * @param street    the street
 * @param number    the number
 * @param city      the city
 * @param postalCode the postal code
 * @param country   the country
 */
public record CreateProfileCommand(String firstName,
                                   String lastName,
                                   String email,
                                   String street,
                                   String number,
                                   String city,
                                   String postalCode,
                                   String country) {
}
