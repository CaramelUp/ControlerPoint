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

public class RelatorioActivity extends AppCompatActivity implements View.OnClickListener{

    private int dia,mes,ano;
    EditText selDataIni, selDataFim;
    Button btnDataIni, btnDataFim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        selDataIni = (EditText) findViewById(R.id.selDataIni);
        btnDataIni = (Button) findViewById(R.id.btnDataIni);
        selDataFim = (EditText) findViewById(R.id.selDataFim);
        btnDataFim = (Button) findViewById(R.id.btnDataFim);
        btnDataIni.setOnClickListener(this);
        btnDataFim.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btnDataIni){
            final Calendar c = Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(RelatorioActivity.this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    selDataIni.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            },ano,mes,dia);
            datePickerDialog.show();
        }
        if (view == btnDataFim){
            final Calendar c = Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(RelatorioActivity.this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    selDataFim.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            },ano,mes,dia);
            datePickerDialog.show();
        }

    }
}