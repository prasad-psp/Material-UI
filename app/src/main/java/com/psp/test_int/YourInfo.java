package com.psp.test_int;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.psp.test_int.databinding.FragmentYourInfoBinding;
import com.psp.test_int.dialogs.DateSelectorDialog;

import java.util.Calendar;

public class YourInfo extends Fragment implements DateSelectorDialog.DateSelectedListener {

    private FragmentYourInfoBinding binding;

    // Investment dropdown list
    private final String[] investmentTypeList = {"Select","Self","Wife","Family"};

    // Adapter for Investment dropdown list
    private ArrayAdapter spinnerAdapter;

    private Calendar myCalendar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentYourInfoBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // init
        init();

        binding.imgCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity() != null) {
                    DateSelectorDialog.getInstance(YourInfo.this)
                            .openDatePicker(YourInfo.this.requireContext());
                }
            }
        });
    }

    private void init() {
        //Creating the ArrayAdapter for investment dropdown list
        spinnerAdapter = new ArrayAdapter(this.requireContext(),R.layout.spinner_dropdown_list, investmentTypeList);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list_item);
        //Set adapter to investment spinner
        binding.spinInvestment.setAdapter(spinnerAdapter);
    }

    @Override
    public void onDateSelected(String date) {
        binding.txtDate.setText(date);
    }
}