package com.vincenzo.caio;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Palindromo {
    private boolean caseSensitive = false;
    private boolean ignorarEspaco = true;
    private boolean executarPorArquivo = false;
    Scanner scanner;

    public Palindromo() {
        scanner = new Scanner(System.in);
    }

    public void executar(String[] args) throws IOException {
        int escolha = -1;
        while (escolha != 0) {
            exibeMenu();
            escolha = scanner.nextInt();
            System.out.println('\n');
            switch (escolha) {
                case 1:
                    configurar();
                    break;
                case 2:
                    if (this.executarPorArquivo) {
                        this.executarViaArquivo();
                    } else {
                        this.executarViaInput();
                    }
                    break;

                default:
                    break;
            }
            System.out.println('\n');
        }
    }

    public void exibeMenu() {
        System.out.println("1 - Configurar");
        System.out.println("2 - Executar");
        System.out.println("0 - Sair");
    }

    public void exibeMenuConfiguracao() {
        System.out.println("1 - Case Sensitive? " + (this.caseSensitive ? "(S)" : "(N)"));
        System.out.println("2 - Ignorar espaços? " + (this.ignorarEspaco ? "(S)" : "(N)"));
        System.out.println("3 - Executar via leitura de arquivo? " + (this.executarPorArquivo ? "(S)" : "(N)"));
        System.out.println("0 - Voltar");
    }

    public void configurar() {
        int escolha = -1;
        while (escolha != 0) {
            exibeMenuConfiguracao();
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    this.caseSensitive = !this.caseSensitive;
                    break;
                case 2:
                    this.ignorarEspaco = !this.ignorarEspaco;
                    break;
                case 3:
                    this.executarPorArquivo = !this.executarPorArquivo;
                    break;
                default:
                    break;
            }
        }

    }

    public boolean verificaPalindromo(String texto) {
        if (texto == null || texto.length() == 0)
            return false;
        int i = 0;
        if (!this.caseSensitive) {
            texto = texto.toLowerCase();
        }
        if (this.ignorarEspaco) {
            texto = texto.replace(" ", "");
        }
        int j = texto.length() - 1;
        while (i < j) {
            if (texto.charAt(i) != texto.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void executarViaInput() {
        String texto = "";
        while (!texto.equals("0")) {
            System.out.println("Digite um texto (0 para sair): ");
            texto = scanner.nextLine();
            System.out.print("O texto \"" + texto + "\"");
            if (verificaPalindromo(texto)) {
                System.out.println(" é um palíndromo");
            } else {
                System.out.println(" não é um palíndromo");
            }
            System.out.println('\n');
        }
    }

    public void executarViaArquivo() throws IOException {
        FileInputStream inputStream = null;
        Scanner scanner = null;
        inputStream = lerArquivo();
        scanner = new Scanner(inputStream, "UTF-8");
        if (scanner.ioException() != null) {
            scanner.close();
            throw scanner.ioException();
        }
        while (scanner.hasNextLine()) {
            String texto = scanner.nextLine();
            System.out.print("O texto \"" + texto + "\"");
            if (verificaPalindromo(texto)) {
                System.out.println(" é um palíndromo");
            } else {
                System.out.println(" não é um palíndromo");
            }
        }
        scanner.close();
    }

    public FileInputStream lerArquivo() throws FileNotFoundException {
        FileInputStream inputStream = null;
        File file = new File("./resources/palindromo.txt");
        inputStream = new FileInputStream(file);
        return inputStream;
    }
}
