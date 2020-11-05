package com.baytelhekma.zenzoo.ui.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.baytelhekma.zenzoo.R;
import com.baytelhekma.zenzoo.databinding.FragmentAccountInfoBinding;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AccountInfoFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private FragmentAccountInfoBinding binding;
    private ArrayList<String> gender=new ArrayList<>();
    private ArrayAdapter arrayAdapter;
    public AccountInfoFragment() {
        // Required empty public constructor
    }

    public static AccountInfoFragment newInstance(String param1, String param2) {
        AccountInfoFragment fragment = new AccountInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentAccountInfoBinding.inflate(inflater,container,false);
        onClick();
        gender.add(getString(R.string.gernder_male));
        gender.add(getString(R.string.gernder_female));
        arrayAdapter=new ArrayAdapter(requireActivity(),R.layout.list_item_gender,gender);
        binding.kind.setAdapter(arrayAdapter);

        return binding.getRoot();
    }

    private void onClick() {
        binding.birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                datePicker();
                DatePickerDialog datePicker=new DatePickerDialog(
                        requireActivity(),
                        AccountInfoFragment.this,
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

                );

                datePicker.show();

            }
        });
    }

    private void datePicker() {


    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,i);
        c.set(Calendar.MONTH,i1);
        c.set(Calendar.DAY_OF_MONTH,i2);
        i1+=1;
        String date= i2+"/"+i1+"/"+i;
        binding.birthday.setText(date);
    }
}