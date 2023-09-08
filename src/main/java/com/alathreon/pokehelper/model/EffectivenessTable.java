package com.alathreon.pokehelper.model;

import com.alathreon.pokehelper.util.Util;

import java.util.*;
import java.util.stream.Stream;

import static com.alathreon.pokehelper.model.PokeType.*;
import static com.alathreon.pokehelper.model.TypeEffectiveness.*;

public class EffectivenessTable {
    private final Map<PokeType, Map<PokeType, TypeEffectiveness>> table = Util.mapOf(
            NORMAL, Map.of(
                    ROCK, NOT_EFFECTIVE,
                    GHOST, NO_EFFECT,
                    STEEL, NOT_EFFECTIVE
            ),
            FIRE, Map.of(
                    FIRE, NOT_EFFECTIVE,
                    WATER, NOT_EFFECTIVE,
                    GRASS, SUPER_EFFECTIVE,
                    ICE, SUPER_EFFECTIVE,
                    BUG, SUPER_EFFECTIVE,
                    ROCK, NOT_EFFECTIVE,
                    DRAGON, NOT_EFFECTIVE,
                    STEEL, SUPER_EFFECTIVE
            ),
            WATER, Map.of(
                    FIRE, SUPER_EFFECTIVE,
                    WATER, NOT_EFFECTIVE,
                    GRASS, NOT_EFFECTIVE,
                    GROUND, SUPER_EFFECTIVE,
                    ROCK, SUPER_EFFECTIVE,
                    DRAGON, NOT_EFFECTIVE
            ),
            GRASS, Map.of(
                    FIRE, NOT_EFFECTIVE,
                    WATER, SUPER_EFFECTIVE,
                    GRASS, NOT_EFFECTIVE,
                    POISON, NOT_EFFECTIVE,
                    GROUND, SUPER_EFFECTIVE,
                    FLYING, NOT_EFFECTIVE,
                    BUG, NOT_EFFECTIVE,
                    ROCK, SUPER_EFFECTIVE,
                    DRAGON, NOT_EFFECTIVE,
                    STEEL, NOT_EFFECTIVE
            ),
            ELECTRIC, Map.of(
                    WATER, SUPER_EFFECTIVE,
                    ELECTRIC, NOT_EFFECTIVE,
                    GRASS, NOT_EFFECTIVE,
                    GROUND, NO_EFFECT,
                    FLYING, SUPER_EFFECTIVE,
                    DRAGON, NOT_EFFECTIVE
            ),
            ICE, Map.of(
                    FIRE, NOT_EFFECTIVE,
                    WATER, NOT_EFFECTIVE,
                    GRASS, SUPER_EFFECTIVE,
                    ICE, NOT_EFFECTIVE,
                    GROUND, SUPER_EFFECTIVE,
                    FLYING, SUPER_EFFECTIVE,
                    DRAGON, SUPER_EFFECTIVE,
                    STEEL, NOT_EFFECTIVE
            ),
            FIGHTING, Util.mapOf(
                    NORMAL, SUPER_EFFECTIVE,
                    ICE, SUPER_EFFECTIVE,
                    POISON, NOT_EFFECTIVE,
                    FLYING, NOT_EFFECTIVE,
                    PSYCHIC, NOT_EFFECTIVE,
                    BUG, NOT_EFFECTIVE,
                    ROCK, SUPER_EFFECTIVE,
                    GHOST, NO_EFFECT,
                    DARK, SUPER_EFFECTIVE,
                    STEEL, SUPER_EFFECTIVE,
                    FAIRY, NOT_EFFECTIVE
            ),
            POISON, Map.of(
                    GRASS, SUPER_EFFECTIVE,
                    POISON, NOT_EFFECTIVE,
                    GROUND, NOT_EFFECTIVE,
                    ROCK, NOT_EFFECTIVE,
                    GHOST, NOT_EFFECTIVE,
                    STEEL, NO_EFFECT,
                    FAIRY, SUPER_EFFECTIVE
            ),
            GROUND, Map.of(
                    FIRE, SUPER_EFFECTIVE,
                    ELECTRIC, SUPER_EFFECTIVE,
                    GRASS, NOT_EFFECTIVE,
                    POISON, SUPER_EFFECTIVE,
                    FLYING, NO_EFFECT,
                    BUG, NOT_EFFECTIVE,
                    ROCK, SUPER_EFFECTIVE,
                    STEEL, SUPER_EFFECTIVE
            ),
            FLYING, Map.of(
                    ELECTRIC, NOT_EFFECTIVE,
                    GRASS, SUPER_EFFECTIVE,
                    FIGHTING, SUPER_EFFECTIVE,
                    BUG, SUPER_EFFECTIVE,
                    ROCK, NOT_EFFECTIVE,
                    STEEL, NOT_EFFECTIVE
            ),
            PSYCHIC, Map.of(
                    FIGHTING, SUPER_EFFECTIVE,
                    POISON, SUPER_EFFECTIVE,
                    PSYCHIC, NOT_EFFECTIVE,
                    DARK, NO_EFFECT,
                    STEEL, NOT_EFFECTIVE
            ),
            BUG, Map.of(
                    FIRE, NOT_EFFECTIVE,
                    GRASS, SUPER_EFFECTIVE,
                    FIGHTING, NOT_EFFECTIVE,
                    POISON, NOT_EFFECTIVE,
                    FLYING, NOT_EFFECTIVE,
                    PSYCHIC, SUPER_EFFECTIVE,
                    GHOST, NOT_EFFECTIVE,
                    DARK, SUPER_EFFECTIVE,
                    STEEL, NOT_EFFECTIVE,
                    FAIRY, NOT_EFFECTIVE
            ),
            ROCK, Map.of(
                    FIRE, SUPER_EFFECTIVE,
                    ICE, SUPER_EFFECTIVE,
                    FIGHTING, NOT_EFFECTIVE,
                    GROUND, NOT_EFFECTIVE,
                    FLYING, SUPER_EFFECTIVE,
                    BUG, SUPER_EFFECTIVE,
                    STEEL, NOT_EFFECTIVE
             ),
            GHOST, Map.of(
                    NORMAL, NO_EFFECT,
                    PSYCHIC, SUPER_EFFECTIVE,
                    GHOST, SUPER_EFFECTIVE,
                    DARK, NOT_EFFECTIVE
            ),
            DRAGON, Map.of(
                    DRAGON, SUPER_EFFECTIVE,
                    STEEL, NOT_EFFECTIVE,
                    FAIRY, NO_EFFECT
            ),
            DARK, Map.of(
                    FIGHTING, NOT_EFFECTIVE,
                    PSYCHIC, SUPER_EFFECTIVE,
                    GHOST, SUPER_EFFECTIVE,
                    DARK, NOT_EFFECTIVE,
                    FAIRY, NOT_EFFECTIVE
            ),
            STEEL, Map.of(
                    FIRE, NOT_EFFECTIVE,
                    WATER, NOT_EFFECTIVE,
                    GRASS, NOT_EFFECTIVE,
                    ICE, SUPER_EFFECTIVE,
                    ROCK, SUPER_EFFECTIVE,
                    STEEL, NOT_EFFECTIVE,
                    FAIRY, SUPER_EFFECTIVE
            ),
            FAIRY, Map.of(
                    FIRE, NOT_EFFECTIVE,
                    FIGHTING, SUPER_EFFECTIVE,
                    POISON, NOT_EFFECTIVE,
                    DRAGON, SUPER_EFFECTIVE,
                    DARK, SUPER_EFFECTIVE,
                    STEEL, NOT_EFFECTIVE
            )
    );

    public TypeEffectiveness typeEffectiveness(PokeType attacking, PokeType defending) {
        return table.get(attacking).getOrDefault(defending, NORMAL_EFFECTIVENESS);
    }
    public Effectiveness effectiveness(PokeType attacking, PokeType... defending) {
        return Stream.of(defending)
                .map(d -> (Effectiveness) typeEffectiveness(attacking, d))
                .reduce(NORMAL_EFFECTIVENESS, Effectiveness::multiply);
    }

    public Map<PokeType, TypeEffectiveness> typeEffectivenessTo(PokeType defending) {
        Map<PokeType, TypeEffectiveness> map = new EnumMap<>(PokeType.class);
        for(PokeType attacking : PokeType.values()) {
            map.put(attacking, typeEffectiveness(attacking, defending));
        }
        return map;
    }
    public Map<PokeType, Effectiveness> effectivenessTo(PokeType... defending) {
        Map<PokeType, Effectiveness> map = new EnumMap<>(PokeType.class);
        for(PokeType attacking : PokeType.values()) {
            map.put(attacking, effectiveness(attacking, defending));
        }
        return map;
    }
    public Map<Effectiveness, Set<PokeType>> typesByEffectivenessTo(PokeType... defending) {
        Map<Effectiveness, Set<PokeType>> map = new HashMap<>();
        for(PokeType attacking : PokeType.values()) {
            Effectiveness effectiveness = effectiveness(attacking, defending).toUnbound();
            map.putIfAbsent(effectiveness, EnumSet.noneOf(PokeType.class));
            map.get(effectiveness).add(attacking);
        }
        return map;
    }
}
