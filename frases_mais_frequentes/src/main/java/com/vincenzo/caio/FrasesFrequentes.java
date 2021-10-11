package com.vincenzo.caio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FrasesFrequentes {
    private Scanner scannerLeitura;
    private Map<Integer, String> frasesUnicas;
    private Map<Integer, Integer> frasesContador;
    private Map<Integer, Integer> frasesContadorOrdenado;

    private final static int LINHAS = 50000;

    public FrasesFrequentes() {
        frasesUnicas = new HashMap<>();
        frasesContador = new HashMap<>();
    }

    public void executar() {
        criarArquivo();
        try {
            File file = new File("./resources/frasesFrequentes.txt");
            FileInputStream inputStream = new FileInputStream(file);
            scannerLeitura = new Scanner(inputStream, "UTF-8");
            while (scannerLeitura.hasNextLine()) {
                String linha = scannerLeitura.nextLine();
                String[] frases = linha.split("\\|");
                for (String frase : frases) {
                    int hashCode = frase.hashCode();
                    frasesUnicas.put(hashCode, frase);
                    frasesContador.merge(hashCode, 1, (contador, um) -> contador + 1);
                }
            }
            frasesContadorOrdenado = frasesContador.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(50000).collect(Collectors
                            .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            salvarResultado();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível ler o arquivo com as frases misturadas.");
        }

    }

    public void criarArquivo() {
        List<String> frases = carregarFrases();
        if (frases == null) {
            return;
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("./resources/frasesFrequentes.txt");
            // Criação do arquivo
            for (int i = 0; i < LINHAS; i++) {
                int frasesNaLinha = (int) (Math.random() * 500 + 1);
                for (int j = 0; j < frasesNaLinha; j++) {
                    int random = (int) (Math.random() * frases.size());
                    String frase = frases.get(random);
                    byte[] strToBytes = (frase.concat("|")).getBytes();
                    outputStream.write(strToBytes);
                }
                outputStream.write('\n');
            }

            outputStream.close();
        } catch (IOException e) {
            System.out.println("Não foi possível criar arquivo com frases misturadas.");
        }
    }

    private List<String> carregarFrases() {
        // Arquivo com frases para gerar arquivo com elas misturadas
        File file = new File("./resources/frases.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            List<String> frases = new ArrayList<>();
            scannerLeitura = new Scanner(inputStream, "UTF-8");
            while (scannerLeitura.hasNextLine()) {
                String frase = scannerLeitura.nextLine();
                frases.add(frase);
            }
            return frases;
        } catch (FileNotFoundException e) {
            System.out.println("Nâo foi possível ler arquivo com as frases inciais.");
        }
        return null;
    }

    public FileInputStream lerArquivo() throws FileNotFoundException {
        FileInputStream inputStream = null;
        File file = new File("./resources/frasesFrequentes.txt");
        inputStream = new FileInputStream(file);
        return inputStream;
    }

    public void salvarResultado() {
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream("./resources/frasesResultado.txt");
            frasesContadorOrdenado.forEach((key, value) -> {
                String frase = value + " - " + frasesUnicas.get(key) + '\n';
                byte[] strToBytes = frase.getBytes();
                try {
                    outputStream.write(strToBytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            outputStream.close();
        } catch (IOException e1) {
            System.out.println("Não foi possível criar arquivo para salvar o resultado");
        }
    }
}
