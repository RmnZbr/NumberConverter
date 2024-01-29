package ru.zhenabomzha.enums.numeralSystems;

import java.util.Arrays;
import java.util.Optional;

public enum NumeralSystem {

    BIN("BIN"),
    OCT("OCT"),
    DEC("DEC"),
    HEX("HEX");

    private final String numeralSystem;

    NumeralSystem(String numeralSystem) {
        this.numeralSystem = numeralSystem;
    }

    public String getNumeralSystem() {
        return numeralSystem;
    }

    public static Optional<NumeralSystem> checkNumeralSystem(String numeralSystem) {
        return Arrays.stream(NumeralSystem.values())
                .filter(ns -> ns.getNumeralSystem().equals(numeralSystem))
                .findFirst();
    }
}
