package com.example.eduardocucharro.demosamsung;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DetalhesActivity extends Activity implements View.OnClickListener{

    private final String NOME = "NOME";
    private final String EMAIL = "EMAIL";
    private final String PREFERENCES = "PREFERENCES";
    private EditText editNome;
    private Spinner spinnerDia;
    private Spinner spinnerPeriodo;
    private EditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        editNome = (EditText)findViewById(R.id.edit_nome);
        editEmail = (EditText)findViewById(R.id.edit_email);
        spinnerDia = (Spinner)findViewById(R.id.spinner_dia);
        spinnerPeriodo = (Spinner) findViewById(R.id.spinner_periodo);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        editNome.setText(sharedPreferences.getString(NOME, ""));
        editEmail.setText(sharedPreferences.getString(EMAIL, ""));
    }

    @Override
    public void onClick(View v) {

        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String nome = editNome.getText().toString();

        editor.putString(NOME, nome);

        String email = editEmail.getText().toString();
        editor.putString(EMAIL, email);

        editor.apply();

        String dia = (String)spinnerDia.getSelectedItem();
        String periodo = (String) spinnerPeriodo.getSelectedItem();

        String s = String.format(getString(R.string.mensagem_format), nome, dia, periodo);

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, s);
        intent.setType("plain/text");

        startActivity(intent);
    }
}
