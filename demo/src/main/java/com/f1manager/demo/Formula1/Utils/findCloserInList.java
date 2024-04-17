package com.f1manager.demo.Formula1.Utils;


import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class findCloserInList {
    public static Double findCloser(double target, int[] vitessList){
        double plusProcheElement = vitessList[0];
        double bestEcart = abs(target-plusProcheElement);
        for (int element : vitessList){
            double ecart = abs(target-element);
            if (ecart < bestEcart){
                plusProcheElement = element;
                bestEcart = ecart;
            }
        }
        return  plusProcheElement;
    }
    public static Double findCloser(double target, double[] vitessList){
        double plusProcheElement = vitessList[0];
        double bestEcart = abs(target-plusProcheElement);
        for (double element : vitessList){
            double ecart = abs(target-element);
            if (ecart < bestEcart){
                plusProcheElement = element;
                bestEcart = ecart;
            }
        }
        return  plusProcheElement;
    }
}

