package com.example.repararapido;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.repararapido.Database.Database;
import com.example.repararapido.Model.Personal;
import com.example.repararapido.Model.Solicitud;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class PersonalDetail extends AppCompatActivity {

    TextView personal_nombre,personal_horario,personal_descripcion;
    ImageView personal_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnSolicitar;
    String menuId="";
    FirebaseDatabase database;
    DatabaseReference personal;

    Personal currentPersonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detail);


        database = FirebaseDatabase.getInstance();
        personal = database.getReference("Personal");

        btnSolicitar = findViewById(R.id.btnSolicitar);

        btnSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailactivity = new Intent(PersonalDetail.this,emailActivity.class);
                startActivity(emailactivity);
            }
        });

        personal_descripcion = findViewById(R.id.personal_descripcion);
        personal_nombre = findViewById(R.id.personal_name);
        personal_horario = findViewById(R.id.personal_horario);
        personal_image = findViewById(R.id.img_personal);

        collapsingToolbarLayout = findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        if(getIntent() != null)
            menuId = getIntent().getStringExtra("MenuId");
        if(!menuId.isEmpty()){
            getDetailPersonal(menuId);
        }

    }

    private void getDetailPersonal(String menuId) {

        personal.child(menuId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentPersonal = dataSnapshot.getValue(Personal.class);
                Picasso.get().load(currentPersonal.getImage()).into(personal_image);
                personal_descripcion.setText(currentPersonal.getDescripcion());
                personal_horario.setText(currentPersonal.getHorario());
                personal_nombre.setText(currentPersonal.getName());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
