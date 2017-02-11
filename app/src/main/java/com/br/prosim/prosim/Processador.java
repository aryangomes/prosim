package com.br.prosim.prosim;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

//Modo Binário
public class Processador extends Activity implements View.OnClickListener {
    private final int QUANTIDADE_BITS = 16;
    private ToggleButton bit15, bit14, bit13, bit12, bit11, bit10, bit9, bit8, bit7, bit6,
            bit5, bit4, bit3, bit2, bit1, bit0, bitR215, bitR214, bitR213, bitR212, bitR211, bitR210, bitR29, bitR28,
            bitR27, bitR26, bitR25, bitR24, bitR23, bitR22, bitR21, bitR20;
    private EditText etValorDecimal, etValorDecimal2, etSaida, etSaidaValorDecimal;
    private Button btExecutarOperacao;
    private String[] bitReg1 = new String[QUANTIDADE_BITS];
    private String bitRegistrador1 = "0000000000000000";
    private String[] bitReg2 = new String[QUANTIDADE_BITS];
    private String bitRegistrador2 = "0000000000000000";
    private Spinner spUC;
    private String opcaoSelecionada;
    private int opCode = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processador);
        spUC = (Spinner) findViewById(R.id.spUC);
        ArrayAdapter<String> spOpcoesUC = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line,
                new String[]{"ADD", "AND", "MOVE", "OR", "XOR", "COMPARE", "INC", "NEG"});//, "SUB"});
        spUC.setAdapter(spOpcoesUC);
        etValorDecimal = (EditText) findViewById(R.id.etReg1ValorDecimal);
        etSaida = (EditText) findViewById(R.id.etSaida);
        etSaidaValorDecimal = (EditText) findViewById(R.id.etSaidaValorDecimal);
        btExecutarOperacao = (Button) findViewById(R.id.btExecutarOperacao);

        btExecutarOperacao.setOnClickListener(this);

        bit15 = (ToggleButton) findViewById(R.id.tbBit15);
        bit14 = (ToggleButton) findViewById(R.id.tbBit14);
        bit13 = (ToggleButton) findViewById(R.id.tbBit13);
        bit12 = (ToggleButton) findViewById(R.id.tbBit12);
        bit11 = (ToggleButton) findViewById(R.id.tbBit11);
        bit10 = (ToggleButton) findViewById(R.id.tbBit10);
        bit9 = (ToggleButton) findViewById(R.id.tbBit9);
        bit8 = (ToggleButton) findViewById(R.id.tbBit8);
        bit7 = (ToggleButton) findViewById(R.id.tbBit7);
        bit6 = (ToggleButton) findViewById(R.id.tbBit6);
        bit5 = (ToggleButton) findViewById(R.id.tbBit5);
        bit4 = (ToggleButton) findViewById(R.id.tbBit4);
        bit3 = (ToggleButton) findViewById(R.id.tbBit3);
        bit2 = (ToggleButton) findViewById(R.id.tbBit2);
        bit1 = (ToggleButton) findViewById(R.id.tbBit1);
        bit0 = (ToggleButton) findViewById(R.id.tbBit0);
        bit15.setOnClickListener(this);
        bit14.setOnClickListener(this);
        bit13.setOnClickListener(this);
        bit11.setOnClickListener(this);
        bit12.setOnClickListener(this);
        bit10.setOnClickListener(this);
        bit9.setOnClickListener(this);
        bit8.setOnClickListener(this);
        bit7.setOnClickListener(this);
        bit8.setOnClickListener(this);
        bit6.setOnClickListener(this);
        bit5.setOnClickListener(this);
        bit4.setOnClickListener(this);
        bit3.setOnClickListener(this);
        bit2.setOnClickListener(this);
        bit1.setOnClickListener(this);
        bit0.setOnClickListener(this);

        etValorDecimal2 = (EditText) findViewById(R.id.etReg2ValorDecimal);
        bitR215 = (ToggleButton) findViewById(R.id.tb2Bit15);
        bitR214 = (ToggleButton) findViewById(R.id.tb2Bit14);
        bitR213 = (ToggleButton) findViewById(R.id.tb2Bit13);
        bitR212 = (ToggleButton) findViewById(R.id.tb2Bit12);
        bitR211 = (ToggleButton) findViewById(R.id.tb2Bit11);
        bitR210 = (ToggleButton) findViewById(R.id.tb2Bit10);
        bitR29 = (ToggleButton) findViewById(R.id.tb2Bit9);
        bitR28 = (ToggleButton) findViewById(R.id.tb2Bit8);
        bitR27 = (ToggleButton) findViewById(R.id.tb2Bit7);
        bitR26 = (ToggleButton) findViewById(R.id.tb2Bit6);
        bitR25 = (ToggleButton) findViewById(R.id.tb2Bit5);
        bitR24 = (ToggleButton) findViewById(R.id.tb2Bit4);
        bitR23 = (ToggleButton) findViewById(R.id.tb2Bit3);
        bitR22 = (ToggleButton) findViewById(R.id.tb2Bit2);
        bitR21 = (ToggleButton) findViewById(R.id.tb2Bit1);
        bitR20 = (ToggleButton) findViewById(R.id.tb2Bit0);
        bitR215.setOnClickListener(this);
        bitR214.setOnClickListener(this);
        bitR213.setOnClickListener(this);
        bitR211.setOnClickListener(this);
        bitR212.setOnClickListener(this);
        bitR210.setOnClickListener(this);
        bitR29.setOnClickListener(this);
        bitR28.setOnClickListener(this);
        bitR27.setOnClickListener(this);
        bitR28.setOnClickListener(this);
        bitR26.setOnClickListener(this);
        bitR25.setOnClickListener(this);
        bitR24.setOnClickListener(this);
        bitR23.setOnClickListener(this);
        bitR22.setOnClickListener(this);
        bitR21.setOnClickListener(this);
        bitR20.setOnClickListener(this);

        if (Build.VERSION.SDK_INT < 11) {
            this.setTheme(R.style.SpinnerItemforlowerlv11);
        }

        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            bitReg1[i] = "0";
            bitReg2[i] = "0";
        }

        bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
        bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);

        //Log.i("bitReg1", bitRegistrador1);


        spUC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                opcaoSelecionada = spUC.getItemAtPosition(0)
                        .toString();
                opcaoSelecionada = spUC.getSelectedItem()
                        .toString();
                opCode = spUC.getSelectedItemPosition();
                Log.i("opCode", "" + opCode);
                //etSaida.setText(opcaoSelecionada);

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        etValorDecimal.setOnKeyListener(new View.OnKeyListener() {
            @TargetApi(Build.VERSION_CODES.GINGERBREAD)
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!((etValorDecimal.getText().toString()).isEmpty())) {
                    int valorMax = Integer.parseInt(etValorDecimal.getText().toString());
                    if (valorMax <= 65535) {
                        bitReg1 = atualizarRegistradorDeEditTextParaToggleButton
                                (decimalParaBinarioString(etValorDecimal.getText().toString()));
                        Log.i("etValorDecimal.getText()", etValorDecimal.getText().toString());
                        atualizarTGRegistrador1(bitReg1);
                        bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Digite um valor menor que 65535", Toast.LENGTH_SHORT).show();
                        etValorDecimal.setText(null);
                        bit15.setChecked(false);
                        bit14.setChecked(false);
                        bit13.setChecked(false);
                        bit12.setChecked(false);
                        bit11.setChecked(false);
                        bit10.setChecked(false);
                        bit9.setChecked(false);
                        bit8.setChecked(false);
                        bit7.setChecked(false);
                        bit6.setChecked(false);
                        bit5.setChecked(false);
                        bit4.setChecked(false);
                        bit3.setChecked(false);
                        bit2.setChecked(false);
                        bit1.setChecked(false);
                        bit0.setChecked(false);
                    }
                } else {
                    bit15.setChecked(false);
                    bit14.setChecked(false);
                    bit13.setChecked(false);
                    bit12.setChecked(false);
                    bit11.setChecked(false);
                    bit10.setChecked(false);
                    bit9.setChecked(false);
                    bit8.setChecked(false);
                    bit7.setChecked(false);
                    bit6.setChecked(false);
                    bit5.setChecked(false);
                    bit4.setChecked(false);
                    bit3.setChecked(false);
                    bit2.setChecked(false);
                    bit1.setChecked(false);
                    bit0.setChecked(false);
                }

                return false;
            }
        });

        etValorDecimal2.setOnKeyListener(new View.OnKeyListener() {
            @TargetApi(Build.VERSION_CODES.GINGERBREAD)
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!((etValorDecimal2.getText().toString()).isEmpty())) {
                    int valorMax = Integer.parseInt(etValorDecimal2.getText().toString());
                    if (valorMax <= 65535) {
                        bitReg2 = atualizarRegistradorDeEditTextParaToggleButton
                                (decimalParaBinarioString(etValorDecimal2.getText().toString()));
                        Log.i("etValorDecimal.getText()", etValorDecimal2.getText().toString());
                        atualizarTGRegistrador2(bitReg2);
                        bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Digite um valor menor que 65535", Toast.LENGTH_SHORT).show();
                        etValorDecimal2.setText(null);
                        bitR215.setChecked(false);
                        bitR214.setChecked(false);
                        bitR213.setChecked(false);
                        bitR212.setChecked(false);
                        bitR211.setChecked(false);
                        bitR210.setChecked(false);
                        bitR29.setChecked(false);
                        bitR28.setChecked(false);
                        bitR27.setChecked(false);
                        bitR26.setChecked(false);
                        bitR25.setChecked(false);
                        bitR24.setChecked(false);
                        bitR23.setChecked(false);
                        bitR22.setChecked(false);
                        bitR21.setChecked(false);
                        bitR20.setChecked(false);
                    }
                } else {
                    bitR215.setChecked(false);
                    bitR214.setChecked(false);
                    bitR213.setChecked(false);
                    bitR212.setChecked(false);
                    bitR211.setChecked(false);
                    bitR210.setChecked(false);
                    bitR29.setChecked(false);
                    bitR28.setChecked(false);
                    bitR27.setChecked(false);
                    bitR26.setChecked(false);
                    bitR25.setChecked(false);
                    bitR24.setChecked(false);
                    bitR23.setChecked(false);
                    bitR22.setChecked(false);
                    bitR21.setChecked(false);
                    bitR20.setChecked(false);
                }

                return false;
            }
        });


    }


    protected String atualizarEditTextSaida(int[] bitReg) {
        String bitRegistrador = "";
        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            bitRegistrador += "" + bitReg[i];
        }
        return bitRegistrador;

    }

    protected String atualizarRegistradorDeToggleButtonParaEditText(String[] bitReg) {
        String bitRegistrador = "";
        for (int i = QUANTIDADE_BITS - 1; i >= 0; i--) {
            bitRegistrador += bitReg[i];
        }
        return bitRegistrador;

    }

    protected String[] atualizarRegistradorDeEditTextParaToggleButton(String bitRegTv) {
        String[] bitRegistradorTg = new String[QUANTIDADE_BITS];
        for (int i = QUANTIDADE_BITS - 1; i >= 0; i--) {
            bitRegistradorTg[i] = bitRegTv.substring(i, i + 1);
            //Log.i("bitRegTv.substring(i,1)", bitRegTv.substring(i, i + 1));
        }
        return bitRegistradorTg;

    }


    protected void atualizarTGRegistrador1(String[] bitReg) {
        if (bitReg[15].equals("1")) {
            bit15.setChecked(true);
        } else {
            bit15.setChecked(false);
        }
        if (bitReg[14].equals("1")) {
            bit14.setChecked(true);
        } else {
            bit14.setChecked(false);
        }
        if (bitReg[13].equals("1")) {
            bit13.setChecked(true);
        } else {
            bit13.setChecked(false);
        }
        if (bitReg[12].equals("1")) {
            bit12.setChecked(true);
        } else {
            bit12.setChecked(false);
        }
        if (bitReg[11].equals("1")) {
            bit11.setChecked(true);
        } else {
            bit11.setChecked(false);
        }
        if (bitReg[10].equals("1")) {
            bit10.setChecked(true);
        } else {
            bit10.setChecked(false);
        }
        if (bitReg[9].equals("1")) {
            bit9.setChecked(true);
        } else {
            bit9.setChecked(false);
        }
        if (bitReg[8].equals("1")) {
            bit8.setChecked(true);
        } else {
            bit8.setChecked(false);
        }
        if (bitReg[7].equals("1")) {
            bit7.setChecked(true);
        } else {
            bit7.setChecked(false);
        }
        if (bitReg[6].equals("1")) {
            bit6.setChecked(true);
        } else {
            bit6.setChecked(false);
        }
        if (bitReg[5].equals("1")) {
            bit5.setChecked(true);
        } else {
            bit5.setChecked(false);
        }
        if (bitReg[4].equals("1")) {
            bit4.setChecked(true);
        } else {
            bit4.setChecked(false);
        }
        if (bitReg[3].equals("1")) {
            bit3.setChecked(true);
        } else {
            bit3.setChecked(false);
        }
        if (bitReg[2].equals("1")) {
            bit2.setChecked(true);
        } else {
            bit2.setChecked(false);
        }
        if (bitReg[1].equals("1")) {
            bit1.setChecked(true);
        } else {
            bit1.setChecked(false);
        }
        if (bitReg[0].equals("1")) {
            bit0.setChecked(true);
        } else {
            bit0.setChecked(false);
        }


    }

    protected void atualizarTGRegistrador2(String[] bitReg) {
        if (bitReg[15].equals("1")) {
            bitR215.setChecked(true);
        } else {
            bitR215.setChecked(false);
        }
        if (bitReg[14].equals("1")) {
            bitR214.setChecked(true);
        } else {
            bitR214.setChecked(false);
        }
        if (bitReg[13].equals("1")) {
            bitR213.setChecked(true);
        } else {
            bitR213.setChecked(false);
        }
        if (bitReg[12].equals("1")) {
            bitR212.setChecked(true);
        } else {
            bitR212.setChecked(false);
        }
        if (bitReg[11].equals("1")) {
            bitR211.setChecked(true);
        } else {
            bitR211.setChecked(false);
        }
        if (bitReg[10].equals("1")) {
            bitR210.setChecked(true);
        } else {
            bitR210.setChecked(false);
        }
        if (bitReg[9].equals("1")) {
            bitR29.setChecked(true);
        } else {
            bitR29.setChecked(false);
        }
        if (bitReg[8].equals("1")) {
            bitR28.setChecked(true);
        } else {
            bitR28.setChecked(false);
        }
        if (bitReg[7].equals("1")) {
            bitR27.setChecked(true);
        } else {
            bitR27.setChecked(false);
        }
        if (bitReg[6].equals("1")) {
            bitR26.setChecked(true);
        } else {
            bitR26.setChecked(false);
        }
        if (bitReg[5].equals("1")) {
            bitR25.setChecked(true);
        } else {
            bitR25.setChecked(false);
        }
        if (bitReg[4].equals("1")) {
            bitR24.setChecked(true);
        } else {
            bitR24.setChecked(false);
        }
        if (bitReg[3].equals("1")) {
            bitR23.setChecked(true);
        } else {
            bitR23.setChecked(false);
        }
        if (bitReg[2].equals("1")) {
            bitR22.setChecked(true);
        } else {
            bitR22.setChecked(false);
        }
        if (bitReg[1].equals("1")) {
            bitR21.setChecked(true);
        } else {
            bitR21.setChecked(false);
        }
        if (bitReg[0].equals("1")) {
            bitR20.setChecked(true);
        } else {
            bitR20.setChecked(false);
        }


    }

    protected String decimalParaBinarioString(String decimal) {
        int num = Integer.parseInt(decimal);
        int cont = QUANTIDADE_BITS;
        String nBinario = "";
        int numeroBinario[] = new int[cont];


        for (int i = 0; i < cont; i++) {
            if (i == 14) {
                numeroBinario[i] = num % 2;
                numeroBinario[i + 1] = num / 2;
            } else {
                numeroBinario[i] = num % 2;
            }
            num = num / 2;
        }

        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            nBinario += numeroBinario[i];
            //Log.i("numeroBinario[" + i + "]", "" + numeroBinario[i]);
        }
        return nBinario;
    }


    int binarioParaDecimalString(String binario) {
        int decimal = 0;
        String binario2 = "";
        for (int i = QUANTIDADE_BITS - 1; i >= 0; i--) {
            binario2 += binario.substring(i, (i + 1));
        }

        String digitos[] = new String[QUANTIDADE_BITS];
        //int digitos[] = new int[8];
        //System.out.println("binario: " + binario2);
        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            //System.out.println("í: " + i);
            if (i < QUANTIDADE_BITS - 1) {
                // digitos[i] = Integer.parseInt(binario.substring(i, (i -1)));
                digitos[i] = (binario2.substring(i, (i + 1)));
                // System.out.println("digito1 "+i+" :" + digitos[i]);
            } else {
                //digitos[i] = Integer.parseInt(binario.substring(0));
                digitos[i] = (binario2.substring(i));
                // System.out.println("digito2 "+i+" :" + digitos[i]);

            }
            if (digitos[i].equals("1")) {
                decimal += Math.pow(2, i);
                /* System.out.println("i: "+ i);
                 System.out.println("decimal i : "+ digitos[i]);
                 */
            }
        }
        //System.out.println("decimal : "+ decimal);
        return decimal;
    }

    protected void operacao(int optionCode) {
        switch (optionCode) {
            case 0:
                //ADD
                etSaida.setText(atualizarEditTextSaida(add(bitRegistrador1, bitRegistrador2, optionCode)));
                break;
            case 1:
                //AND
                etSaida.setText(atualizarEditTextSaida(and(bitRegistrador1, bitRegistrador2)));
                break;
            case 2:
                //MOVE
                move();
                etSaida.setText("0000000000000000");
                break;
            case 3:
                //OR
                etSaida.setText(atualizarEditTextSaida(or(bitRegistrador1, bitRegistrador2)));
                break;
            case 4:
                //XOR
                etSaida.setText(atualizarEditTextSaida(xor(bitRegistrador1, bitRegistrador2)));
                break;
            case 5:
                //COMPARE
                if (compare(bitRegistrador1, bitRegistrador2)) {
                    etSaida.setText("OS 2 VALORES SÃO IGUAIS");
                    etSaidaValorDecimal.setText("OS 2 VALORES SÃO IGUAIS");
                } else {
                    etSaida.setText("OS 2 VALORES NÃO SÃO IGUAIS");
                    etSaidaValorDecimal.setText("OS 2 VALORES NÃO SÃO IGUAIS");
                }
                break;
            case 6:
                //INC
                etSaida.setText(atualizarEditTextSaida(inc(bitRegistrador1)));
                break;
            case 7:
                //NEG
                etSaida.setText(atualizarEditTextSaida(neg(bitRegistrador1)));
                break;
//            case 8:
//                //SUB
//                etSaida.setText(atualizarEditTextSaida(sub(bitRegistrador1, bitRegistrador2)));
//                break;
        }
        if (optionCode != 5) {
            etSaidaValorDecimal.setText("" + binarioParaDecimalString(etSaida.getText().toString()));
        }
    }


    protected int[] deStringParaVetorInteiro(String valor) {
        int saida[] = new int[QUANTIDADE_BITS];
        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            if (i < QUANTIDADE_BITS - 1) {
                saida[i] = Integer.parseInt(valor.substring(i, (i + 1)));

            } else {
                saida[i] = Integer.parseInt(valor.substring(i));
            }
        }
        return saida;
    }

    protected int[] add(String valor1, String valor2, int opcode) {
        int reg1[];
        int reg2[];
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);
        Log.i("[add]opcode", "" + opcode);
        int saida[] = new int[QUANTIDADE_BITS];
        for (int i = QUANTIDADE_BITS - 1; i >= 0; i--) {
            if (i > 0) {
                if (reg1[i] == 2 && reg2[i] == 1) {
                    saida[i] = 1;
                    reg1[i - 1] = reg1[i - 1] + 1;
                } else if (reg1[i] == 1 && reg2[i] == 1
                        || reg1[i] == 2 && reg2[i] == 0) {
                    saida[i] = 0;
                    reg1[i - 1] = reg1[i - 1] + 1;
                } else {
                    saida[i] = reg1[i] + reg2[i];
                }
            } else if (i == 0) {
                if (reg1[i] == 2 && reg2[i] == 1) {
                    Log.i("[add]opcode2", "" + opcode);
                    saida[i] = 1;
                    if (opcode == 0) {
                        Toast.makeText(getApplicationContext(),
                                "A soma desses dos valores resultou em um overflow", Toast.LENGTH_SHORT).show();
                    }
                } else if (reg1[i] == 1 && reg2[i] == 1
                        || reg1[i] == 2 && reg2[i] == 0
                        ) {
                    Log.i("[add]opcode2", "" + opcode);
                    saida[i] = 0;
                    if (opcode == 0) {
                        Toast.makeText(getApplicationContext(),
                                "A soma desses dos valores resultou em um overflow", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    saida[i] = reg1[i] + reg2[i];
                }
            }
        }
        return saida;
    }

    protected int[] and(String valor1, String valor2) {
        int saida[] = new int[QUANTIDADE_BITS];
        int reg1[] = new int[QUANTIDADE_BITS];
        int reg2[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);


        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            if (reg1[i] == 1 && reg2[i] == 1) {
                saida[i] = 1;
            } else {
                saida[i] = 0;
            }
        }
        return saida;
    }

    protected int[] or(String valor1, String valor2) {
        int saida[] = new int[QUANTIDADE_BITS];
        int reg1[] = new int[QUANTIDADE_BITS];
        int reg2[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);

        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            if (reg1[i] == 0 && reg2[i] == 0) {
                saida[i] = 0;
            } else {
                saida[i] = 1;
            }
        }

        return saida;
    }


    protected int[] xor(String valor1, String valor2) {
        int saida[] = new int[QUANTIDADE_BITS];
        int reg1[] = new int[QUANTIDADE_BITS];
        int reg2[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);
        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            if (reg1[i] != reg2[i]) {
                saida[i] = 1;
            } else {
                saida[i] = 0;
            }
        }

        return saida;
    }


    protected boolean compare(String valor1, String valor2) {
        boolean resultado = true;
        int i = 0;
        int reg1[] = new int[QUANTIDADE_BITS];
        int reg2[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);
        do {
            if (reg1[i] != reg2[i]) {
                resultado = false;
            }
            i++;
        } while (i < QUANTIDADE_BITS && resultado == true);


        return resultado;
    }

    protected void move() {
        bitR215.setChecked(bit15.isChecked());
        bitR214.setChecked(bit14.isChecked());
        bitR213.setChecked(bit13.isChecked());
        bitR212.setChecked(bit12.isChecked());
        bitR211.setChecked(bit11.isChecked());
        bitR210.setChecked(bit10.isChecked());
        bitR29.setChecked(bit9.isChecked());
        bitR28.setChecked(bit8.isChecked());
        bitR27.setChecked(bit7.isChecked());
        bitR26.setChecked(bit6.isChecked());
        bitR25.setChecked(bit5.isChecked());
        bitR24.setChecked(bit4.isChecked());
        bitR23.setChecked(bit3.isChecked());
        bitR22.setChecked(bit2.isChecked());
        bitR21.setChecked(bit1.isChecked());
        bitR20.setChecked(bit0.isChecked());
        bitRegistrador2 = bitRegistrador1;
        bitReg2 = bitReg1;
        etValorDecimal2.setText(etValorDecimal.getText().toString());
    }


    protected int[] neg(String valor1) {
        int reg1[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        int regInverte[] = new int[QUANTIDADE_BITS];


        regInverte = reg1;
        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            if (regInverte[i] == 0) {
                regInverte[i] = 1;
            } else if (regInverte[i] == 1) {
                regInverte[i] = 0;
            }
        }
        return regInverte;
    }

    protected int[] inc(String valor1) {
        int reg1[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        int incrementador[] = new int[QUANTIDADE_BITS];

        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            if (i < 15) {
                incrementador[i] = 0;
            } else {
                incrementador[i] = 1;
            }
        }


        return add(valor1, atualizarEditTextSaida(incrementador), 1);
    }

    protected int[] sub(String valor1, String valor2) {
        int saida[] = new int[QUANTIDADE_BITS];
        int reg2[] = new int[QUANTIDADE_BITS];
        reg2 = neg(valor2);
        reg2 = inc(atualizarEditTextSaida(reg2));
        saida = add(valor1, atualizarEditTextSaida(reg2), 1);
        if(binarioParaDecimalString(valor2) > binarioParaDecimalString(valor1)){
            saida = neg(atualizarEditTextSaida(saida));
            saida = inc(atualizarEditTextSaida(saida));
        }

        return saida;
    }

    protected void limpar() {
        bit15.setChecked(false);
        bit14.setChecked(false);
        bit13.setChecked(false);
        bit12.setChecked(false);
        bit11.setChecked(false);
        bit10.setChecked(false);
        bit9.setChecked(false);
        bit8.setChecked(false);
        bit7.setChecked(false);
        bit6.setChecked(false);
        bit5.setChecked(false);
        bit4.setChecked(false);
        bit3.setChecked(false);
        bit2.setChecked(false);
        bit1.setChecked(false);
        bit0.setChecked(false);

        bitR215.setChecked(false);
        bitR214.setChecked(false);
        bitR213.setChecked(false);
        bitR212.setChecked(false);
        bitR211.setChecked(false);
        bitR210.setChecked(false);
        bitR29.setChecked(false);
        bitR28.setChecked(false);
        bitR27.setChecked(false);
        bitR26.setChecked(false);
        bitR25.setChecked(false);
        bitR24.setChecked(false);
        bitR23.setChecked(false);
        bitR22.setChecked(false);
        bitR21.setChecked(false);
        bitR20.setChecked(false);

        etSaida.setText("0000000000000000");
        etSaidaValorDecimal.setText("0");
        spUC.setSelection(0);
        etValorDecimal.setText("0");
        etValorDecimal2.setText("0");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tbBit15:
                if (bit15.isChecked()) {
                    bitReg1[15] = "1";
                } else {
                    bitReg1[15] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit14:
                if (bit14.isChecked()) {
                    bitReg1[14] = "1";
                } else {
                    bitReg1[14] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit13:
                if (bit13.isChecked()) {
                    bitReg1[13] = "1";
                } else {
                    bitReg1[13] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit12:
                if (bit12.isChecked()) {
                    bitReg1[12] = "1";
                } else {
                    bitReg1[12] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit11:
                if (bit11.isChecked()) {
                    bitReg1[11] = "1";
                } else {
                    bitReg1[11] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit10:
                if (bit10.isChecked()) {
                    bitReg1[10] = "1";
                } else {
                    bitReg1[10] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit9:
                if (bit9.isChecked()) {
                    bitReg1[9] = "1";
                } else {
                    bitReg1[9] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit8:
                if (bit8.isChecked()) {
                    bitReg1[8] = "1";
                } else {
                    bitReg1[8] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit7:
                if (bit7.isChecked()) {
                    bitReg1[7] = "1";
                } else {
                    bitReg1[7] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit6:
                if (bit6.isChecked()) {
                    bitReg1[6] = "1";
                } else {
                    bitReg1[6] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit5:
                if (bit5.isChecked()) {
                    bitReg1[5] = "1";
                } else {
                    bitReg1[5] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit4:
                if (bit4.isChecked()) {
                    bitReg1[4] = "1";
                } else {
                    bitReg1[4] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit3:
                if (bit3.isChecked()) {
                    bitReg1[3] = "1";
                } else {
                    bitReg1[3] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;
            case R.id.tbBit2:
                if (bit2.isChecked()) {
                    bitReg1[2] = "1";
                } else {
                    bitReg1[2] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;

            case R.id.tbBit1:
                if (bit1.isChecked()) {
                    bitReg1[1] = "1";
                } else {
                    bitReg1[1] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;

            case R.id.tbBit0:
                if (bit0.isChecked()) {
                    bitReg1[0] = "1";
                } else {
                    bitReg1[0] = "0";
                }
                bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
                Log.i("bitReg1", bitRegistrador1);
                break;

            case R.id.tb2Bit15:
                if (bitR215.isChecked()) {
                    bitReg2[15] = "1";
                } else {
                    bitReg2[15] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit14:
                if (bitR214.isChecked()) {
                    bitReg2[14] = "1";
                } else {
                    bitReg2[14] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit13:
                if (bitR213.isChecked()) {
                    bitReg2[13] = "1";
                } else {
                    bitReg2[13] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit12:
                if (bitR212.isChecked()) {
                    bitReg2[12] = "1";
                } else {
                    bitReg2[12] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit11:
                if (bitR211.isChecked()) {
                    bitReg2[11] = "1";
                } else {
                    bitReg2[11] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit10:
                if (bitR210.isChecked()) {
                    bitReg2[10] = "1";
                } else {
                    bitReg2[10] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit9:
                if (bitR29.isChecked()) {
                    bitReg2[9] = "1";
                } else {
                    bitReg2[9] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit8:
                if (bitR28.isChecked()) {
                    bitReg2[8] = "1";
                } else {
                    bitReg2[8] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit7:
                if (bitR27.isChecked()) {
                    bitReg2[7] = "1";
                } else {
                    bitReg2[7] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit6:
                if (bitR26.isChecked()) {
                    bitReg2[6] = "1";
                } else {
                    bitReg2[6] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit5:
                if (bitR25.isChecked()) {
                    bitReg2[5] = "1";
                } else {
                    bitReg2[5] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit4:
                if (bitR24.isChecked()) {
                    bitReg2[4] = "1";
                } else {
                    bitReg2[4] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit3:
                if (bitR23.isChecked()) {
                    bitReg2[3] = "1";
                } else {
                    bitReg2[3] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit2:
                if (bitR22.isChecked()) {
                    bitReg2[2] = "1";
                } else {
                    bitReg2[2] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;

            case R.id.tb2Bit1:
                if (bitR21.isChecked()) {
                    bitReg2[1] = "1";
                } else {
                    bitReg2[1] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;

            case R.id.tb2Bit0:
                if (bitR20.isChecked()) {
                    bitReg2[0] = "1";
                } else {
                    bitReg2[0] = "0";
                }
                bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.btExecutarOperacao:
                operacao(opCode);
                break;

        }

        etValorDecimal.setText("" + binarioParaDecimalString(bitRegistrador1));
        etValorDecimal2.setText("" + binarioParaDecimalString(bitRegistrador2));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_processador, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.itMenu_Processador:
                limpar();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_processador, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
