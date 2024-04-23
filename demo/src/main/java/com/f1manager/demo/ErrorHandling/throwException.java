package com.f1manager.demo.Formula1.ErrorHandling;
/*
Cette class est faite pour générer des exceptions génériques à tout le code (aide pour le débeugage)
Toutes les erreurs ont ce format : ERROR plus la desciption
 */

public class throwException {
    public static void throwIllegalArgumentException(String destription) {
        throw new IllegalArgumentException("ERROR : " + destription);

    }

    public static void throwUnsuportedOperationException(String description) {
        throw new UnsupportedOperationException("ERROR : " + description);
    }
}
