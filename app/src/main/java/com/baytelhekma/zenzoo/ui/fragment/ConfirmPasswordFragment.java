package com.baytelhekma.zenzoo.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baytelhekma.zenzoo.R;
import com.baytelhekma.zenzoo.databinding.FragmentConfirmPasswordBinding;
import com.baytelhekma.zenzoo.ui.base.BaseFragment;

import java.util.Locale;

public class ConfirmPasswordFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    FragmentConfirmPasswordBinding binding;
    CountDownTimer countDownTimer;
    private long timeLiftInMillSeconds=90000;

    public ConfirmPasswordFragment() {
        // Required empty public constructor
    }
    public static ConfirmPasswordFragment newInstance(String param1, String param2) {
        ConfirmPasswordFragment fragment = new ConfirmPasswordFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentConfirmPasswordBinding.inflate(inflater, container, false);

        startTimer();
        onClick();
        return binding.getRoot();
    }

    private void onClick() {
        binding.resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeLiftInMillSeconds=90000;
                startTimer();
            }
        });

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ChangePasswordFragment(),R.id.framLayout);
            }
        });

    }

    private void startTimer() {
        countDownTimer=new CountDownTimer(timeLiftInMillSeconds,1000) {
            @Override
            public void onTick(long l) {
                timeLiftInMillSeconds=l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                binding.resend.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    private void updateTimer() {
        int min=(int) (timeLiftInMillSeconds/1000)/60;
        int sec=(int) (timeLiftInMillSeconds/1000)%60;
        String timeLeftText;
        timeLeftText=String.format(Locale.getDefault(),"%02d:%02d",min,sec);

        binding.timer.setText(timeLeftText);
    }
}