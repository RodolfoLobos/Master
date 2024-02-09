package com.example.master;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtnum1, txtnum2;
    private TextView lblrespuesta;
    private RadioGroup optCalculadora;
    private Button btnCalcular;
    TabHost tbh;
    TextView tempVal;
    Button btn;
    Spinner spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}