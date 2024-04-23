package com.f1manager.demo.Utils;

import com.f1manager.demo.ErrorHandling.throwException;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class assignCoef {

    private static double calculateCoefficient(int index, int length) {
        double coef = (double) (index) / (length);

        if (coef < 0.0) {
            throwException.throwUnsuportedOperationException("Le coefficient ne peut pas être négatif");
        }
        return coef;
    }

    public static Double assignCoefficient(double target, double[] liste) {
        OptionalInt index = IntStream.range(0, liste.length)
                .filter(i -> liste[i] == target)
                .findFirst();
        if (index.isPresent()) {
            System.out.println(index);
            return calculateCoefficient(index.getAsInt(), liste.length);
        } else {
            throwException.throwIllegalArgumentException("La target n'est pas présente dans la liste");
            return null; // Just for the sake of compilation, this line will never be reached
        }
    }

    public static void main(String[] args) {
        double[] timeList = {1.46, 1.6, 1.9, 2.8};
        System.out.println(findCloserInList.findCloser(2.8, timeList));
        System.out.println(timeList.length);
        System.out.println(1 - assignCoefficient(findCloserInList.findCloser(2.8, timeList), timeList));
    }
}
