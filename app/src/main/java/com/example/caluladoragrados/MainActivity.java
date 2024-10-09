package com.example.caluladoragrados;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText input_text;
    private RadioGroup radio_group1, radio_group2;
    private TextView textViewResultado;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_text = findViewById(R.id.input_text);
        radio_group1 = findViewById(R.id.radio_group1);
        radio_group2 = findViewById(R.id.radio_group2);
        textViewResultado = findViewById(R.id.result_text);
        button = findViewById(R.id.convert_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirGrados();
            }
        });
    }

    private void convertirGrados() {
        String input = input_text.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
            return;
        }

        double grados;
        try {
            grados = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese un valor numérico válido", Toast.LENGTH_SHORT).show();
            return;
        }

        int idOrigen = radio_group1.getCheckedRadioButtonId();
        int idDestino = radio_group2.getCheckedRadioButtonId();

        if (idOrigen == -1 || idDestino == -1) {
            Toast.makeText(this, "Seleccione un tipo de grados", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioButtonOrigen = findViewById(idOrigen);
        RadioButton radioButtonDestino = findViewById(idDestino);

        String deGrado = radioButtonOrigen.getText().toString();
        String aGrado = radioButtonDestino.getText().toString();

        // Aquí creamos la instancia según la selección de origen
        Grados g = crearInstancia(deGrado, grados);
        if (g == null) {
            Toast.makeText(this, "Error en la conversión", Toast.LENGTH_SHORT).show();
            return;
        }

        // Ahora realizamos la conversión según la selección de destino
        double resultado = convertir(g, aGrado);
        textViewResultado.setText("Resultado: " + resultado);
    }

    private Grados crearInstancia(String tipoGrado, double valor) {
        switch (tipoGrado) {
            case "Celsius":
                return new Celsius(valor, "°C");
            case "Fahrenheit":
                return new Fahrenheit(valor, "°F");
            case "Kelvin":
                return new Kelvin(valor, "K");
            default:
                return null;
        }
    }


    private double convertir(Grados grados, String aGrado) {
        switch (aGrado) {
            case "Celsius":
                if (grados instanceof Fahrenheit) {
                    return ((Fahrenheit) grados).parse(new Celsius(0, "°C")).getValor();
                } else if (grados instanceof Kelvin) {
                    return ((Kelvin) grados).parse(new Celsius(0, "°C")).getValor();
                }
                break;
            case "Fahrenheit":
                if (grados instanceof Celsius) {
                    return ((Celsius) grados).parse(new Fahrenheit(0, "°F")).getValor();
                } else if (grados instanceof Kelvin) {
                    return ((Kelvin) grados).parse(new Fahrenheit(0, "°F")).getValor();
                }
                break;
            case "Kelvin":
                if (grados instanceof Celsius) {
                    return ((Celsius) grados).parse(new Kelvin(0, "K")).getValor();
                } else if (grados instanceof Fahrenheit) {
                    return ((Fahrenheit) grados).parse(new Kelvin(0, "K")).getValor();
                }
                break;
        }
        // Si no hay conversión, devolvemos el valor original
        return grados.getValor();
    }


}
