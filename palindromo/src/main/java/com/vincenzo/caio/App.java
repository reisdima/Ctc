package com.vincenzo.caio;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("Instruções");
        Palindromo palindromo = new Palindromo();
        while (true) {
            String texto = palindromo.obterInput();
            if (texto.equals("0")) {
                break;
            }
            System.out.print("O texto \"" + texto + "\"");
            if (palindromo.verificaPalindromo(texto)) {
                System.out.println(" é um palíndromo");
            } else {
                System.out.println(" não é um palíndromo");
            }
        }
    }

}
