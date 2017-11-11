package com.caramelup.controlerpoint.Registros;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.caramelup.controlerpoint.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegistrarEntradaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entrada);


        final Button Botao = (Button) findViewById(R.id.Botao);
        Botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView dataatual = (TextView) findViewById(R.id.dataatual);
                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    sdf = new SimpleDateFormat("dd/MM/yyyy");
                }
                String dateString = sdf.format(date);
                dataatual.setText(dateString);


                final TextView horaatual = (TextView) findViewById(R.id.horaatual);
                long hora = System.currentTimeMillis();
                SimpleDateFormat sdf3 = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    sdf3 = new SimpleDateFormat("HH:mm:ss");
                }
                Date data = new Date();

                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                Date data_atual = cal.getTime();

                String hora_atual = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    hora_atual = sdf3.format(data_atual);
                }
                String horaString = sdf3.format(hora);

                horaatual.setText(hora_atual);

            }
        });
    }


}
