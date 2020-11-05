package com.baytelhekma.zenzoo.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import com.baytelhekma.zenzoo.R;
import com.baytelhekma.zenzoo.databinding.ActivityLoginBinding;
import com.baytelhekma.zenzoo.ui.base.BaseActivity;
import com.baytelhekma.zenzoo.ui.fragment.LoginFragment;
import com.baytelhekma.zenzoo.ui.fragment.SignUpFragment;
import java.util.Locale;


public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Locale myLocale = new Locale("ar");
        final Resources res = getResources();
        final DisplayMetrics dm = res.getDisplayMetrics();
        final Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        String a ="<font color=#000>أهلا بك فى <br> تطبيق</font> <font color=#b31919>زينزو</font>";
        binding.tvWelcome.setText(Html.fromHtml(a));
        SectionsPagerAdapter sectionsPagerAdapter= new SectionsPagerAdapter(this, getSupportFragmentManager());
        binding.viewPager.setAdapter(sectionsPagerAdapter);
        binding.viewPager.setCurrentItem(1);
        binding.tabs.setupWithViewPager(binding.viewPager);
//        binding.tabs.setTabTextColors(getResources().getColor(R.color.black),getResources().getColor(R.color.colorPrimary));
        binding.tabs.setTabTextColors(getResources().getColor(R.color.darkGray), getResources().getColor(R.color.colorPrimary));

        onClick();

    }

    private void onClick() {

    }

    public static class SectionsPagerAdapter extends FragmentPagerAdapter {
        @StringRes
        private final int[] TAB_TITLES = new int[]{R.string.signUp, R.string.login};
        private final Context mContext;
        public SectionsPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return super.getItemPosition(object);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return  SignUpFragment.newInstance("","");
                case 1:
                    return  LoginFragment.newInstance("","");

            }
            return new LoginFragment();
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mContext.getResources().getString(TAB_TITLES[position]);
        }
        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }


    }

}