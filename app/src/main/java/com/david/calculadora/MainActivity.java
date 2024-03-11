package com.david.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonSenoCoseno = findViewById(R.id.botonSenoCoseno);
        Button botonPerimetroArea = findViewById(R.id.botonPerimetroArea);

        botonSenoCoseno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SenoCoseno.class);
                startActivity(intent);
            }
        });

        botonPerimetroArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerimetroArea.class);
                startActivity(intent);
            }
        });




    }
}
