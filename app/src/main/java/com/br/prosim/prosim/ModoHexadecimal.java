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

//Modo Hexadecimal
public class ModoHexadecimal extends Activity implements View.OnClickListener {
    private final int QUANTIDADE_BITSHEXADECIMAL = 4;
    private final int QUANTIDADE_BITS = 16;
    private EditText etValorDecimalHexadecimal, etValorDecimal2Hexadecimal, etSaidaHexadecimal, etSaidaValorDecimalHexadecimal;
    private Button btExecutarOperacaoHexadecimal;
    private String valorDecimalHexadecimal = "0";
    private String bitRegistrador1 = "0000000000000000";
    private String valorDecimalHexadecimal2 = "0";
    private String bitRegistrador2 = "0000000000000000";
    private Spinner spUCHexadecimal, sp1Hexadecimal1, sp1Hexadecimal2, sp1Hexadecimal3, sp1Hexadecimal4,
            sp2Hexadecimal1, sp2Hexadecimal2, sp2Hexadecimal3, sp2Hexadecimal4;
    private String opcaoSelecionada, hex14, hex13, hex12, hex11, hex24, hex23, hex22, hex21,
            ophex14, ophex13, ophex12, ophex11, ophex24, ophex23, ophex22, ophex21;
    private int opCodeHexadecimaleHexadecimale = 0;
    private int[] binario = new int[QUANTIDADE_BITS];
    private int[] valoresSpinnersHexadecimal = new int[QUANTIDADE_BITSHEXADECIMAL];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modohexadecimal);
        spUCHexadecimal = (Spinner) findViewById(R.id.spUCHexadecimal);
        ArrayAdapter<String> spOpcoesUC = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line,
                new String[]{"ADD", "AND", "MOVE", "OR", "XOR", "COMPARE", "INC", "NEG"});//, "SUB"});
        spUCHexadecimal.setAdapter(spOpcoesUC);
        etValorDecimalHexadecimal = (EditText) findViewById(R.id.etReg1ValorDecimalHexadecimal);
        etSaidaHexadecimal = (EditText) findViewById(R.id.etSaidaModoHexadecimal);
        etSaidaValorDecimalHexadecimal = (EditText) findViewById(R.id.etSaidaValorDecimalModoHexadecimal);
        etValorDecimal2Hexadecimal = (EditText) findViewById(R.id.etReg2ValorDecimalModoHexadecimal);

        btExecutarOperacaoHexadecimal = (Button) findViewById(R.id.btExecutarOperacaoHexadecimal);

        btExecutarOperacaoHexadecimal.setOnClickListener(this);
        String[] valoresHexadecimais = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
                "B", "C", "D", "E", "F"};

        sp1Hexadecimal1 = (Spinner) findViewById(R.id.sp1HEx1);
        sp1Hexadecimal2 = (Spinner) findViewById(R.id.sp1HEx2);
        sp1Hexadecimal3 = (Spinner) findViewById(R.id.sp1HEx3);
        sp1Hexadecimal4 = (Spinner) findViewById(R.id.sp1HEx4);
        ArrayAdapter<String> spValores = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, valoresHexadecimais);

        sp1Hexadecimal1.setAdapter(spValores);
        sp1Hexadecimal2.setAdapter(spValores);
        sp1Hexadecimal3.setAdapter(spValores);
        sp1Hexadecimal4.setAdapter(spValores);

        sp2Hexadecimal1 = (Spinner) findViewById(R.id.sp2HEx1);
        sp2Hexadecimal2 = (Spinner) findViewById(R.id.sp2HEx2);
        sp2Hexadecimal3 = (Spinner) findViewById(R.id.sp2HEx3);
        sp2Hexadecimal4 = (Spinner) findViewById(R.id.sp2HEx4);

        sp2Hexadecimal1.setAdapter(spValores);
        sp2Hexadecimal2.setAdapter(spValores);
        sp2Hexadecimal3.setAdapter(spValores);
        sp2Hexadecimal4.setAdapter(spValores);

        if (Build.VERSION.SDK_INT < 11) {
            this.setTheme(R.style.SpinnerItemforlowerlv11);
        }
        ophex14 = ophex13 = ophex12 = ophex11 = ophex24 = ophex23 = ophex22 = ophex21 = "0";
        hex14 = hex13 = hex12 = hex11 = hex24 = hex23 = hex22 = hex21 = "0000";
//        bitRegistrador1 = atualizarRegistradorDeToggleButtonParaEditText(bitReg1);
//        bitRegistrador2 = atualizarRegistradorDeToggleButtonParaEditText(bitReg2);

        //Log.i("bitReg1", bitRegistrador1);


        spUCHexadecimal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {


                opcaoSelecionada = spUCHexadecimal.getItemAtPosition(0)
                        .toString();
                opcaoSelecionada = spUCHexadecimal.getSelectedItem()
                        .toString();
                opCodeHexadecimaleHexadecimale = spUCHexadecimal.getSelectedItemPosition();
                Log.i("opCodeHexadecimale", "" + opCodeHexadecimaleHexadecimale);
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
                etValorDecimalHexadecimal.setText("" + binarioParaDecimalString(bitRegistrador1));
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
                Log.i("[hex]bitRegistrador1", bitRegistrador1);
                etValorDecimalHexadecimal.setText("" + binarioParaDecimalString(bitRegistrador1));
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
                Log.i("[hex]bitRegistrador1", bitRegistrador1);
                etValorDecimalHexadecimal.setText("" + binarioParaDecimalString(bitRegistrador1));
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
                etValorDecimalHexadecimal.setText("" + binarioParaDecimalString(bitRegistrador1));
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
                Log.i("[hex]bitRegistrador2", bitRegistrador2);
                etValorDecimal2Hexadecimal.setText("" + binarioParaDecimalString(bitRegistrador2));
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
                Log.i("[hex]bitRegistrador2", bitRegistrador2);
                etValorDecimal2Hexadecimal.setText("" + binarioParaDecimalString(bitRegistrador2));
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
                Log.i("[hex]bitRegistrador2", bitRegistrador2);
                etValorDecimal2Hexadecimal.setText("" + binarioParaDecimalString(bitRegistrador2));
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
                etValorDecimal2Hexadecimal.setText("" + binarioParaDecimalString(bitRegistrador2));
                // Log.i("valor:", hexadecimalParaBinarioString(hex11));

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        etValorDecimalHexadecimal.setOnKeyListener(new View.OnKeyListener() {
            @TargetApi(Build.VERSION_CODES.GINGERBREAD)
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!((etValorDecimalHexadecimal.getText().toString()).isEmpty())) {
                    int valorMax = Integer.parseInt(etValorDecimalHexadecimal.getText().toString());
                    if (valorMax <= 65535) {

                        valorDecimalHexadecimal = decimalParaBinarioString(etValorDecimalHexadecimal.getText().toString());
//                        Log.i("valorDecimalHexadecimal",""+valorDecimalHexadecimal);
                        binario = deStringParaVetorInteiro(valorDecimalHexadecimal);
//                        Log.i("binario",""+binario);
                        valoresSpinnersHexadecimal = atualizarRegistradorDeEditTextParaSpinner(binario);
                        sp1Hexadecimal1.setSelection(valoresSpinnersHexadecimal[0]);
                        sp1Hexadecimal2.setSelection(valoresSpinnersHexadecimal[1]);
                        sp1Hexadecimal3.setSelection(valoresSpinnersHexadecimal[2]);
                        sp1Hexadecimal4.setSelection(valoresSpinnersHexadecimal[3]);
                        bitRegistrador1 = (hex14 + hex13 + hex12 + hex11);
//                        Log.i("bitRegistrador1",""+bitRegistrador1);
//                        Log.i("etValorDecimalHexadecimal.getText()", etValorDecimalHexadecimal.getText().toString());

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Digite um valor menor que 65535", Toast.LENGTH_SHORT).show();
                        etValorDecimalHexadecimal.setText(null);

                    }
                } else {
                    sp1Hexadecimal1.setSelection(0);
                    sp1Hexadecimal2.setSelection(0);
                    sp1Hexadecimal3.setSelection(0);
                    sp1Hexadecimal4.setSelection(0);
                }

                return false;
            }
        });

        etValorDecimal2Hexadecimal.setOnKeyListener(new View.OnKeyListener() {
            @TargetApi(Build.VERSION_CODES.GINGERBREAD)
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!((etValorDecimal2Hexadecimal.getText().toString()).isEmpty())) {
                    int valorMax = Integer.parseInt(etValorDecimal2Hexadecimal.getText().toString());
                    if (valorMax <= 65535) {
                        valorDecimalHexadecimal2 = decimalParaBinarioString(etValorDecimal2Hexadecimal.getText().toString());
                        binario = deStringParaVetorInteiro(valorDecimalHexadecimal2);
                        valoresSpinnersHexadecimal = atualizarRegistradorDeEditTextParaSpinner(binario);
                        sp2Hexadecimal1.setSelection(valoresSpinnersHexadecimal[0]);
                        sp2Hexadecimal2.setSelection(valoresSpinnersHexadecimal[1]);
                        sp2Hexadecimal3.setSelection(valoresSpinnersHexadecimal[2]);
                        sp2Hexadecimal4.setSelection(valoresSpinnersHexadecimal[3]);
                        bitRegistrador2 = (hex24 + hex23 + hex22 + hex21);
                        Log.i("etValorDecimal.getText()", etValorDecimal2Hexadecimal.getText().toString());

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Digite um valor menor que 65535", Toast.LENGTH_SHORT).show();
                        etValorDecimal2Hexadecimal.setText(null);

                    }
                } else {
                    sp2Hexadecimal1.setSelection(0);
                    sp2Hexadecimal2.setSelection(0);
                    sp2Hexadecimal3.setSelection(0);
                    sp2Hexadecimal4.setSelection(0);
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


    protected String atualizarSaida(int[] valores) {
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


    }

    protected void atualizarTGRegistrador2(String[] bitReg) {


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
                etSaidaHexadecimal.setText(atualizarSaida(atualizarRegistradorDeEditTextParaSpinnerSaida(
                        add(bitRegistrador1, bitRegistrador2, optionCode))));
                etSaidaValorDecimalHexadecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(
                                add(bitRegistrador1, bitRegistrador2, optionCode)
                        )
                ));
                break;
            case 1:
                //AND
                etSaidaHexadecimal.setText(atualizarSaida(atualizarRegistradorDeEditTextParaSpinnerSaida(
                        and(bitRegistrador1, bitRegistrador2))));
                etSaidaValorDecimalHexadecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(
                                and(bitRegistrador1, bitRegistrador2)
                        )
                ));
                break;
            case 2:
                //MOVE
                move();
                etSaidaHexadecimal.setText("0000");
                break;
            case 3:
                //OR
                etSaidaHexadecimal.setText(atualizarSaida(atualizarRegistradorDeEditTextParaSpinnerSaida(
                        or(bitRegistrador1, bitRegistrador2))));
                etSaidaValorDecimalHexadecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(
                                or(bitRegistrador1, bitRegistrador2)
                        )
                ));
                break;
            case 4:
                //XOR
                etSaidaHexadecimal.setText(atualizarSaida(atualizarRegistradorDeEditTextParaSpinnerSaida(
                        xor(bitRegistrador1, bitRegistrador2))));
                etSaidaValorDecimalHexadecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(
                                xor(bitRegistrador1, bitRegistrador2)
                        )
                ));
                break;
            case 5:
                //COMPARE
                if (compare(bitRegistrador1, bitRegistrador2)) {
                    etSaidaHexadecimal.setText("OS 2 VALORES SÃO IGUAIS");
                    etSaidaValorDecimalHexadecimal.setText("OS 2 VALORES SÃO IGUAIS");
                } else {
                    etSaidaHexadecimal.setText("OS 2 VALORES NÃO SÃO IGUAIS");
                    etSaidaValorDecimalHexadecimal.setText("OS 2 VALORES NÃO SÃO IGUAIS");
                }
                break;
            case 6:
                //INC
                etSaidaHexadecimal.setText(atualizarSaida(
                        atualizarRegistradorDeEditTextParaSpinnerSaida(inc(bitRegistrador1))));
                etSaidaValorDecimalHexadecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(
                                inc(bitRegistrador1)
                        )));
                break;
            case 7:
                //NEG
                etSaidaHexadecimal.setText(atualizarSaida(
                        atualizarRegistradorDeEditTextParaSpinnerSaida(neg(bitRegistrador1))));
                etSaidaValorDecimalHexadecimal.setText("" + binarioParaDecimalString(
                        atualizarEditTextSaida(
                                neg(bitRegistrador1)
                        )));
                break;
//            case 8:
//                //SUB
//                etSaidaHexadecimal.setText(atualizarSaida(atualizarRegistradorDeEditTextParaSpinnerSaida(
//                        sub(bitRegistrador1, bitRegistrador2))));
//                etSaidaValorDecimalHexadecimal.setText("" + binarioParaDecimalString(
//                        atualizarEditTextSaida(
//                                sub(bitRegistrador1, bitRegistrador2)
//                        )
//                ));
//                break;
        }
        if (optionCode != 5) {
//         etSaidaValorDecimalHexadecimal.setText("" + binarioParaDecimalString(
//                 atualizarRegistradorDeToggleButtonParaEditText()
//         ));
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
                    saida[i] = 1;
                    if (opcode == 0) {
                        Toast.makeText(getApplicationContext(),
                                "A soma desses dos valores resultou em um overflow", Toast.LENGTH_SHORT).show();
                    }
                } else if (reg1[i] == 1 && reg2[i] == 1
                        || reg1[i] == 2 && reg2[i] == 0
                        ) {
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
        sp2Hexadecimal1.setSelection(sp1Hexadecimal1.getSelectedItemPosition());
        sp2Hexadecimal2.setSelection(sp1Hexadecimal2.getSelectedItemPosition());
        sp2Hexadecimal3.setSelection(sp1Hexadecimal3.getSelectedItemPosition());
        sp2Hexadecimal4.setSelection(sp1Hexadecimal4.getSelectedItemPosition());
        bitRegistrador2 = bitRegistrador1;

        etValorDecimal2Hexadecimal.setText(etValorDecimalHexadecimal.getText().toString());
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


        etSaidaHexadecimal.setText("0000");
        etSaidaValorDecimalHexadecimal.setText("0");
        spUCHexadecimal.setSelection(0);
        sp1Hexadecimal1.setSelection(0);
        sp1Hexadecimal2.setSelection(0);
        sp1Hexadecimal3.setSelection(0);
        sp1Hexadecimal4.setSelection(0);

        sp2Hexadecimal1.setSelection(0);
        sp2Hexadecimal2.setSelection(0);
        sp2Hexadecimal3.setSelection(0);
        sp2Hexadecimal4.setSelection(0);
        etValorDecimalHexadecimal.setText("0");
        etValorDecimal2Hexadecimal.setText("0");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btExecutarOperacaoHexadecimal:
                operacao(opCodeHexadecimaleHexadecimale);
                break;

        }

        etValorDecimalHexadecimal.setText("" + binarioParaDecimalString(bitRegistrador1));
        etValorDecimal2Hexadecimal.setText("" + binarioParaDecimalString(bitRegistrador2));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_modohexadecimal, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.itMenu_ModoHExadecimal:
                limpar();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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
