package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editTextAlcool);
        editPrecoGasolina = findViewById(R.id.editTextGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void CalcularPreco(View view) {
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = ValidarEntradas(precoAlcool, precoGasolina);
        if(camposValidados) {
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double resultado = valorAlcool / valorGasolina;
            if(resultado >= 0.7) {
                textResultado.setText("Melhor abastecer Gasolina");
            }else {
                textResultado.setText("Melhor abastecer Álcool");
            }
        }else {
            textResultado.setText("Preencha os dois campos primeiro!");
        }
    }

    public Boolean ValidarEntradas(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;
        if(pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }

}