package com.baytelhekma.zenzoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;

import com.baytelhekma.zenzoo.R;
import com.baytelhekma.zenzoo.databinding.ActivityForgetPasswordBinding;
import com.baytelhekma.zenzoo.ui.base.BaseActivity;
import com.baytelhekma.zenzoo.ui.fragment.ForgetPasswordFragment;

public class ForgetPasswordActivity extends BaseActivity {

    ActivityForgetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_forget_password);

        replaceFragment(new ForgetPasswordFragment(),R.id.framLayout);
        onClick();
    }

    private void onClick() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
//            ActivityCompat.finishAffinity(this);
        } else {
            getSupportFragmentManager().popBackStack("a", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}