package com.vincenzo.caio;

import java.io.IOException;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        try {
            Palindromo palindromo = new Palindromo();
            palindromo.executar(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
