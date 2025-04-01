package br.fecap.ads.calculadoraimc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

import br.fecap.ads.calculadoraimc.R;

public class CalculoIMCActivity extends AppCompatActivity {

    public static final String extra_imc = "br.fecap.ads.calculadoraimc.extra_imc";
    public static final String extra_altura = "br.fecap.ads.calculadoraimc.extra_altura";
    public static final String extra_peso = "br.fecap.ads.calculadoraimc.extra_peso";
    public static final String extra_classificacao = "br.fecap.ads.calculadoraimc.extra_classificacao";

    private Button btnSet;
    private Button btnReset;
    private EditText campoAltura;
    private EditText campoPeso;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculo_imc_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculaIMC(View view){

        // Vinculando os elementos com os Views
        btnSet  = findViewById(R.id.btnSet);
        btnReset = findViewById(R.id.btnReset);
        campoAltura = findViewById(R.id.editTextAltura);
        campoPeso = findViewById(R.id.editTextPeso);
        textResultado = findViewById(R.id.textResultado);

        // Variaveis para recuperar (get) e converter em String:
        String altura = campoAltura.getText().toString();
        String peso = campoPeso.getText().toString();

        // Converter os dados para Numerico:
        Double numAltura = Double.parseDouble(altura);
        Double numPeso = Double.parseDouble(peso);
        Double numImc = numPeso / (numAltura * numAltura);

        // Converter o resultado numImc -> String imc
        //String imc = String.valueOf(numImc);

        DecimalFormat df = new DecimalFormat("##.##");
        String imc = df.format(numImc);

        // Apresentar o resultado:
        textResultado.setText(imc + "kg/m²");

        String classificacao = "";

        Intent intent;
        if (numImc < 18.5) {
            // Abaixo do peso
            classificacao = "Abaixo do peso";
            intent = new Intent(this, AbaixoDoPesoActivity.class);
        } else if (numImc <= 24.9 && numImc >= 18.6) {
            // Peso ideal
            classificacao = "Peso ideal";
            intent = new Intent(this, PesoNormalActivity.class);
        } else if (numImc <= 29.9 && numImc >= 25) {
            // Sobrepeso
            classificacao = "Sobrepeso";
            intent = new Intent(this, SobrePesoActivity.class);
        } else if (numImc <= 34.9 && numImc >= 30) {
            // Obesidade grau 1
            classificacao = "Obesidade grau 1";
            intent = new Intent(this, Obesidade1Activity.class);
        }else if (numImc < 39.9 && numImc >= 35) {
            // Obesidade grau 2
            classificacao = "Obesidade grau 2";
            intent = new Intent(this, Obesidade2Activity.class);
        } else {
            // Obesidade grau 3
            classificacao = "Obesidade grau 3";
            intent = new Intent(this, Obesidade3Activity.class);
        }

        intent.putExtra(extra_classificacao, classificacao);
        intent.putExtra(extra_imc, imc);
        intent.putExtra(extra_altura, altura);
        intent.putExtra(extra_peso, peso);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 2000);

    }


    public void clear(View view){
        btnReset = findViewById(R.id.btnReset);
        campoAltura = findViewById(R.id.editTextAltura);
        campoPeso = findViewById(R.id.editTextPeso);

        campoAltura.setText("");
        campoPeso.setText("");
    }

}