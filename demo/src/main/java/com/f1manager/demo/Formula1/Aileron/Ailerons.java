package com.f1manager.demo.Formula1.Aileron;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Ailerons {

    private final double coefAileron;
    private double poidsAileron;

    public Ailerons(double coefAileron, double poidsAileron) {
        this.coefAileron = coefAileron;
        this.poidsAileron = poidsAileron;
    }

}
