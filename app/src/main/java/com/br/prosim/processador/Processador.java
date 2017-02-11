/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.prosim.processador;

import java.util.Scanner;

/**
 *
 * @autores Aryan, Carol, Luan e Rodrigo
 */
public class Processador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Registradores ax, bx;
        UC uc = new UC();
        //Construções dos Registradores
        ax = new Registradores("AX");
        bx = new Registradores("BX");
        //Setando valor no registrador 
        bx.valor = decimalParaBinario(1, 8);

        //Imprime o valor que está no registrador
        bx.imprimeRegistrador(bx);
        for (int k = 0; k <= 15; k++) {
            //Setando valor no registrador 
            ax.valor = decimalParaBinario(k, 8);
            System.out.println("Antigo valor de AX: ");
            ax.imprimeRegistrador(ax);
            bx.imprimeRegistrador(bx);
            System.out.println("");
            //Envia o comando para a unidade de controle
            uc.setOpcode(1);
            //De acordo com o 'Opcode', a classe UC irá chamar um método da classe
            //ULA
            uc.operacao(ax, bx);
            ax.imprimeRegistrador(ax);

            System.out.println("");
        }
        System.out.println("--------------------------------------------");
        for (int k = 0; k <= 15; k++) {
            ax.valor = decimalParaBinario(k, 8);
            System.out.println("Antigo valor de AX: ");
            ax.imprimeRegistrador(ax);
            bx.imprimeRegistrador(bx);
            System.out.println("");
            uc.setOpcode(2);
            uc.operacao(ax, bx);
            ax.imprimeRegistrador(ax);

            System.out.println("");
        }

        System.out.println("--------------------------------------------");
        ax.valor = decimalParaBinario(6, 8);
        for (int k = 0; k <= 15; k++) {
            bx.valor = decimalParaBinario(k, 8);
            System.out.println("Antigo valor de AX: ");
            bx.imprimeRegistrador(bx);
            ax.imprimeRegistrador(ax);
            System.out.println("");
            uc.setOpcode(3);
            uc.operacao(bx, ax);
            bx.imprimeRegistrador(bx);

            System.out.println("");
        }
        System.out.println("--------------------------------------------");
        ax.valor = decimalParaBinario(5, 8);
        for (int k = 0; k <= 15; k++) {
            bx.valor = decimalParaBinario(k, 8);
            System.out.println("Antigo valor de AX: ");
            bx.imprimeRegistrador(bx);
            ax.imprimeRegistrador(ax);
            System.out.println("");
            uc.setOpcode(4);
            uc.operacao(bx, ax);
            bx.imprimeRegistrador(bx);

            System.out.println("");
        }
        System.out.println("--------------------------------------------");

        ax.imprimeRegistrador(ax);
        bx.imprimeRegistrador(bx);
        System.out.println("");
        uc.setOpcode(5);
        uc.operacao(ax, bx);
        ax.imprimeRegistrador(ax);
        System.out.println("--------------------------------------------");

        ax.imprimeRegistrador(ax);
        bx.imprimeRegistrador(bx);

    }

    //Converte um número decimal para  binário

    public static int[] decimalParaBinario(int decimal, int index) {
        int num = decimal;
        int quociente = 0;
        int cont = index;

        int numeroBinario[] = new int[cont];
        quociente = 0;

        int valorDecimal = num;
        for (int i = cont - 1; i > 0; i--) {
            if (i == 1) {
                numeroBinario[i] = num % 2;
                numeroBinario[i - 1] = num / 2;
            } else {
                numeroBinario[i] = num % 2;
            }
            num = num / 2;
        }

        return numeroBinario;
    }

}
