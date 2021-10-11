package com.vincenzo.caio;

import java.io.IOException;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        FrasesFrequentes frasesFrequentes = new FrasesFrequentes();
        try {
            frasesFrequentes.executar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
