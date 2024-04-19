package com.f1manager.demo.Formula1.ErrorHandling;


public class throwException {
    public static void throwIllegalArgumentException(String destription) {
        throw new IllegalArgumentException("ERROR : " + destription);

    }

    public static void throwUnsuportedOperationException(String description) {
        throw new UnsupportedOperationException("ERROR : " + description);
    }
}
