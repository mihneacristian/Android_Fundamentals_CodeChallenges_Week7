package com.mihneacristian.codechallenge3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView textViewDatePicker;
    private TextView textViewDateTimePicker;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDatePicker = findViewById(R.id.textViewDatePicker);
        textViewDateTimePicker = findViewById(R.id.textViewDateTimePicker);
    }

    public void onClickDatePicker(View view) {
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.getTime();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                textViewDatePicker.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void onClickDateTimePicker(View view) {
        final Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textViewDateTimePicker.setText(hourOfDay + ":" + minute);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }
}