package com.caramelup.controlerpoint;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDataIni, btnDataFim;
    EditText selDataIni, selDataFim;
    private int dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDataIni = (Button) findViewById(R.id.btnDataIni);
        btnDataFim = (Button) findViewById(R.id.btnDataFim);
        selDataIni = (EditText) findViewById(R.id.selDataIni);
        selDataFim = (EditText) findViewById(R.id.selDataFim);

        btnDataIni.setOnClickListener(this);
        btnDataFim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v==btnDataIni){
            final Calendar c = Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    selDataIni.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            },dia,mes,ano);
            datePickerDialog.show();
        }
        if(v==btnDataFim){
        final Calendar c = Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        ano=c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                selDataFim.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
            }
        },dia,mes,ano);
        datePickerDialog.show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
