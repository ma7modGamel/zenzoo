package com.baytelhekma.zenzoo.ui.base;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.baytelhekma.zenzoo.ui.fragment.BottomDialogFragment;

import java.util.Locale;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Locale myLocale = new Locale("ar");
        final Resources res = getResources();
        final DisplayMetrics dm = res.getDisplayMetrics();
        final Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    public void replaceFragment(Fragment someFragment, int container) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(container, someFragment);
        transaction.commit();
    }

    public void MyStartActivity(Context from, Class to){
        Intent intent=new Intent(from,to);
        startActivity(intent);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startActivityTransitionAnimation(Activity from, Class to, View view, String sharedElementName){
        Intent intent=new Intent(from,to);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(from, view, sharedElementName).toBundle());
    }

    public void BottomSheetCrate(int count){
        BottomDialogFragment.newInstance(count).show(requireActivity().getSupportFragmentManager(),"ah");

    }
}
