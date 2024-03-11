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

public class SenoCoseno extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText txtAngulo;
    private Button btnSin;
    private Button btnCos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seno_coseno);

        radioGroup = findViewById(R.id.radioGroup);
        txtAngulo = findViewById(R.id.txtAngulo);
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);

        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("sin");
            }
        });

        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("cos");
            }
        });
    }

    private void calcular(String funcion) {
        double angulo;
        double coseno =0 ;
        double seno =0 ;

        try {
            angulo = Double.parseDouble(txtAngulo.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(SenoCoseno.this, "Ingrese un ángulo válido", Toast.LENGTH_SHORT).show();
            return;
        }

        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();


        RadioButton radioButton = findViewById(checkedRadioButtonId);
        String opcion = radioButton.getText().toString();

        if (opcion.equals("Grados")) {
            if (funcion.equals("sin")) {
                seno = Math.sin(Math.toRadians(angulo));

            } else if (funcion.equals("cos")) {
                coseno = Math.cos(Math.toRadians(angulo));

            }
        } else if (opcion.equals("Radianes")) {
            if (funcion.equals("sin")) {
                 seno = Math.sin(angulo);

            } else if (funcion.equals("cos")) {
                coseno = Math.cos(angulo);
            }
        }

        Intent intent = new Intent(SenoCoseno.this, Resultados.class);
        intent.putExtra("seno", String.valueOf(seno)).putExtra("coseno",String.valueOf(coseno)).
                putExtra("opcion", funcion);

        startActivity(intent);
    }

}
