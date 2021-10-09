package com.vincenzo.caio;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ComplementaryPairs {
    public ComplementaryPairs() {

    }

    public List<int[]> encontrarPares(int k, int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Map<Integer, Integer> valoresUnicos = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            valoresUnicos.merge(k - array[i], 1, Integer::sum);
        }
        List<int[]> pares = new ArrayList<>();
        // valoresUnicos.forEach((key, value) -> System.out.println(key + ":" + value));

        valoresUnicos.forEach((chave, valor) -> {
            int diferenca = k - chave;
            if (valoresUnicos.get(diferenca) != null) {

                int[] par = { chave, diferenca };
                pares.add(par);
            }
        });
        return pares;
    }
}
