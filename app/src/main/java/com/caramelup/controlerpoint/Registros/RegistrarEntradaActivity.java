package com.caramelup.controlerpoint.Registros;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.caramelup.controlerpoint.R;

import java.util.Calendar;

public class RegistrarEntradaActivity extends AppCompatActivity {
    private int dia,mes,ano;
    EditText selDataIni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entrada);

        selDataIni = (EditText) findViewById(R.id.selDataIni);

        Button btnDataIni = (Button) findViewById(R.id.btnDataIni);
        btnDataIni.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Calendar c = Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                ano=c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(RegistrarEntradaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        selDataIni.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                },ano,mes,dia);
                datePickerDialog.show();

            }
        });


    }
}
