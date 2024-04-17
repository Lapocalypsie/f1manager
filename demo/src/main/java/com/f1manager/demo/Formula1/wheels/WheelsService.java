package com.f1manager.demo.Formula1.wheels;

import com.f1manager.demo.Formula1.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Utils.assignCoef;
import com.f1manager.demo.Formula1.Utils.findCloserInList;

public class WheelsService {
    public static double getWheelsCoef(Wheels wheels){
        if (wheels.getPoidsPneus() < 0){
            throwException.throwIllegalArgumentException("Le poids des roues ne peut pas être négatif");
        }
        double[] poidsList = {37,38,39,40,41,42,43,44,45,46,47,48,49};
        return assignCoef.assignCoefficient(findCloserInList.findCloser(wheels.getPoidsPneus(), poidsList), poidsList);
    }

}
