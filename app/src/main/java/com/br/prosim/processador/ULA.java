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
public class ULA {

    int[] bitsRegStatus = {0, 0, 0, 0, 0, 0, 0, 0};

    Registradores regStatus = new Registradores("Status");

    public Registradores somarRegistradores(Registradores reg1, Registradores reg2) {
        int qtdBits = Registradores.QUANTIDADE_BITS;
        bitsRegStatus[1] = 0;
     bitsRegStatus[0] = 0;
     
        boolean resultado = true;
        int saida[] = new int[qtdBits];
        for (int i = qtdBits - 1; i >= 0; i--) {
            System.out.println("reg " + i + ":" + reg1.valor[i]);
            if (i > 0) {
                if (reg1.valor[i] == 2 && reg2.valor[i] == 1) {
                    saida[i] = 1;
                    reg1.valor[i - 1] = reg1.valor[i - 1] + 1;

                } else if (reg1.valor[i] == 1 && reg2.valor[i] == 1
                        || reg1.valor[i] == 2 && reg2.valor[i] == 0) {

                    saida[i] = 0;
                    reg1.valor[i - 1] = reg1.valor[i - 1] + 1;

                } else {
                    saida[i] = reg1.valor[i] + reg2.valor[i];

                }

            } else if (i == 0) {

                if (reg1.valor[i] == 2 && reg2.valor[i] == 1) {
                    saida[i] = 1;
//                    JOptionPane.showMessageDialog(null, "A soma desses dos valores resultou em um overflow",
//                            "Informação", JOptionPane.INFORMATION_MESSAGE);
                    // reg1.valor[i - 1] = reg1.valor[i - 1] + 1;
                    bitsRegStatus[1] = 1;

                } else if (reg1.valor[i] == 1 && reg2.valor[i] == 1
                        || reg1.valor[i] == 2 && reg2.valor[i] == 0) {

                    saida[i] = 0;
//                    JOptionPane.showMessageDialog(null, "A soma desses dos valores resultou em um overflow",
//                            "Informação", JOptionPane.INFORMATION_MESSAGE);
                    // reg1.valor[i - 1] = reg1.valor[i - 1] + 1;
                    //System.out.println("ef: " + reg1.valor[i - 1]);
                    bitsRegStatus[1] = 1;

                } else {
                    saida[i] = reg1.valor[i] + reg2.valor[i];

                }
            }

        }
       
        System.out.println("Instrução ADD");
        System.out.println("Novo valor de " + reg1.getNome());
        reg1.setValor(saida);
        regStatus.setValor(bitsRegStatus);
        regStatus.imprimeRegistrador(regStatus);
        String bitsStr = "";
        for (int i = 0; i < 8; i++) {
            bitsStr += "" + bitsRegStatus[i];
        }
      //  UI_Processador.tfULAStatus.setText(bitsStr);
        return reg1;
    }

    public Registradores incrementar(Registradores reg1) {
        int qtdBits = Registradores.QUANTIDADE_BITS;
        Registradores regIncrementador = new Registradores("Incrementador");
        int incrementador[] = new int[qtdBits];
        reg1.imprimeRegistrador(reg1);
        for (int i = 0; i < qtdBits; i++) {
            if (i < 15) {
                incrementador[i] = 0;
            } else {
                incrementador[i] = 1;
            }
        }
        regIncrementador.setValor(incrementador);
        regIncrementador.imprimeRegistrador(regIncrementador);
        System.out.println("Instrução INC");
        // reg1.setValor(incrementador);
        reg1 = somarRegistradores(reg1, regIncrementador);
        System.out.println("Novo valor de " + reg1.getNome());

        return reg1;
    }

    public Registradores inverter(Registradores reg1) {
        int qtdBits = Registradores.QUANTIDADE_BITS;
        Registradores regDecrementador = new Registradores("Decrementador");
        int regInverte[] = new int[qtdBits];
        reg1.imprimeRegistrador(reg1);
        regDecrementador = reg1;
        regInverte = regDecrementador.getValor();
        for (int i = 0; i < qtdBits; i++) {
            System.out.println("dec.: before " + i + "  = " + regInverte[i]);
            if (regInverte[i] == 0) {
                regInverte[i] = 1;
            } else if (regInverte[i] == 1) {
                regInverte[i] = 0;
            }
            System.out.println("dec.: after " + i + "  = " + regInverte[i]);
        }
        regDecrementador.setValor(regInverte);
        reg1 = regDecrementador;
        System.out.println("Instrução NEG");
        // reg1.setValor(incrementador);

        System.out.println("Novo valor de " + reg1.getNome());

        return reg1;
    }

    public Registradores move(Registradores reg1, Registradores reg2) {
        reg1.valor = reg2.valor;
        System.out.println("Instrução MOVE");
        System.out.println("Novo valor de " + reg1.getNome());

        return reg1;
    }

    public Registradores and(Registradores reg1, Registradores reg2) {
        int saida[] = new int[reg1.valor.length];
        for (int i = 0; i < reg1.valor.length; i++) {
            if (reg1.valor[i] == 1 && reg2.valor[i] == 1) {
                saida[i] = 1;
            } else {
                saida[i] = 0;
            }
        }
        System.out.println("Instrução AND");
        System.out.println("Novo valor de " + reg1.getNome());
        reg1.setValor(saida);
        return reg1;
    }

    public Registradores or(Registradores reg1, Registradores reg2) {
        int saida[] = new int[reg1.valor.length];
        for (int i = 0; i < reg1.valor.length; i++) {
            if (reg1.valor[i] == 0 && reg2.valor[i] == 0) {
                saida[i] = 0;
            } else {
                saida[i] = 1;
            }
        }
        System.out.println("Instrução OR");
        System.out.println("Novo valor de " + reg1.getNome());
        reg1.setValor(saida);
        return reg1;
    }

    public Registradores xor(Registradores reg1, Registradores reg2) {
        int saida[] = new int[reg1.valor.length];
        for (int i = 0; i < reg1.valor.length; i++) {
            if (reg1.valor[i] != reg2.valor[i]) {
                saida[i] = 1;
            } else {
                saida[i] = 0;
            }
        }
        System.out.println("Instrução XOR");
        System.out.println("Novo valor de " + reg1.getNome());
        reg1.setValor(saida);
        return reg1;
    }

    public boolean compare(Registradores reg1, Registradores reg2) {
        boolean resultado = true;
        int i = 0;
        bitsRegStatus[1] = 0;
        do {
            if (reg1.valor[i] != reg2.valor[i]) {
                resultado = false;
            }
            i++;
        } while (i < reg1.valor.length && resultado == true);

        System.out.println("Instrução COMPARE");
        System.out.println("COMPARE: " + resultado);

        if (resultado) {
//            JOptionPane.showMessageDialog(null, "Os dois números são iguais",
//                    "Informação", JOptionPane.INFORMATION_MESSAGE);

            bitsRegStatus[0] = 1;

        } else {
            bitsRegStatus[0] = 0;
//            JOptionPane.showMessageDialog(null, "Os dois números não são iguais",
//                    "Informação", JOptionPane.INFORMATION_MESSAGE);
        }

        regStatus.setValor(bitsRegStatus);
        regStatus.imprimeRegistrador(regStatus);
        String bitsStr = "";
        for (i = 0; i < 8; i++) {
            bitsStr += "" + bitsRegStatus[i];
        }
       // UI_Processador.tfULAStatus.setText(bitsStr);
        return resultado;
    }


    /*public Registradores adicionarValorRegistrador(Registradores reg1, int[] valor, int index ) {
     int saida[] = new int[4];
     for (int i = 0; i < 4; i++) {
     if (i < 3) {
     if (reg1.valor[i] == 2 && valor[i] == 1) {
     saida[i] = 1;
     reg1.valor[i + 1] = reg1.valor[i + 1] + 1;

     } else if (reg1.valor[i] == 1 && valor[i] == 1) {
     if ((reg1.valor[i] == 1 || reg1.valor[i] == 2) && valor[i] == 1) {
     saida[i] = 0;
     reg1.valor[i + 1] = reg1.valor[i + 1] + 1;
     }
     } else {
     saida[i] = reg1.valor[i] + valor[i];
     }
     } else if (reg1.valor[i] == 2 && valor[i] == 1) {
     saida[i] = 1;
     System.out.println("OVERFLOW!");
     } else if (reg1.valor[i] == 1 && valor[i] == 1) {
     if ((reg1.valor[i] == 1 || reg1.valor[i] == 2) && valor[i] == 1) {
     saida[i] = 0;
     System.out.println("OVERFLOW!");
     }
     } else {
     saida[i] = reg1.valor[i] + valor[i];
                
     }
     }
     reg1.setValor(saida);
     return reg1;
     }*/
}
