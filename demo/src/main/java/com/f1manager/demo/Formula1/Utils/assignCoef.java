package com.f1manager.demo.Formula1.Utils;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class assignCoef {
    public Double assignCoeficient(int target, int[] liste){
        OptionalInt index = IntStream.range(0, liste.length)
                .filter(i -> liste[i] == target)
                .findFirst();
        if (index.isPresent()) {
            return (double) (index.getAsInt()+1) / (liste.length + 2); // Calculate coefficient
        } else {
            throw new IllegalArgumentException("La target n'est pas présente dans la liste");
        }
    }
    public static Double assignCoeficient(double target, int[] liste){
        OptionalInt index = IntStream.range(0, liste.length)
                .filter(i -> liste[i] == target)
                .findFirst();
        if (index.isPresent()) {
            return (double) (index.getAsInt()+1) / (liste.length ); // Calculate coefficient
        } else {
            throw new IllegalArgumentException("La target n'est pas présente dans la liste");
        }
    }
    public static void main(String[] args){
        int[] poidsList = {798,800,810,830,850};
        System.out.println(assignCoef.assignCoeficient(findCloserInList.findCloser(840,poidsList), poidsList));
    }
}
