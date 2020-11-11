package com.baytelhekma.zenzoo.ui.fragment.home.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.baytelhekma.zenzoo.R;
import com.baytelhekma.zenzoo.databinding.FragmentHomeBinding;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    int page = 0;
    private Handler handler=new Handler();
    private int delay = 1000;
    Runnable runnable;
    ProductAdapter adapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding= FragmentHomeBinding.inflate(inflater, container, false);
        slider();
        adapter=new ProductAdapter();
        adapter.setData(requireActivity());
        binding.recyclerBestSelling.setAdapter(adapter);
        binding.recyclerOffers.setAdapter(adapter);
        binding.recyclerRecentlyCome.setAdapter(adapter);
        binding.recyclerRecentlyViewed.setAdapter(adapter);

        return binding.getRoot();
    }


    private void slider() {
        SliderAdapter adapter=new SliderAdapter();
        ArrayList arrayList=new ArrayList();
        arrayList.add(R.drawable.slider_1);
        arrayList.add(R.drawable.slider_1);
        arrayList.add(R.drawable.slider_1);
        adapter.setData(requireContext(),arrayList);
       binding.bannerView.setAdapter(adapter);
       binding.IndicatorView.setSliderColor(R.color.gray,Color.WHITE)
               .setSliderWidth(50)
               .setSliderHeight(10)
               .setSlideMode(IndicatorSlideMode.SMOOTH)
               .setIndicatorStyle(IndicatorStyle.DASH)
               .setupWithViewPager(binding.bannerView);

       binding.bannerView.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
           @Override
           public void onPageSelected(int position) {
               super.onPageSelected(position);
               handler.removeCallbacks(runnable);
               handler.postDelayed(runnable,2000);
           }
       });
         runnable = () -> {
             if (binding.bannerView.getCurrentItem()==2){

                 binding.bannerView.setCurrentItem(0);
             }else {
                 binding.bannerView.setCurrentItem(binding.bannerView.getCurrentItem()+1);
             }
         };
    }


}