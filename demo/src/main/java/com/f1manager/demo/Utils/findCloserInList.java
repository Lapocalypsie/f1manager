package com.f1manager.demo.Utils;


import static java.lang.Math.abs;

public class findCloserInList {
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
    public static void main(String[] args){
        double[] timeList = {1.46, 1.6, 1.9, 2.1, 2.3, 2.5, 2.8};
        System.out.println(findCloserInList.findCloser(2.8, timeList));
    }
}

