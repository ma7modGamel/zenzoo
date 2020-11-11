package com.baytelhekma.zenzoo.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.baytelhekma.zenzoo.ui.fragment.home.home.ProductAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baytelhekma.zenzoo.R;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     BottomDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class BottomDialogFragment extends BottomSheetDialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    RecyclerView recyclerView;
    // TODO: Customize parameters
    public static BottomDialogFragment newInstance(int itemCount) {
        final BottomDialogFragment fragment = new BottomDialogFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_ITEM_COUNT, itemCount);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_bottom_dialog_list_dialog, container, false);



        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final ConstraintLayout constraintLayout = (ConstraintLayout) view;
        recyclerView=constraintLayout.findViewById(R.id.recyclerSort);
        ItemAdapter adapter=new ItemAdapter(5);
        recyclerView.setAdapter(adapter);
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView text;
        ConstraintLayout constraintLayout;
        ImageView imageView;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.fragment_bottom_dialog_list_dialog_item, parent, false));
            text = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.check);
            constraintLayout = itemView.findViewById(R.id.itemContainer);
        }
    }

    private static class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        private final int mItemCount;

        ItemAdapter(int itemCount) {
            mItemCount = itemCount;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text.setText("Ahmed");
            holder.constraintLayout.setOnClickListener(view -> {
                holder.imageView.setVisibility(View.VISIBLE);
                holder.constraintLayout.setBackgroundColor(holder.imageView.getContext().getResources().getColor(R.color.pink));

            });
        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

    }

}