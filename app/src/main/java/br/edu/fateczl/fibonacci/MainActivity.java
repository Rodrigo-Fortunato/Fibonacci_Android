package br.edu.fateczl.fibonacci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etValorInicial;
    private TextView tvResultado;

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

        etValorInicial = findViewById(R.id.etValorInicial);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        etValorInicial.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        btnCalcular.setOnClickListener(op -> calcular());
    }

    private void calcular(){
        int valorInicial = Integer.parseInt(etValorInicial.getText().toString());
        if (valorInicial < 20 && valorInicial > 0) {
            String result = calcularFibonacci(valorInicial) ;
            tvResultado.setText(result);
        }else{
            tvResultado.setText("");
            Toast.makeText(getApplicationContext(),R.string.ValorInvalido,Toast.LENGTH_SHORT).show();
        }

    }

    private String calcularFibonacci(int valorInicial){
        StringBuilder builder = new StringBuilder();
        int resulAntigo=0;
        int resultAtual=1;
        int resultNovo;

        builder.append(resultAtual);
        for (int i=1; i < valorInicial;i++){
            resultNovo = resulAntigo+resultAtual;
            builder.append(",");
            builder.append(resultNovo);
            resulAntigo = resultAtual;
            resultAtual = resultNovo;

        }

        return builder.toString();
    }

    //Apenas um teste
    private String calculaRecFibo(int valorInicial, int nTerm, int resultAntigo, int resultAtual){

        StringBuilder builder = new StringBuilder();
        if (nTerm < valorInicial){
           builder.append(calculaRecFibo(valorInicial,nTerm+1,resultAtual, resultAtual+resultAntigo));
           builder.append(",");
        }else {

        }
        builder.append(resultAtual);
        return builder.toString();

    }

}