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

public class MainActivity extends AppCompatActivity {

    Boolean switchValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBoxLunes = (CheckBox) findViewById(R.id.L);
        CheckBox checkBoxMartes = (CheckBox) findViewById(R.id.M);
        CheckBox checkBoxMiercoles = (CheckBox) findViewById(R.id.X);
        CheckBox checkBoxJueves = (CheckBox) findViewById(R.id.J);
        CheckBox checkBoxViernes = (CheckBox) findViewById(R.id.V);
        CheckBox checkBoxSabado = (CheckBox) findViewById(R.id.S);
        CheckBox checkBoxDomingo = (CheckBox) findViewById(R.id.D);
        final Switch miSwitch = (Switch) findViewById(R.id.miSwitch);
        Button buttonOk = (Button) findViewById(R.id.buttonOk) ;
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);


        miSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) switchValue = true;
                else switchValue = false;
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Aqui esta el intent
                Intent intentAlarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, editText.getText().toString())
                        .putExtra(AlarmClock.EXTRA_HOUR, timePicker.getCurrentHour())
                        .putExtra(AlarmClock.EXTRA_MINUTES, timePicker.getCurrentMinute())
                        .putExtra(AlarmClock.EXTRA_VIBRATE, switchValue);

                if(intentAlarma.resolveActivity(getPackageManager()) != null) startActivity(intentAlarma);

            }
        });

    }
}
