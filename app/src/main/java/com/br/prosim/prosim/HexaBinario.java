package com.br.prosim.prosim;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
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
import android.widget.Toast;
import android.widget.ToggleButton;

//Modo Hexadecimal para Binário
public class HexaBinario extends Activity implements View.OnClickListener {
    private final int QUANTIDADE_BITSHEXADECIMAL = 4;
    private final int QUANTIDADE_BITS = 16;
    private ToggleButton bit15, bit14, bit13, bit12, bit11, bit10, bit9, bit8, bit7, bit6,
            bit5, bit4, bit3, bit2, bit1, bit0, bitR215, bitR214, bitR213, bitR212, bitR211, bitR210, bitR29, bitR28,
            bitR27, bitR26, bitR25, bitR24, bitR23, bitR22, bitR21, bitR20;
    private EditText etValorDecimal, etValorDecimal2, etSaidaValorDecimal;
    private Button btExecutarOperacao;
    private String[] bitReg1 = new String[QUANTIDADE_BITS];
    private String bitRegistrador1 = "0000000000000000";
    private String[] bitReg2 = new String[QUANTIDADE_BITS];
    private String bitRegistrador2 = "0000000000000000";

    private int opCodeHexaBinario = 0;
    private String[] valoresHexadecimais = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
            "B", "C", "D", "E", "F"};
    private Spinner spUCHexaBinario, sp1Hexadecimal1, sp1Hexadecimal2, sp1Hexadecimal3, sp1Hexadecimal4,
            sp2Hexadecimal1, sp2Hexadecimal2, sp2Hexadecimal3, sp2Hexadecimal4;
    private String hex14, hex13, hex12, hex11, hex24, hex23, hex22, hex21,
            ophex14, ophex13, ophex12, ophex11, ophex24, ophex23, ophex22, ophex21;
    private int[] binario1 = new int[QUANTIDADE_BITS];
    private int[] binario2 = new int[QUANTIDADE_BITS];
    private int[] valoresSpinnersHexadecimal = new int[QUANTIDADE_BITSHEXADECIMAL];
    private int[] valoresSpinnersHexadecimal2 = new int[QUANTIDADE_BITSHEXADECIMAL];

    private int[] aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexabinario);
        spUCHexaBinario = (Spinner) findViewById(R.id.spUCHexaBinario);
        ArrayAdapter<String> spOpcoesUC = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line,
                new String[]{"ADD", "AND", "MOVE", "OR", "XOR", "COMPARE", "INC", "NEG"});//, "SUB"});
        spUCHexaBinario.setAdapter(spOpcoesUC);


        etSaidaValorDecimal = (EditText) findViewById(R.id.etSaidaValorDecimalHexaBinario);
        btExecutarOperacao = (Button) findViewById(R.id.btExecutarOperacaoHexaBinario);

        btExecutarOperacao.setOnClickListener(this);


        bit15 = (ToggleButton) findViewById(R.id.tbBit15Binario);
        bit14 = (ToggleButton) findViewById(R.id.tbBit14Binario);
        bit13 = (ToggleButton) findViewById(R.id.tbBit13Binario);
        bit12 = (ToggleButton) findViewById(R.id.tbBit12Binario);
        bit11 = (ToggleButton) findViewById(R.id.tbBit11Binario);
        bit10 = (ToggleButton) findViewById(R.id.tbBit10Binario);
        bit9 = (ToggleButton) findViewById(R.id.tbBit9Binario);
        bit8 = (ToggleButton) findViewById(R.id.tbBit8Binario);
        bit7 = (ToggleButton) findViewById(R.id.tbBit7Binario);
        bit6 = (ToggleButton) findViewById(R.id.tbBit6Binario);
        bit5 = (ToggleButton) findViewById(R.id.tbBit5Binario);
        bit4 = (ToggleButton) findViewById(R.id.tbBit4Binario);
        bit3 = (ToggleButton) findViewById(R.id.tbBit3Binario);
        bit2 = (ToggleButton) findViewById(R.id.tbBit2Binario);
        bit1 = (ToggleButton) findViewById(R.id.tbBit1Binario);
        bit0 = (ToggleButton) findViewById(R.id.tbBit0Binario);
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

        bitR215 = (ToggleButton) findViewById(R.id.tb2Bit15Binario);
        bitR214 = (ToggleButton) findViewById(R.id.tb2Bit14Binario);
        bitR213 = (ToggleButton) findViewById(R.id.tb2Bit13Binario);
        bitR212 = (ToggleButton) findViewById(R.id.tb2Bit12Binario);
        bitR211 = (ToggleButton) findViewById(R.id.tb2Bit11Binario);
        bitR210 = (ToggleButton) findViewById(R.id.tb2Bit10Binario);
        bitR29 = (ToggleButton) findViewById(R.id.tb2Bit9Binario);
        bitR28 = (ToggleButton) findViewById(R.id.tb2Bit8Binario);
        bitR27 = (ToggleButton) findViewById(R.id.tb2Bit7Binario);
        bitR26 = (ToggleButton) findViewById(R.id.tb2Bit6Binario);
        bitR25 = (ToggleButton) findViewById(R.id.tb2Bit5Binario);
        bitR24 = (ToggleButton) findViewById(R.id.tb2Bit4Binario);
        bitR23 = (ToggleButton) findViewById(R.id.tb2Bit3Binario);
        bitR22 = (ToggleButton) findViewById(R.id.tb2Bit2Binario);
        bitR21 = (ToggleButton) findViewById(R.id.tb2Bit1Binario);
        bitR20 = (ToggleButton) findViewById(R.id.tb2Bit0Binario);
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

        sp1Hexadecimal1 = (Spinner) findViewById(R.id.sp1HEx1HexaBinario);
        sp1Hexadecimal2 = (Spinner) findViewById(R.id.sp1HEx2HexaBinario);
        sp1Hexadecimal3 = (Spinner) findViewById(R.id.sp1HEx3HexaBinario);
        sp1Hexadecimal4 = (Spinner) findViewById(R.id.sp1HEx4HexaBinario);
        ArrayAdapter<String> spValores = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, valoresHexadecimais);

        sp1Hexadecimal1.setAdapter(spValores);
        sp1Hexadecimal2.setAdapter(spValores);
        sp1Hexadecimal3.setAdapter(spValores);
        sp1Hexadecimal4.setAdapter(spValores);

        sp2Hexadecimal1 = (Spinner) findViewById(R.id.sp2HEx1HexaBinario);
        sp2Hexadecimal2 = (Spinner) findViewById(R.id.sp2HEx2HexaBinario);
        sp2Hexadecimal3 = (Spinner) findViewById(R.id.sp2HEx3HexaBinario);
        sp2Hexadecimal4 = (Spinner) findViewById(R.id.sp2HEx4HexaBinario);

        sp2Hexadecimal1.setAdapter(spValores);
        sp2Hexadecimal2.setAdapter(spValores);
        sp2Hexadecimal3.setAdapter(spValores);
        sp2Hexadecimal4.setAdapter(spValores);

        ophex14 = ophex13 = ophex12 = ophex11 = ophex24 = ophex23 = ophex22 = ophex21 = "0";
        hex14 = hex13 = hex12 = hex11 = hex24 = hex23 = hex22 = hex21 = "0000";
//        bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
//        bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);

        //Log.i("bitReg1", bitRegistrador1);


        spUCHexaBinario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


//                opcaoSelecionada = spUCHexaBinario.getItemAtPosition(0)
//                        .toString();
//                opcaoSelecionada = spUCHexaBinario.getSelectedItem()
//                        .toString();
                opCodeHexaBinario = spUCHexaBinario.getSelectedItemPosition();
                Log.i("opCodeHexadecimale", "" + opCodeHexaBinario);
                //etSaidaHexadecimal.setText(opcaoSelecionada);

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        sp1Hexadecimal4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                ophex14 = sp1Hexadecimal4.getItemAtPosition(0)
                        .toString();
                ophex14 = sp1Hexadecimal4.getSelectedItem()
                        .toString();
                // Log.i("hex14",hex14);
                hex14 = hexadecimalParaBinarioString(ophex14);
                bitRegistrador1 = (hex14 + hex13 + hex12 + hex11);
                Log.i("[hex]bitRegistrador1", bitRegistrador1);
                atualizarTGRegistrador1(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador1));
                binario1 = deStringParaVetorInteiro(bitRegistrador1);

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        sp1Hexadecimal3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                ophex13 = sp1Hexadecimal3.getItemAtPosition(0)
                        .toString();
                ophex13 = sp1Hexadecimal3.getSelectedItem()
                        .toString();
                hex13 = hexadecimalParaBinarioString(ophex13);
                bitRegistrador1 = (hex14 + hex13 + hex12 + hex11);
                atualizarTGRegistrador1(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador1));
                binario1 = deStringParaVetorInteiro(bitRegistrador1);
                Log.i("[hex]bitRegistrador1", bitRegistrador1);
                // Log.i("hex14",hex14);

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        sp1Hexadecimal2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                ophex12 = sp1Hexadecimal2.getItemAtPosition(0)
                        .toString();
                ophex12 = sp1Hexadecimal2.getSelectedItem()
                        .toString();
                hex12 = hexadecimalParaBinarioString(ophex12);
                bitRegistrador1 = (hex14 + hex13 + hex12 + hex11);
                atualizarTGRegistrador1(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador1));
                binario1 = deStringParaVetorInteiro(bitRegistrador1);
                Log.i("[hex]bitRegistrador1", bitRegistrador1);
                // Log.i("hex14",hex14);

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        sp1Hexadecimal1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                ophex11 = sp1Hexadecimal1.getItemAtPosition(0)
                        .toString();
                ophex11 = sp1Hexadecimal1.getSelectedItem()
                        .toString();

                hex11 = hexadecimalParaBinarioString(ophex11);
                bitRegistrador1 = (hex14 + hex13 + hex12 + hex11);
                Log.i("[hex]bitRegistrador1", bitRegistrador1);
                atualizarTGRegistrador1(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador1));
                binario1 = deStringParaVetorInteiro(bitRegistrador1);
                // Log.i("valor:", hexadecimalParaBinarioString(hex11));

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        sp2Hexadecimal4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {

                ophex24 = sp2Hexadecimal4.getItemAtPosition(0)
                        .toString();
                ophex24 = sp2Hexadecimal4.getSelectedItem()
                        .toString();

                hex24 = hexadecimalParaBinarioString(ophex24);
                bitRegistrador2 = (hex24 + hex23 + hex22 + hex21);
                atualizarTGRegistrador2(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador2));
                binario2 = deStringParaVetorInteiro(bitRegistrador2);
                Log.i("[hex]bitRegistrador2", bitRegistrador2);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        sp2Hexadecimal3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                ophex23 = sp2Hexadecimal3.getItemAtPosition(0)
                        .toString();
                ophex23 = sp2Hexadecimal3.getSelectedItem()
                        .toString();

                hex23 = hexadecimalParaBinarioString(ophex23);
                bitRegistrador2 = (hex24 + hex23 + hex22 + hex21);
                atualizarTGRegistrador2(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador2));
                binario2 = deStringParaVetorInteiro(bitRegistrador2);
                Log.i("[hex]bitRegistrador2", bitRegistrador2);
                // Log.i("hex14",hex14);

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        sp2Hexadecimal2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                ophex22 = sp2Hexadecimal2.getItemAtPosition(0)
                        .toString();
                ophex22 = sp2Hexadecimal2.getSelectedItem()
                        .toString();

                hex22 = hexadecimalParaBinarioString(ophex22);
                bitRegistrador2 = (hex24 + hex23 + hex22 + hex21);
                atualizarTGRegistrador2(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador2));
                binario2 = deStringParaVetorInteiro(bitRegistrador2);
                Log.i("[hex]bitRegistrador2", bitRegistrador2);
                // Log.i("hex14",hex14);

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        sp2Hexadecimal1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                ophex21 = sp2Hexadecimal1.getItemAtPosition(0)
                        .toString();
                ophex21 = sp2Hexadecimal1.getSelectedItem()
                        .toString();

                hex21 = hexadecimalParaBinarioString(ophex21);
                bitRegistrador2 = (hex24 + hex23 + hex22 + hex21);
                Log.i("[hex]bitRegistrador2", bitRegistrador2);
                atualizarTGRegistrador2(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador2));
                binario2 = deStringParaVetorInteiro(bitRegistrador2);
                // Log.i("valor:", hexadecimalParaBinarioString(hex11));

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        if (Build.VERSION.SDK_INT < 11) {
            this.setTheme(R.style.SpinnerItemforlowerlv11);
        }

        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            bitReg1[i] = "0";
            bitReg2[i] = "0";
        }

        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            binario1[i] = 0;
            binario2[i] = 0;
        }

//        bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
//        bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);

        //Log.i("bitReg1", bitRegistrador1);


    }

    protected String hexadecimalParaBinarioString(String decimal) {
        int num = 0;
        if (decimal.equals("A")) {
            num = 10;
        } else if (decimal.equals("B")) {
            num = 11;
        } else if (decimal.equals("C")) {
            num = 12;
        } else if (decimal.equals("D")) {
            num = 13;
        } else if (decimal.equals("E")) {
            num = 14;
        } else if (decimal.equals("F")) {
            num = 15;
        } else {

            num = Integer.parseInt(decimal);
        }
        String nBinario = "";
        int numeroBinario[] = new int[QUANTIDADE_BITSHEXADECIMAL];


        for (int i = 0; i < QUANTIDADE_BITSHEXADECIMAL; i++) {
            if (i == 2) {
                numeroBinario[i] = num % 2;
                numeroBinario[i + 1] = num / 2;
            } else {
                numeroBinario[i] = num % 2;
            }
            num = num / 2;
        }

        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            nBinario += numeroBinario[i];
            //Log.i("numeroBinario[" + i + "]", "" + numeroBinario[i]);
        }
        return nBinario;
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
        int cont = QUANTIDADE_BITS - 1;
        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            bitRegistradorTg[cont] = bitRegTv.substring(i, i + 1);
            cont--;
            // Log.i("bitRegTv.substring("+i+"),("+(i+1)+")", bitRegTv.substring(i, i + 1));
        }


        return bitRegistradorTg;

    }

    protected String atualizarSaidaHexadecimal(int[] valores) {
        String saida = "";
        Log.i("valores.length", "" + valores.length);
        for (int i = 0; i < valores.length; i++) {
            Log.i("valores " + i + " :", "" + valores[i]);
            if (valores[i] < 10) {
                saida += "" + valores[i];

            } else {
                switch (valores[i]) {
                    case 10:
                        saida += "A";
                        break;
                    case 11:
                        saida += "B";
                        break;
                    case 12:
                        saida += "C";
                        break;
                    case 13:
                        saida += "D";
                        break;
                    case 14:
                        saida += "E";
                        break;
                    case 15:
                        saida += "F";
                        break;
                }
            }
        }
        return saida;

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

                etSaidaValorDecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(add(bitRegistrador1, bitRegistrador2, optionCode))));
//                Log.i("add bitRegistrador1",bitRegistrador1);
//                Log.i("add bitRegistrador2",bitRegistrador2);
//                Log.i("add", atualizarEditTextSaida(add(bitRegistrador1, bitRegistrador2)));
                break;
            case 1:
                //AND
                etSaidaValorDecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(and(bitRegistrador1, bitRegistrador2))));
                break;
            case 2:
                //MOVE
                move();
                etSaidaValorDecimal.setText("0");
                break;
            case 3:
                //OR
                etSaidaValorDecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(or(bitRegistrador1, bitRegistrador2))));
                break;
            case 4:
                //XOR
                etSaidaValorDecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(xor(bitRegistrador1, bitRegistrador2))));
                break;
            case 5:
                //COMPARE
                if (compare(bitRegistrador1, bitRegistrador2)) {

                    etSaidaValorDecimal.setText("OS 2 VALORES SÃO IGUAIS");
                } else {

                    etSaidaValorDecimal.setText("OS 2 VALORES NÃO SÃO IGUAIS");
                }
                break;
            case 6:
                //INC
                etSaidaValorDecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(inc(bitRegistrador1))));
                binario1 = inc(bitRegistrador1);

                aux = new int[QUANTIDADE_BITS];
                int cont = QUANTIDADE_BITS - 1;
                for (int i = 0; i < QUANTIDADE_BITS; i++) {
                    aux[cont] = binario1[i];
                    cont--;
                }
                binario1 = aux;
                bitRegistrador1 = atualizarEditTextSaida(binario1);
                atualizarTGRegistrador1(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador1));

                break;
            case 7:
                //NEG
                etSaidaValorDecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(neg(bitRegistrador1))));
                binario1 = neg(bitRegistrador1);
                aux = new int[QUANTIDADE_BITS];
                cont = QUANTIDADE_BITS - 1;
                for (int i = 0; i < QUANTIDADE_BITS; i++) {
                    aux[cont] = binario1[i];
                    cont--;
                }
                binario1 = aux;
                bitRegistrador1 = atualizarEditTextSaida(binario1);
                atualizarTGRegistrador1(atualizarRegistradorDeEditTextParaToggleButton(bitRegistrador1));

                break;
//            case 8:
//                //SUB
//
//                etSaidaValorDecimal.setText("" + binarioParaDecimalString(
//                        atualizarEditTextSaida(sub(bitRegistrador1, bitRegistrador2))));
//
//                break;
        }
//        if (optionCode != 5 || optionCode != 2 ) {
//            etSaidaValorDecimal.setText("" + binarioParaDecimalString(etSaidaValorDecimal.getText().toString()));
//        }
    }


    protected int[] deStringParaVetorInteiro(String valor) {
        int saida[] = new int[QUANTIDADE_BITS];

//        for (int i = 0; i < QUANTIDADE_BITS; i++) {
//            if (i < QUANTIDADE_BITS - 1) {
//                saida[i] = Integer.parseInt(valor.substring(i, (i + 1)));
//
//            } else {
//                saida[i] = Integer.parseInt(valor.substring(i));
//            }
//        }
        int cont = QUANTIDADE_BITS - 1;
        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            saida[cont] = Integer.parseInt(valor.substring(i, (i + 1)));
            cont--;
            // Log.i("bitRegTv.substring("+i+"),("+(i+1)+")", bitRegTv.substring(i, i + 1));
        }
        return saida;
    }

    protected int[] add(String valor1, String valor2, int opcode) {
        int reg1[];
        int reg2[];
        int cont = QUANTIDADE_BITS - 1;
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);

        int saida[] = new int[QUANTIDADE_BITS];
        int aux[] = new int[QUANTIDADE_BITS];
        for (int i = 0; i < QUANTIDADE_BITS; i++) {

            if (i < 15) {

                if (reg1[i] == 2 && reg2[i] == 1) {
                    saida[i] = 1;
                    reg1[i + 1] = reg1[i + 1] + 1;
                } else if (reg1[i] == 1 && reg2[i] == 1
                        || reg1[i] == 2 && reg2[i] == 0) {
                    saida[i] = 0;
                    reg1[i + 1] = reg1[i + 1] + 1;
                } else {
                    saida[i] = reg1[i] + reg2[i];
                }
            } else if (i == 15) {
                if (reg1[i] == 2 && reg2[i] == 1) {
                    saida[i] = 1;
                    if (opcode == 0) {
                        Toast.makeText(getApplicationContext(),
                                "A soma desses dos valores resultou em um overflow", Toast.LENGTH_SHORT).show();
                    }
                } else if (reg1[i] == 1 && reg2[i] == 1
                        || reg1[i] == 2 && reg2[i] == 0) {
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


        for (int i = 0; i < QUANTIDADE_BITS; i++) {
            aux[cont] = saida[i];
            cont--;
            // Log.i("bitRegTv.substring("+i+"),("+(i+1)+")", bitRegTv.substring(i, i + 1));
        }

        return aux;
    }

    protected int[] and(String valor1, String valor2) {
        int saida[] = new int[QUANTIDADE_BITS];
        int reg1[] = new int[QUANTIDADE_BITS];
        int reg2[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);


        for (int i = QUANTIDADE_BITS - 1; i >= 0; i--) {
            Log.i("reg1[" + i + "]", "" + reg1[i]);
            Log.i("reg2[" + i + "]", "" + reg2[i]);
            if (reg1[i] == 1 && reg2[i] == 1) {
                saida[i] = 1;
            } else {
                saida[i] = 0;
            }
        }
        int aux[] = new int[QUANTIDADE_BITS];
        int cont = QUANTIDADE_BITS - 1;
        for (int i = 0; i < QUANTIDADE_BITS; i++) {

            aux[cont] = saida[i];
            cont--;

        }
        return aux;
    }

    protected int[] or(String valor1, String valor2) {
        int saida[] = new int[QUANTIDADE_BITS];
        int reg1[] = new int[QUANTIDADE_BITS];
        int reg2[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);

        for (int i = QUANTIDADE_BITS - 1; i >= 0; i--) {
            if (reg1[i] == 0 && reg2[i] == 0) {
                saida[i] = 0;
            } else {
                saida[i] = 1;
            }
        }

        int aux[] = new int[QUANTIDADE_BITS];
        int cont = QUANTIDADE_BITS - 1;
        for (int i = 0; i < QUANTIDADE_BITS; i++) {

            aux[cont] = saida[i];
            cont--;

        }
        return aux;
    }


    protected int[] xor(String valor1, String valor2) {
        int saida[] = new int[QUANTIDADE_BITS];
        int reg1[] = new int[QUANTIDADE_BITS];
        int reg2[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        reg2 = deStringParaVetorInteiro(valor2);
        for (int i = QUANTIDADE_BITS - 1; i >= 0; i--) {
            if (reg1[i] != reg2[i]) {
                saida[i] = 1;
            } else {
                saida[i] = 0;
            }
        }

        int aux[] = new int[QUANTIDADE_BITS];
        int cont = QUANTIDADE_BITS - 1;
        for (int i = 0; i < QUANTIDADE_BITS; i++) {

            aux[cont] = saida[i];
            cont--;

        }
        return aux;
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
        binario2 = binario1;
        sp2Hexadecimal1.setSelection(sp1Hexadecimal1.getSelectedItemPosition());
        sp2Hexadecimal2.setSelection(sp1Hexadecimal2.getSelectedItemPosition());
        sp2Hexadecimal3.setSelection(sp1Hexadecimal3.getSelectedItemPosition());
        sp2Hexadecimal4.setSelection(sp1Hexadecimal4.getSelectedItemPosition());

    }


    protected int[] neg(String valor1) {
        int reg1[] = new int[QUANTIDADE_BITS];
        reg1 = deStringParaVetorInteiro(valor1);
        int regInverte[] = new int[QUANTIDADE_BITS];


        regInverte = reg1;
        for (int i = QUANTIDADE_BITS - 1; i >= 0; i--) {
            if (regInverte[i] == 0) {
                regInverte[i] = 1;
            } else if (regInverte[i] == 1) {
                regInverte[i] = 0;
            }
        }
        int aux[] = new int[QUANTIDADE_BITS];
        int cont = QUANTIDADE_BITS - 1;
        for (int i = 0; i < QUANTIDADE_BITS; i++) {

            aux[cont] = regInverte[i];
            cont--;

        }
        return aux;
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


        return add(valor1, atualizarEditTextSaida(incrementador), 0);
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

        sp1Hexadecimal1.setSelection(0);
        sp1Hexadecimal2.setSelection(0);
        sp1Hexadecimal3.setSelection(0);
        sp1Hexadecimal4.setSelection(0);

        sp2Hexadecimal1.setSelection(0);
        sp2Hexadecimal2.setSelection(0);
        sp2Hexadecimal3.setSelection(0);
        sp2Hexadecimal4.setSelection(0);
        etSaidaValorDecimal.setText("0");
        spUCHexaBinario.setSelection(0);

    }


    protected int[] atualizarRegistradorDeEditTextParaSpinner(int[] binario) {
        int[] valor4 = new int[QUANTIDADE_BITSHEXADECIMAL];
        int[] valor3 = new int[QUANTIDADE_BITSHEXADECIMAL];
        int[] valor2 = new int[QUANTIDADE_BITSHEXADECIMAL];
        int[] valor1 = new int[QUANTIDADE_BITSHEXADECIMAL];
        int[] valores = new int[QUANTIDADE_BITSHEXADECIMAL];

        valor4[3] = binario[15];
        valor4[2] = binario[14];
        valor4[1] = binario[13];
        valor4[0] = binario[12];

        valor3[3] = binario[11];
        valor3[2] = binario[10];
        valor3[1] = binario[9];
        valor3[0] = binario[8];

        valor2[3] = binario[7];
        valor2[2] = binario[6];
        valor2[1] = binario[5];
        valor2[0] = binario[4];

        valor1[3] = binario[3];
        valor1[2] = binario[2];
        valor1[1] = binario[1];
        valor1[0] = binario[0];


        int decimal = 0;
        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            Log.i("valor4[i]" + i + ":", "" + valor4[i]);
            if (valor4[i] == 1) {
                decimal += Math.pow(2, i);
            }
        }
        valores[3] = decimal;
        decimal = 0;
        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            Log.i("valor3[i]" + i + ":", "" + valor3[i]);
            if (valor3[i] == 1) {
                decimal += Math.pow(2, i);
            }
        }
        valores[2] = decimal;
        decimal = 0;
        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            Log.i("valor2[i]" + i + ":", "" + valor2[i]);
            if (valor2[i] == 1) {
                decimal += Math.pow(2, i);
            }
        }
        valores[1] = decimal;
        decimal = 0;

        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            Log.i("valor1[i]" + i + ":", "" + valor1[i]);
            if (valor1[i] == 1) {
                decimal += Math.pow(2, i);
            }
        }
        valores[0] = decimal;

        return valores;

    }

    protected int[] atualizarRegistradorDeEditTextParaSpinnerSaida(int[] binario) {
        int[] valor4 = new int[QUANTIDADE_BITSHEXADECIMAL];
        int[] valor3 = new int[QUANTIDADE_BITSHEXADECIMAL];
        int[] valor2 = new int[QUANTIDADE_BITSHEXADECIMAL];
        int[] valor1 = new int[QUANTIDADE_BITSHEXADECIMAL];
        int[] valores = new int[QUANTIDADE_BITSHEXADECIMAL];

        valor1[3] = binario[0];
        valor1[2] = binario[1];
        valor1[1] = binario[2];
        valor1[0] = binario[3];

        valor2[3] = binario[4];
        valor2[2] = binario[5];
        valor2[1] = binario[6];
        valor2[0] = binario[7];

        valor3[3] = binario[8];
        valor3[2] = binario[9];
        valor3[1] = binario[10];
        valor3[0] = binario[11];

        valor4[3] = binario[12];
        valor4[2] = binario[13];
        valor4[1] = binario[14];
        valor4[0] = binario[15];


        int decimal = 0;
        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            Log.i("valor4[i]" + i + ":", "" + valor4[i]);
            if (valor4[i] == 1) {
                decimal += Math.pow(2, i);
            }
        }
        valores[3] = decimal;
        decimal = 0;
        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            Log.i("valor3[i]" + i + ":", "" + valor3[i]);
            if (valor3[i] == 1) {
                decimal += Math.pow(2, i);
            }
        }
        valores[2] = decimal;
        decimal = 0;
        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            Log.i("valor2[i]" + i + ":", "" + valor2[i]);
            if (valor2[i] == 1) {
                decimal += Math.pow(2, i);
            }
        }
        valores[1] = decimal;
        decimal = 0;

        for (int i = QUANTIDADE_BITSHEXADECIMAL - 1; i >= 0; i--) {
            Log.i("valor1[i]" + i + ":", "" + valor1[i]);
            if (valor1[i] == 1) {
                decimal += Math.pow(2, i);
            }
        }
        valores[0] = decimal;

        return valores;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tbBit15Binario:
                if (bit15.isChecked()) {
                    binario1[15] = 1;

                } else {
                    binario1[15] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit14Binario:
                if (bit14.isChecked()) {
                    binario1[14] = 1;
                } else {
                    binario1[14] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit13Binario:
                if (bit13.isChecked()) {
                    binario1[13] = 1;
                } else {
                    binario1[13] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit12Binario:
                if (bit12.isChecked()) {
                    binario1[12] = 1;
                } else {
                    binario1[12] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit11Binario:
                if (bit11.isChecked()) {
                    binario1[11] = 1;
                } else {
                    binario1[11] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit10Binario:
                if (bit10.isChecked()) {
                    binario1[10] = 1;
                } else {
                    binario1[10] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit9Binario:
                if (bit9.isChecked()) {
                    binario1[9] = 1;
                } else {
                    binario1[9] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit8Binario:
                if (bit8.isChecked()) {
                    binario1[8] = 1;
                } else {
                    binario1[8] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit7Binario:
                if (bit7.isChecked()) {
                    binario1[7] = 1;
                } else {
                    binario1[7] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit6Binario:
                if (bit6.isChecked()) {
                    binario1[6] = 1;
                } else {
                    binario1[6] = 0;
                }
                Log.i("binario6", "" + binario1[6]);
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit5Binario:
                if (bit5.isChecked()) {
                    binario1[5] = 1;
                } else {
                    binario1[5] = 0;
                }
                Log.i("binario5", "" + binario1[5]);
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;

            case R.id.tbBit4Binario:
                if (bit4.isChecked()) {
                    binario1[4] = 1;
                } else {
                    binario1[4] = 0;
                }
                Log.i("binario1", "" + binario1[4]);
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit3Binario:
                if (bit3.isChecked()) {
                    binario1[3] = 1;
                } else {
                    binario1[3] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;
            case R.id.tbBit2Binario:
                if (bit2.isChecked()) {
                    binario1[2] = 1;
                } else {
                    binario1[2] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;

            case R.id.tbBit1Binario:
                if (bit1.isChecked()) {
                    binario1[1] = 1;
                } else {
                    binario1[1] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;

            case R.id.tbBit0Binario:
                if (bit0.isChecked()) {
                    binario1[0] = 1;
                } else {
                    binario1[0] = 0;
                }
                bitRegistrador1 = atualizarSaidaHexadecimal(binario1);
                Log.i("binario1", bitRegistrador1);
                break;

            case R.id.tb2Bit15Binario:
                if (bitR215.isChecked()) {
                    binario2[15] = 1;
                } else {
                    binario2[15] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("binario1", bitRegistrador2);
                break;
            case R.id.tb2Bit14Binario:
                if (bitR214.isChecked()) {
                    binario2[14] = 1;
                } else {
                    binario2[14] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("binario1", bitRegistrador2);
                break;
            case R.id.tb2Bit13Binario:
                if (bitR213.isChecked()) {
                    binario2[13] = 1;
                } else {
                    binario2[13] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit12Binario:
                if (bitR212.isChecked()) {
                    binario2[12] = 1;
                } else {
                    binario2[12] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit11Binario:
                if (bitR211.isChecked()) {
                    binario2[11] = 1;
                } else {
                    binario2[11] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit10Binario:
                if (bitR210.isChecked()) {
                    binario2[10] = 1;
                } else {
                    binario2[10] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit9Binario:
                if (bitR29.isChecked()) {
                    binario2[9] = 1;
                } else {
                    binario2[9] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit8Binario:
                if (bitR28.isChecked()) {
                    binario2[8] = 1;
                } else {
                    binario2[8] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit7Binario:
                if (bitR27.isChecked()) {
                    binario2[7] = 1;
                } else {
                    binario2[7] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit6Binario:
                if (bitR26.isChecked()) {
                    binario2[6] = 1;
                } else {
                    binario2[6] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit5Binario:
                if (bitR25.isChecked()) {
                    binario2[5] = 1;
                } else {
                    binario2[5] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit4Binario:
                if (bitR24.isChecked()) {
                    binario2[4] = 1;
                } else {
                    binario2[4] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit3Binario:
                if (bitR23.isChecked()) {
                    binario2[3] = 1;
                } else {
                    binario2[3] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.tb2Bit2Binario:
                if (bitR22.isChecked()) {
                    binario2[2] = 1;
                } else {
                    binario2[2] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;

            case R.id.tb2Bit1Binario:
                if (bitR21.isChecked()) {
                    binario2[1] = 1;
                } else {
                    binario2[1] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;

            case R.id.tb2Bit0Binario:
                if (bitR20.isChecked()) {
                    binario2[0] = 1;
                } else {
                    binario2[0] = 0;
                }
                bitRegistrador2 = atualizarSaidaHexadecimal(binario2);
                Log.i("bitReg1", bitRegistrador2);
                break;
            case R.id.btExecutarOperacaoHexaBinario:
                operacao(opCodeHexaBinario);
                break;

        }

        updateRegistor1();
        updateRegistor2();


    }

    protected void updateRegistor1() {
        valoresSpinnersHexadecimal = atualizarRegistradorDeEditTextParaSpinner(binario1);
        sp1Hexadecimal1.setSelection(valoresSpinnersHexadecimal[0]);
        sp1Hexadecimal2.setSelection(valoresSpinnersHexadecimal[1]);
        sp1Hexadecimal3.setSelection(valoresSpinnersHexadecimal[2]);
        sp1Hexadecimal4.setSelection(valoresSpinnersHexadecimal[3]);
    }

    protected void updateRegistor2() {
        valoresSpinnersHexadecimal2 = atualizarRegistradorDeEditTextParaSpinner(binario2);
        sp2Hexadecimal1.setSelection(valoresSpinnersHexadecimal2[0]);
        sp2Hexadecimal2.setSelection(valoresSpinnersHexadecimal2[1]);
        sp2Hexadecimal3.setSelection(valoresSpinnersHexadecimal2[2]);
        sp2Hexadecimal4.setSelection(valoresSpinnersHexadecimal2[3]);
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
