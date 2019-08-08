package com.example.repararapido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.repararapido.Interface.ItemClickListener;
import com.example.repararapido.Model.Personal;
import com.example.repararapido.ViewHolder.PersonalViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaPersonal extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference listaPersonal;

    String categoryId="";

    FirebaseRecyclerAdapter<Personal, PersonalViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personal);

        database = FirebaseDatabase.getInstance();
        listaPersonal = database.getReference("Personal");

        recyclerView = findViewById(R.id.recycler_personal);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        if(getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if(!categoryId.isEmpty() && categoryId != null){
            loadListPersonal(categoryId);
        }

    }
    private void loadListPersonal(String categoryId){

        adapter = new FirebaseRecyclerAdapter<Personal, PersonalViewHolder>(Personal.class,
                R.layout.personal_item,
                PersonalViewHolder.class,
                listaPersonal.orderByChild("MenuId").equalTo(categoryId)
                ) {
            @Override
            protected void populateViewHolder(PersonalViewHolder viewHolder, Personal model, int position) {
                viewHolder.personal_name.setText(model.getName());
                Picasso.get().load(model.getImage())
                .into(viewHolder.personal_image);

                final Personal local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent personalDetail = new Intent(ListaPersonal.this,PersonalDetail.class);
                    }
                });
            }
        };

        recyclerView.setAdapter(adapter);
    }
}
