package com.vincenzo.caio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrasesFrequentes {
    Scanner scannerLeitura;
    Scanner scannerEscrita;
    Map<Integer, String> frasesUnicas;
    Map<Integer, Integer> frasesContador;

    public FrasesFrequentes() {
        frasesUnicas = new HashMap<>();
        frasesContador = new HashMap<>();
    }

    public void executar() {
        // criarArquivo();
        try {
            FileInputStream inputStream = lerArquivo();
            scannerLeitura = new Scanner(inputStream, "UTF-8");
            // while (scannerLeitura.hasNextLine()) {
            String linha = scannerLeitura.nextLine();
            System.out.println("Linha: ");
            System.out.println(linha);
            String[] frases = linha.split("\\|");
            for (String frase : frases) {
                System.out.println("Frase: ");
                System.out.println(frase);
                // String hashCode = geraHashCode(frase);
                int hashCode = frase.hashCode();
                frasesUnicas.put(hashCode, frase);
                frasesContador.merge(hashCode, 1, (contador, um) -> contador + 1);
            }
            // }
            System.out.println("Frases Únicas: ");
            frasesUnicas.forEach((key, value) -> System.out.println(key + ":" + value));
            System.out.println('\n');
            System.out.println("Frases contador: ");
            frasesContador.forEach((key, value) -> System.out.println(key + ":" + value));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String geraHashCode(String frase) {
        return "";
    }

    public void criarArquivo() {

    }

    public FileInputStream lerArquivo() throws FileNotFoundException {
        FileInputStream inputStream = null;
        File file = new File("./resources/frasesFrequentes.txt");
        inputStream = new FileInputStream(file);
        return inputStream;
    }
}
