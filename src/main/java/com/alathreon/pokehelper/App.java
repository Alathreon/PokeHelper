package com.alathreon.pokehelper;

import com.alathreon.pokehelper.model.EffectivenessTable;
import com.alathreon.pokehelper.model.PokeType;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var table = new EffectivenessTable();
        System.out.println(table.typesByEffectivenessTo(PokeType.DRAGON, PokeType.FAIRY));
    }
}
