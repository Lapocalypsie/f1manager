package com.f1manager.demo.Utils;

import com.f1manager.demo.ErrorHandling.throwException;

public class Check {
    public static void doitEtrePlusgrandQueZero(double nombre, String message){
        if(nombre < 0){
            throwException.throwIllegalArgumentException("Le/La " + message + " doit être supérieur(e) à 0");
        }
    }
}
