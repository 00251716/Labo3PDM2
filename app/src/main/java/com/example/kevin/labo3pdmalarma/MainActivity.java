package com.example.kevin.labo3pdmalarma;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Boolean switchValue;
    ArrayList<Integer> diasAlarma = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obteniendo los widgets del heap

        final CheckBox checkBoxLunes = (CheckBox) findViewById(R.id.L);
        final CheckBox checkBoxMartes = (CheckBox) findViewById(R.id.M);
        final CheckBox checkBoxMiercoles = (CheckBox) findViewById(R.id.X);
        final CheckBox checkBoxJueves = (CheckBox) findViewById(R.id.J);
        final CheckBox checkBoxViernes = (CheckBox) findViewById(R.id.V);
        final CheckBox checkBoxSabado = (CheckBox) findViewById(R.id.S);
        final CheckBox checkBoxDomingo = (CheckBox) findViewById(R.id.D);
        final Switch miSwitch = (Switch) findViewById(R.id.miSwitch);
        Button buttonOk = (Button) findViewById(R.id.buttonOk) ;
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);


        //seteando las acciones apropiadads

        checkBoxLunes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxLunes.isChecked()) diasAlarma.add(Calendar.MONDAY);
            }
        });


        checkBoxMartes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxMartes.isChecked()) diasAlarma.add(Calendar.TUESDAY);
            }
        });


        checkBoxMiercoles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxMiercoles.isChecked()) diasAlarma.add(Calendar.WEDNESDAY);
            }
        });


        checkBoxJueves.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxJueves.isChecked()) diasAlarma.add(Calendar.THURSDAY);
            }
        });


        checkBoxViernes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxViernes.isChecked()) diasAlarma.add(Calendar.FRIDAY);
            }
        });


        checkBoxSabado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxSabado.isChecked()) diasAlarma.add(Calendar.SATURDAY);
            }
        });


        checkBoxDomingo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxDomingo.isChecked()) diasAlarma.add(Calendar.SUNDAY);
            }
        });

        miSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) switchValue = true;
                else switchValue = false;
            }
        });

        //Aqui se envian los datos recolectados arriba

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Aqui esta el intent
                Intent intentAlarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, editText.getText().toString())
                        .putExtra(AlarmClock.EXTRA_HOUR, timePicker.getCurrentHour())
                        .putExtra(AlarmClock.EXTRA_MINUTES, timePicker.getCurrentMinute())
                        .putExtra(AlarmClock.EXTRA_VIBRATE, switchValue)
                        .putExtra(AlarmClock.EXTRA_DAYS, diasAlarma);

                if(intentAlarma.resolveActivity(getPackageManager()) != null) startActivity(intentAlarma);

                diasAlarma.clear(); //Hay que limpiar el arreglo, si no hay problemas
            }
        });

    }
}
