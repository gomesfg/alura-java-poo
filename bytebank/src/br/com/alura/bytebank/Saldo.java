package br.com.alura.bytebank;

import java.util.Scanner;

public class Saldo {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o saldo:");
        var saldo = leitura.nextDouble();
        double percentual = saldo * (10.0 / 100);
        var valorFinal = saldo + percentual;
        System.out.println("O saldo com o reajuste de 10% é: " + valorFinal);
    }
}

