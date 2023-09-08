package com.alathreon.pokehelper.model;

public interface Effectiveness {
    double damageMultiplier();
    default Effectiveness multiply(Effectiveness other) {
        return new UnboundedEffectiveness(this.damageMultiplier() * other.damageMultiplier());
    }
    default UnboundedEffectiveness toUnbound() {
        return new UnboundedEffectiveness(damageMultiplier());
    }
}
