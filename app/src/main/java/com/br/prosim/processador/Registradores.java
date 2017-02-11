package com.br.prosim.processador;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @autores Aryan, Carol, Luan e Rodrigo
 */
public class Registradores {
    private String nome;
    public static final int QUANTIDADE_BITS = 16;
    public int valor[] = new int[QUANTIDADE_BITS] ;
    
    public String getNome() {
        return nome;
    }

    public int[] getValor() {
        return valor;
    }

    public void setValor(int[] valor) {
        this.valor = valor;
    }

    public void setNome(String endereço) {
        this.nome = endereço;
    }

    public Registradores(String nome) {
        this.nome = nome;
    }

  public void imprimeRegistrador(Registradores reg){
       System.out.print("Registrador " + reg.nome +": ");
       for (int i = 0; i < reg.valor.length ; i++) {
                  System.out.print("" + reg.valor[i] + " ");
            }
    
      System.out.println("");
  }
}