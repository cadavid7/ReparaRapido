package com.example.repararapido.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repararapido.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtMenuName;
    public ImageView imageView;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);

       // txtMenuName = (TextView) itemView.findViewById(R.id)
    }

    @Override
    public void onClick(View view) {

    }
}
