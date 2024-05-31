package com.f1manager.demo.Utils;


import com.f1manager.demo.Log.Log;

import static java.lang.Math.abs;
/*
Cette classe trouve l'élément d'une liste le plus proche  par rapport à un élément donné.
Si on lance le main, il ressort 2.5 car 2.5 est l'élément de la liste le plus proche de 2.6
 */
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
        Log.traceLog("L'élément le plus proche est" + plusProcheElement);
        return  plusProcheElement;
    }
    /*
    public static void main(String[] args){
        double[] timeList = {1.46, 1.6, 1.9, 2.1, 2.3, 2.5, 2.8};
        System.out.println(findCloserInList.findCloser(2.6, timeList));
    }
     */
}

