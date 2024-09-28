package com.example.prueba4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.Manifest;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    TextView mensaje;

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

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new
                    String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 1001); //Any number can be used
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
                this);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
    @Override
    public void onLocationChanged(@NonNull Location location) {
        mensaje.setText(String.format("%s : %s", location.getLatitude(), location.getLongitude()));
    }
    @Override
    public void onProviderEnabled(@NonNull String provider) {
    }
    @Override
    public void onProviderDisabled(@NonNull String provider) {
    }
    }
