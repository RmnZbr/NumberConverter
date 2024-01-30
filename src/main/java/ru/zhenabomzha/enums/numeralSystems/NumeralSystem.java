package ru.zhenabomzha.enums.numeralSystems;

import java.util.Arrays;
import java.util.Optional;

public enum NumeralSystem {

    BIN(2),
    OCT(8),
    DEC(10),
    HEX(16);

    private final int numeralSystem;

    NumeralSystem(int numeralSystem) {
        this.numeralSystem = numeralSystem;
    }

    public int getNumeralSystem() {
        return numeralSystem;
    }

    public static Optional<NumeralSystem> checkNumeralSystem(String numeralSystem) {
        return Arrays.stream(NumeralSystem.values())
                .filter(ns -> ns.name().equals(numeralSystem))
                .findFirst();
    }
}