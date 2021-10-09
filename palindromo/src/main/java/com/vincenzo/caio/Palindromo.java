package com.vincenzo.caio;

import java.util.Scanner;

public class Palindromo {
    public Palindromo() {
    }

    public boolean verificaPalindromo(String texto) {
        int i = 0;
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

    public String obterInput() {
        Scanner scanner = new Scanner(System.in);
        String texto = "";
        System.out.println("Digite um texto: ");
        texto = scanner.nextLine();
        while (texto != null && texto.equals("")) {
            System.out.println("O texto informado está vazio. Digite um texto:");
            texto = scanner.nextLine();
        }
        return texto;
    }
}
