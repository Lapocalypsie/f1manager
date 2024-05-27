package com.f1manager.demo.ErrorHandling;
/*
Cette class est faite pour générer des exceptions génériques à tout le code (aide pour le débeugage)
Toutes les erreurs ont ce format : ERROR plus la desciption
 */

import com.f1manager.demo.Logging.Log;

public class throwException {
    public static void throwIllegalArgumentException(String description) {
        Log.fatalLog(description);
        throw new IllegalArgumentException("ERROR : " + description);

    }

    public static void throwUnsuportedOperationException(String description) {
        Log.fatalLog(description);
        throw new UnsupportedOperationException("ERROR : " + description);
    }
}
