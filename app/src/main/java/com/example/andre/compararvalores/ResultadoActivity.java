package com.example.andre.compararvalores;

import android.annotation.TargetApi;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView textViewResultado = (TextView) findViewById(R.id.textViewResultado);
        Bundle result = getIntent().getExtras();
        String resultado = "";
        String opcao = "";
        if (result != null) {
            resultado = String.valueOf(result.getDouble("resultado"));
            opcao = result.getString("opcao");
        }

        textViewResultado.setText("A "+ opcao+" está compensando mais " +
                "porque está "+resultado+" % mais barata");
    }
}
