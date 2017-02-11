/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.prosim.processador;



/**
 *
 * @autores Aryan, Carol, Luan e Rodrigo
 */
public class UC {

    private int opcode;
    private ULA ula = new ULA();

    public void operacao(Registradores rg1, Registradores rg2) {
        switch (opcode) {
            case 0:
                ula.somarRegistradores(rg1, rg2);
                break;
            case 1:
                ula.and(rg1, rg2);
                break;
            case 2:
                ula.or(rg1, rg2);
                break;
            case 3:
                ula.xor(rg1, rg2);
                break;
            case 4:
                ula.move(rg1, rg2);
                break;
            case 5:
                ula.compare(rg1, rg2);
                break;
            case 6:
                ula.incrementar(rg1);
                break;
            case 7:
                ula.inverter(rg1);
                break;
        }

    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

}
