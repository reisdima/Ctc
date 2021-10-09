package com.vincenzo.caio;

import java.util.List;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 5, 4, 5, 6, 7 };
        // int[] a = new int[10];
        ComplementaryPairs complementaryPairs = new ComplementaryPairs();
        List<int[]> pares = complementaryPairs.encontrarPares(5, a);
        for (int[] par : pares) {
            System.out.println(par[0] + ", " + par[1]);
        }
    }
}
