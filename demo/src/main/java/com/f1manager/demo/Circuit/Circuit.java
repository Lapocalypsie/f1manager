package com.f1manager.demo.Circuit;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Circuit {


    private final LinkedHashMap<String, Double> circuit;

    // ==== CONSTRUCTEUR ==== //
    public Circuit(LinkedHashMap<String, Double> circuit) {
        this.circuit = new LinkedHashMap<>(circuit);
    }


    // ==== METHODES ==== //
    public LinkedHashMap<String, Double> getCircuit(Circuit Circuit) {
        return circuit;
    }
}
