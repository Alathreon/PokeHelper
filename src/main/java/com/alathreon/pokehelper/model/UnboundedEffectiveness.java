package com.alathreon.pokehelper.model;

public record UnboundedEffectiveness(double damageMultiplier) implements Effectiveness {
    @Override
    public UnboundedEffectiveness toUnbound() {
        return this;
    }
}
