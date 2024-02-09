package com.example.master;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    private EditText txtnum1, txtnum2;
    private TextView lblrespuesta;
    private RadioGroup optCalculadora;
    private Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnum1 = findViewById(R.id.txtnum1);
        txtnum2 = findViewById(R.id.txtnum2);
        lblrespuesta = findViewById(R.id.lblrespuesta);
        optCalculadora = findViewById(R.id.optCalculadora);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularResultado();
            }
        });
    }

    public void calcularResultado() {
        double num1 = Double.parseDouble(txtnum1.getText().toString());
        double num2 = 0;
        if (!txtnum2.getText().toString().isEmpty()) {
            num2 = Double.parseDouble(txtnum2.getText().toString());
        }

        int selectedId = optCalculadora.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);

        double resultado = 0;

        if (selectedRadioButton.getId() == R.id.optSuma) {
            resultado = num1 + num2;
        } else if (selectedRadioButton.getId() == R.id.optResta) {
            resultado = num1 - num2;
        } else if (selectedRadioButton.getId() == R.id.optMultiplicacion) {
            resultado = num1 * num2;
        } else if (selectedRadioButton.getId() == R.id.optDivision) {
            if (num2 != 0) {
                resultado = num1 / num2;
            } else {
                lblrespuesta.setText("No es posible dividir por cero");
                return;
            }
        } else if (selectedRadioButton.getId() == R.id.optExponenciacion) {
            resultado = Math.pow(num1, num2);
        } else if (selectedRadioButton.getId() == R.id.optPorcentaje) {
            resultado = (num1 * num2) / 100;

        }  else if (selectedRadioButton.getId() == R.id.optFactorial) {
            resultado = factorial((int)num1);
        } else if (selectedRadioButton.getId() == R.id.optRaiz) {
            if (num1 >= 0) {
                resultado = Math.sqrt(num1);
            } else {
                lblrespuesta.setText("No es posible calcular la raíz cuadrada de un número negativo");
                return;
            }
        }


        lblrespuesta.setText("Respuesta: " + resultado);
    }
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}