package com.baytelhekma.zenzoo.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.baytelhekma.zenzoo.R;
import com.baytelhekma.zenzoo.databinding.ActivityProductDetailsBinding;
import com.baytelhekma.zenzoo.ui.base.BaseActivity;
import com.baytelhekma.zenzoo.ui.fragment.BottomDialogFragment;
import com.baytelhekma.zenzoo.ui.fragment.home.home.ProductAdapter;

public class ProductDetailsActivity extends BaseActivity {

    ActivityProductDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_product_details);

        ProductAdapter adapter=new ProductAdapter();
        adapter.setData(this);
        binding.productRecycler.setAdapter(adapter);
        binding.order.setOnClickListener(view -> {
//            BottomSheetCrate();

            BottomDialogFragment.newInstance(5).show(getSupportFragmentManager(),"ahmed");
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        });
    }
}