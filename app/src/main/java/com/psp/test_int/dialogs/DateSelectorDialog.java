package com.psp.test_int.dialogs;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.DatePicker;

import com.psp.test_int.R;

import java.util.Calendar;

public class DateSelectorDialog {

    private static DateSelectedListener listener;

    private Calendar myCalendar;

    private static DateSelectorDialog instance;


    public static synchronized DateSelectorDialog getInstance(DateSelectedListener attachListener) {
        if(instance == null) {
            instance = new DateSelectorDialog();
            Log.d("PSP","init date picker");
        }
        listener = attachListener;
        return instance;
    }

    public void openDatePicker(Context context) {
        // init calendar
        myCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog=  new DatePickerDialog(context, R.style.DialogTheme, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            int month = monthOfYear + 1;
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String date = getDay(String.valueOf(dayOfMonth))+"-"+getMonth(String.valueOf(month))+"-"+year;
            if(listener != null) {
                listener.onDateSelected(date);
            }
        }
    };

    private String getDay(String dayOfMonth) {
        if(dayOfMonth.length() == 1) {
            dayOfMonth = "0"+dayOfMonth;
        }
        return dayOfMonth;
    }

    private String getMonth(String month) {
        if(month.length() == 1) {
            month = "0"+month;
        }
        return month;
    }


    public interface DateSelectedListener {
        void onDateSelected(String date);
    }
}
