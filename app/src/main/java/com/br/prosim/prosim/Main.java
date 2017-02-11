package com.br.prosim.prosim;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Main extends Activity implements View.OnClickListener {
    private TextView tvAcessarProcessador, tvAcessarModoHexadecimal, tvAcessarHexaBinario, tvAcessarSobre;
    private ImageButton imAcessarProcessador, imModoHexadecimal, imAcessarHexaBinario, imAcessarSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAcessarProcessador = (TextView) findViewById(R.id.tvAcessarProcessador);
        tvAcessarProcessador.setOnClickListener(this);

        tvAcessarModoHexadecimal = (TextView) findViewById(R.id.tvAcessarModoHexadecimal);
        tvAcessarModoHexadecimal.setOnClickListener(this);

        tvAcessarHexaBinario = (TextView) findViewById(R.id.tvAcessarHexaBinario);
        tvAcessarHexaBinario.setOnClickListener(this);

        tvAcessarSobre = (TextView) findViewById(R.id.tvAcessarSobre);
        tvAcessarSobre.setOnClickListener(this);

        imAcessarProcessador = (ImageButton) findViewById(R.id.imAcessarProcessador);
        imAcessarProcessador.setOnClickListener(this);

        imAcessarProcessador = (ImageButton) findViewById(R.id.imAcessarProcessador);
        imAcessarProcessador.setOnClickListener(this);

        imModoHexadecimal = (ImageButton) findViewById(R.id.imModoHexadecimal);
        imModoHexadecimal.setOnClickListener(this);

        imAcessarHexaBinario = (ImageButton) findViewById(R.id.imAcessarHexaBinario);
        imAcessarHexaBinario.setOnClickListener(this);

        imAcessarSobre = (ImageButton) findViewById(R.id.imAcessarSobre);
        imAcessarSobre.setOnClickListener(this);

    }

    protected void acessarProcessador() {
        Intent novaIntent = new Intent(this, Processador.class);
        startActivity(novaIntent);
    }

    protected void acessarModoHexadecimal() {
        Intent novaIntent = new Intent(this, ModoHexadecimal.class);
        startActivity(novaIntent);
    }


    protected void acessarHexaBinario() {
        Intent novaIntent = new Intent(this, HexaBinario.class);
        startActivity(novaIntent);
    }

    protected void acessarSobre() {
        Intent novaIntent = new Intent(this, Sobre.class);
        startActivity(novaIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvAcessarProcessador:
                acessarProcessador();
                break;
            case R.id.tvAcessarModoHexadecimal:
                acessarModoHexadecimal();
                break;
            case R.id.tvAcessarHexaBinario:
                acessarHexaBinario();
                break;
            case R.id.imAcessarProcessador:
                acessarProcessador();
                break;
            case R.id.imModoHexadecimal:
                acessarModoHexadecimal();
                break;
            case R.id.imAcessarHexaBinario:
                acessarHexaBinario();
                break;

            case R.id.imAcessarSobre:
                acessarSobre();
                break;
            case R.id.tvAcessarSobre:
                acessarSobre();
                break;
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
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
