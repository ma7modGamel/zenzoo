package com.baytelhekma.zenzoo.ui.activity;

import androidx.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baytelhekma.zenzoo.R;
import com.baytelhekma.zenzoo.databinding.ActivityMainBinding;
import com.baytelhekma.zenzoo.ui.base.BaseActivity;
import com.bumptech.glide.Glide;

public class SplashScreen extends BaseActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);


        Glide.with(this)
                .load(R.drawable.logo_splash)
                .into(binding.splashImage);

        startAnimation();

    }

    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.slideupdown);
        binding.tv.setAnimation(animation);
        animation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.slidedownup);
        binding.splashImage.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivityTransitionAnimation(SplashScreen.this,LoginActivity.class,binding.splashImage,"logo");
                }else {
                    MyStartActivity(SplashScreen.this,LoginActivity.class);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}