package com.co.cultivemosjuntos.app.utils.Helpers;

import java.util.Objects;
import java.util.regex.Pattern;

public class Validate {


    private Validate() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validateEmail(String email) {
        String ragexValidation = "^(.+)@(\\S+)$";
        return Pattern
                .compile(ragexValidation)
                .matcher(email)
                .matches();

    }

    public static boolean isValidId(Long id) {
        return Objects.isNull(id) || id < 0;
    }
}
