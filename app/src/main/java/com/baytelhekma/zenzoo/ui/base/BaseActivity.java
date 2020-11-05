package com.baytelhekma.zenzoo.ui.base;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.baytelhekma.zenzoo.R;
import com.baytelhekma.zenzoo.ui.activity.SplashScreen;

public class BaseActivity extends AppCompatActivity {


    public void replaceFragment(Fragment someFragment,int container) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, someFragment);
        transaction.addToBackStack("a");
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

}
