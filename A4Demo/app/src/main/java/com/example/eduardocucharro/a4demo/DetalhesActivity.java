package com.example.eduardocucharro.a4demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetalhesActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textCurso;
    private EditText editNome;
    private EditText editEmail;
    private Spinner spinnerDias;
    private Spinner spinnerPeriodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        textCurso = (TextView)findViewById(R.id.text_curso);
        editNome = (EditText) findViewById(R.id.edit_nome);
        editEmail = (EditText) findViewById(R.id.edit_email);
        spinnerDias = (Spinner) findViewById(R.id.spinner_dias);
        spinnerPeriodos = (Spinner) findViewById(R.id.spinner_periodo);
    }

    @Override
    public void onClick(View v) {
        String format = getString(R.string.mensagem_format);

        String mensagem = String.format(format, editNome.getText().toString(), spinnerDias.getSelectedItem(), spinnerPeriodos.getSelectedItem());

        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
