package by.overone.bibliophile.util.validation;

import by.overone.bibliophile.dto.UserDetailsDTO;
import by.overone.bibliophile.dto.UserRegistrationDTO;

public class UserValidate {

    private final static String LOGIN_REGEX = "^[\\w]{4,12}$";
    private final static String EMAIL_REGEX = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$";
    private final static String PASSWORD_REGEX = "[a-zA-Z0-9]{2,16}";
    private final static String PHONE_REGEX = "^(\\+375|29)(17|29|33|44)(\\d){7}$";
    private final static String NAME_REGEX = "^[a-zA-Z]{2,30}$";
    private final static String ADDRESS_REGEX = "^[\\w]{5,50}$";

    public static boolean validateRegistration(UserRegistrationDTO user){
        return validateLogin(user.getLogin()) && validateEmail(user.getEmail()) && validatePassword(user.getPassword());
    }

    public static boolean validateUserDetails(UserDetailsDTO user) {
        return validateName(user.getName()) && validateSurname(user.getSurname()) && validateAddress(user.getAddress())
                && validatePhoneNumber(user.getPhoneNumber());
    }

    private static boolean validateLogin(String login) {
        return login != null && !login.isBlank() && login.matches(LOGIN_REGEX);
    }

    private static boolean validatePassword(String password) {
        return password != null && !password.isBlank() && password.matches(PASSWORD_REGEX);
    }

    private static boolean validateEmail(String email) {
        return email != null && !email.isBlank() && email.matches(EMAIL_REGEX);
    }

    private static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isBlank() && phoneNumber.matches(PHONE_REGEX);
    }

    private static boolean validateName(String name) {
        return name != null && !name.isBlank() && name.matches(NAME_REGEX);
    }

    private static boolean validateSurname(String surName) {
        return surName != null && !surName.isBlank() && surName.matches(NAME_REGEX);
    }

    private static boolean validateAddress(String address) {
        return address != null && !address.isBlank() && address.matches(ADDRESS_REGEX);
    }
}

