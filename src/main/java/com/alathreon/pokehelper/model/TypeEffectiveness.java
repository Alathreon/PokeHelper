package com.alathreon.pokehelper.model;

public enum TypeEffectiveness implements Effectiveness {
    NO_EFFECT(0),
    NOT_EFFECTIVE(0.5),
    NORMAL_EFFECTIVENESS(1),
    SUPER_EFFECTIVE(2);
    private final double multiplier;
    TypeEffectiveness(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public double damageMultiplier() {
        return multiplier;
    }
}
