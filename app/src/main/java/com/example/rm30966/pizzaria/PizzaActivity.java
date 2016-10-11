package com.example.rm30966.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PizzaActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rgPizzas;
    private CheckBox chbBorda;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        rgPizzas = (RadioGroup) findViewById(R.id.rgPizzas);
        rgPizzas.setOnCheckedChangeListener(this);

        chbBorda = (CheckBox) findViewById(R.id.chbRecheada);

        txtResultado = (TextView) findViewById(R.id.txtCalcular);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i==R.id.radMussarela)
        {
            chbBorda.setEnabled(false);
            chbBorda.setChecked(false);
        }
        else
        {
            chbBorda.setEnabled(true);
        }
    }


    public void calcular (View v)
    {
        int saborSelecionado = rgPizzas.getCheckedRadioButtonId();
        int total = 0;

        if (chbBorda.isChecked())
        {
            total += 5;
        }

        if(saborSelecionado == R.id.radMussarela)
        {
            total = 10;
        }
        else if(saborSelecionado == R.id.radCalabresa)
        {
            total += 15;
        }
        else
        {
            total += 20;
        }

        txtResultado.setText(""+total);

    }
}
