package com.example.andre.compararvalores;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class PrincipalActivity extends AppCompatActivity {
    private Button buttonComparar;
    private EditText editTextValor1;
    private EditText editTextValor2;
    private EditText editTextMl1;
    private EditText editTextMl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        editTextValor1 = (EditText) findViewById(R.id.editTextValor1);
        editTextMl1 = (EditText) findViewById(R.id.editTextMl1);
        editTextValor2 = (EditText) findViewById(R.id.editTextValor2);
        editTextMl2 = (EditText) findViewById(R.id.editTextMl2);
        buttonComparar = (Button) findViewById(R.id.buttonComparar);
        buttonComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double result1, result2, percentual;

                Intent intentComparar = new Intent(PrincipalActivity.this, ResultadoActivity.class);

                Double valor1 = Double.valueOf(editTextValor1.getText().toString());
                Double valor2 = Double.valueOf(editTextValor2.getText().toString());
                Double ml1 = Double.valueOf(editTextMl1.getText().toString());
                Double ml2 = Double.valueOf(editTextMl2.getText().toString());

                result1 = valor1 / ml1;
                result2 = valor2 / ml2;

                if (result1 < result2) {
                    percentual = ((result2 * 100) / result1)-100;
                    intentComparar.putExtra("resultado", percentual);
                    intentComparar.putExtra("opcao", "1a opção");
                } else {
                    percentual = ((result1 * 100) / result2)-100;
                    intentComparar.putExtra("resultado", percentual);
                    intentComparar.putExtra("opcao", "2a opção");
                }

                startActivity(intentComparar);
            }
        });
    }
}