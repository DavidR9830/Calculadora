package com.david.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PerimetroArea extends AppCompatActivity {

    private RadioGroup figuraRadioGroup, calculoRadioGroup;
    private EditText baseEditText, alturaEditText;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perimetro_area);

        figuraRadioGroup = findViewById(R.id.figuraRadioGroup);
        calculoRadioGroup = findViewById(R.id.calculoRadioGroup);
        baseEditText = findViewById(R.id.baseEditText);
        alturaEditText = findViewById(R.id.alturaEditText);
        calcularButton = findViewById(R.id.calcularButton);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        int figuraSeleccionadaId = figuraRadioGroup.getCheckedRadioButtonId();
        int calculoSeleccionadoId = calculoRadioGroup.getCheckedRadioButtonId();

        if (figuraSeleccionadaId == -1 || calculoSeleccionadoId == -1) {
            Toast.makeText(this, "Por favor, seleccione una figura y un cálculo.", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton figuraRadioButton = findViewById(figuraSeleccionadaId);
        RadioButton calculoRadioButton = findViewById(calculoSeleccionadoId);

        double base = Double.parseDouble(baseEditText.getText().toString());
        double altura = Double.parseDouble(alturaEditText.getText().toString());
        String opcion = "";

        double resultado2 = 0;

        if (figuraRadioButton.getId() == R.id.cuadradoRadioButton) {
            if (calculoRadioButton.getId() == R.id.areaRadioButton) {
                resultado2 = base * base;
                opcion = "cuadrado-area";
            } else if (calculoRadioButton.getId() == R.id.perimetroRadioButton) {
                resultado2 = 4 * base;
                opcion = "cuadrado-perimetro";
            }
        } else if (figuraRadioButton.getId() == R.id.rectanguloRadioButton) {
            if (calculoRadioButton.getId() == R.id.areaRadioButton) {
                resultado2 = base * altura;
                opcion = "rectangulo-area";
            } else if (calculoRadioButton.getId() == R.id.perimetroRadioButton) {
                resultado2 = 2 * (base + altura);
                opcion = "rectangulo-perimetro";
            }
        }

        // Enviar el resultado a la actividad ResultadosActivity
        Intent intent = new Intent(this, Resultados.class);
        intent.putExtra("resultado2", String.valueOf(resultado2)).putExtra("opcion", (opcion));
        startActivity(intent);

    }
}
