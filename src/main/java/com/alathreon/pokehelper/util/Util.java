package com.alathreon.pokehelper.util;

import java.util.Map;

public class Util {
    private Util() {}

    public static <K, V> Map<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5,
                               K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10,
                                  K k11, V v11) {
        return Map.ofEntries(
                Map.entry(k1, v1),
                Map.entry(k2, v2),
                Map.entry(k3, v3),
                Map.entry(k4, v4),
                Map.entry(k5, v5),
                Map.entry(k6, v6),
                Map.entry(k7, v7),
                Map.entry(k8, v8),
                Map.entry(k9, v9),
                Map.entry(k10, v10),
                Map.entry(k11, v11)
        );
    }

    public static <K, V> Map<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5,
                                         K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10,
                                         K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15,
                                         K k16, V v16, K k17, V v17, K k18, V v18) {
        return Map.ofEntries(
                Map.entry(k1, v1),
                Map.entry(k2, v2),
                Map.entry(k3, v3),
                Map.entry(k4, v4),
                Map.entry(k5, v5),
                Map.entry(k6, v6),
                Map.entry(k7, v7),
                Map.entry(k8, v8),
                Map.entry(k9, v9),
                Map.entry(k10, v10),
                Map.entry(k11, v11),
                Map.entry(k12, v12),
                Map.entry(k13, v13),
                Map.entry(k14, v14),
                Map.entry(k15, v15),
                Map.entry(k16, v16),
                Map.entry(k17, v17),
                Map.entry(k18, v18)
        );
    }
}
