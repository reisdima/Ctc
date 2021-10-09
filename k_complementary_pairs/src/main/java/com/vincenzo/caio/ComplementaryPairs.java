package com.vincenzo.caio;

import java.util.List;
import java.util.ArrayList;

public class ComplementaryPairs {
    public ComplementaryPairs() {

    }

    public List<int[]> encontrarPares(int K, int[] array) {
        int n = array.length;
        List<int[]> pares = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] + array[j] == K) {
                    int[] par = { array[i], array[j] };
                    pares.add(par);
                }
            }
        }
        return pares;
    }
}
