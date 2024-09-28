package com.example.prueba4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText elTexto = findViewById(R.id.editTextText);
        TextView elMensaje = findViewById(R.id.textView4);
        Button elBoton = findViewById(R.id.button);

        elBoton.setOnClickListener( new View.OnClickListener() {

            public void onClick(View v) {
//                elMensaje.setText(elTexto.getText());
//                Intent elIntento = new Intent(MainActivity.this, MenuActivity.class);
//                elIntento.putExtra("pasandoElTexto",elTexto.getText().toString());
//                startActivity(elIntento);

                  getSupportFragmentManager().beginTransaction().replace(R.id.my_first_fragment, new OtroFragment()).commit();
            }
        });

    }
}