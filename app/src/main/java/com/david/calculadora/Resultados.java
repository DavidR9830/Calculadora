package com.david.calculadora;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Resultados extends AppCompatActivity {

    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultados);

        displayTextView = findViewById(R.id.displayTextView);


        // Obtener los datos del intent
        String seno = getIntent().getStringExtra("seno");
        String coseno = getIntent().getStringExtra("coseno");
        String resultado2 = getIntent().getStringExtra("resultado2");
        String opcion = getIntent().getStringExtra("opcion");



        // Mostrar los datos en pantalla

        if (Objects.equals(opcion, "sin")) {
            displayTextView.setText("El seno del angulo es: " + seno);
        } else if (Objects.equals(opcion, "cos")) {
            displayTextView.setText("El coseno del angulo es: " + coseno);
        } else if (Objects.equals(opcion, "cuadrado-area")) {
            displayTextView.setText("El área del cuadrado es: " + resultado2);

        } else if (Objects.equals(opcion, "cuadrado-perimetro")) {
            displayTextView.setText("El perímetro del cuadrado es: " + resultado2);

        } else if (Objects.equals(opcion, "rectangulo-area")) {
            displayTextView.setText("El área del rectangulo es: " + resultado2);

        } else if (Objects.equals(opcion, "rectangulo-perimetro")) {
            displayTextView.setText("El perímetro del rectangulo es: " + resultado2);

        } else {
            displayTextView.setText("No se encontraron datos para mostrar.");
        }


    }


}