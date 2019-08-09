package com.example.repararapido.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repararapido.Interface.ItemClickListener;
import com.example.repararapido.R;

import org.w3c.dom.Text;


public class PersonalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView personal_name;
    public TextView personal_profesion;
    public ImageView personal_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public PersonalViewHolder(@NonNull View itemView) {
        super(itemView);
        personal_name = (TextView) itemView.findViewById(R.id.personal_name);
        personal_profesion = itemView.findViewById(R.id.personal_Profesion);
        personal_image = (ImageView) itemView.findViewById(R.id.personal_image);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
