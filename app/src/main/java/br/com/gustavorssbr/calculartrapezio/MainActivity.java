/*
 *@author:Gustavo Rodrigues Santos Silva
 * RA: 1110481922011
 */

package br.com.gustavorssbr.calculartrapezio;

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

    private EditText etBaseMaior;
    private EditText etBaseMenor;
    private EditText etAltura;
    private TextView tvArea;
    private TextView tvDadoInvalido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMaior.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etBaseMenor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etAltura = findViewById(R.id.etAltura);
        etAltura.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        tvArea = findViewById(R.id.tvArea);
        tvArea.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvDadoInvalido = findViewById(R.id.tvDadoInvalido);
        tvDadoInvalido.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        btnCalcular.setOnClickListener(op -> calcular());
    }

    private void calcular() {

        try {
            double baseMaior = Double.parseDouble(etBaseMaior.getText().toString());
            double baseMenor = Double.parseDouble(etBaseMenor.getText().toString());
            double altura = Double.parseDouble(etAltura.getText().toString());

            double area = ((baseMaior + baseMenor) * altura )/ 2;

            String ResArea =getString(R.string.area) + " " + area;
            tvArea.setVisibility(View.VISIBLE);
            tvArea.setText(ResArea);
            tvDadoInvalido.setVisibility(View.GONE);

        }catch (Exception e){
            tvArea.setVisibility(View.GONE);
            tvDadoInvalido.setVisibility(View.VISIBLE);
            tvDadoInvalido.setText(getString(R.string.dado_invalido));
        }
    }
}