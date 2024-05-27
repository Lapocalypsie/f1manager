package com.f1manager.demo.Utils;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Logging.Log;

import java.util.OptionalInt;
import java.util.stream.IntStream;
/*
Cette classe est faite pour assignier un coefficient. On lui passe une liste et une valeur qui se trouve dans la liste.
Partant de la position de l'élément dans la liste et de la taille de la liste on calcule le coefficient.
Assign coefficient trouve l'index de l'élément dans la liste et retourne une erreur si l'élément cherché n'est pas dans la liste
Calculate coefficient calcule le coefficient en se basant sur la taille de la liste et la position du coefficient dans la liste.
 */


public class assignCoef {

    private static double calculateCoefficient(int index, int length) {
        double coef = (double) (index) / (length);

        if (coef < 0.0) {
            throwException.throwUnsuportedOperationException("Le coefficient ne peut pas être négatif");
        }
        Log.infoLog("calculateCoefficient : le coefficient est " + coef);
        return coef;
    }

    public static Double assignCoefficient(double target, double[] liste) {
        OptionalInt index = IntStream.range(0, liste.length)
                .filter(i -> liste[i] == target)
                .findFirst();
        if (index.isPresent()) {
            return calculateCoefficient(index.getAsInt(), liste.length);
        } else {
            throwException.throwIllegalArgumentException("La target n'est pas présente dans la liste");
            return null; // Just for the sake of compilation, this line will never be reached
        }
    }
/*
    public static void main(String[] args) {
        double[] timeList = {1.46, 1.6, 1.9, 2.8};
        System.out.println(findCloserInList.findCloser(2.8, timeList));
        System.out.println(timeList.length);
        System.out.println(1 - assignCoefficient(findCloserInList.findCloser(2.8, timeList), timeList));
    }

 */
}
