package com.vincenzo.caio;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("Instruções");
        while (true) {
            String texto = Palindromo.obterInput();
            if (texto.equals("0")) {
                break;
            }
            System.out.print("O texto \"" + texto + "\"");
            if (Palindromo.verificaPalindromo(texto)) {
                System.out.println(" é um palíndromo");
            } else {
                System.out.println(" não é um palíndromo");
            }
        }
    }

}
