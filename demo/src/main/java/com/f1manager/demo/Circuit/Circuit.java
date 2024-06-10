package com.f1manager.demo.Circuit;

import java.util.LinkedHashMap;

public class Circuit {

    private final LinkedHashMap<String, Double> circuit;

    public Circuit(LinkedHashMap<String, Double> circuit) {
        this.circuit = new LinkedHashMap<>(circuit);
    }

    public LinkedHashMap<String, Double> getCircuit(Circuit Circuit) {
        return circuit;
    }
}
