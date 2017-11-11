package com.caramelup.controlerpoint.Registros;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.caramelup.controlerpoint.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegistrarSaidaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_saida);


        final Button Botao2= (Button) findViewById(R.id.Botao2);
        Botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView dataatual2 = (TextView) findViewById(R.id.dataatual2);
                long date2 = System.currentTimeMillis();
                SimpleDateFormat sdf2 = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                }
                String dateString2 = sdf2.format(date2);
                dataatual2.setText(dateString2);


                final TextView horaatual2 = (TextView) findViewById(R.id.horaatual2);
                long hora2 = System.currentTimeMillis();
                SimpleDateFormat sdf4 = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    sdf4 = new SimpleDateFormat("HH:mm:ss");
                }
                Date data2 = new Date();

                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(data2);
                Date data_atual2 = cal2.getTime();

                String hora_atual2 = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    hora_atual2 = sdf4.format(data_atual2);
                }
                String horaString2 = sdf4.format(hora2);

                horaatual2.setText(hora_atual2);

            }
        });
    }

}
