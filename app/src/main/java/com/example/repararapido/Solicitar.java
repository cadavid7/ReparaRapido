package com.example.repararapido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.repararapido.Database.Database;
import com.example.repararapido.Model.Solicitud;
import com.example.repararapido.ViewHolder.AdapterSolicitud;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import info.hoang8f.widget.FButton;

public class Solicitar extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference request;

    TextView txtNombrePro;
    TextView txtProfesionPro;

    FButton btnPedir;



    List<Solicitud> contrato = new ArrayList<>();
    AdapterSolicitud adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar);

        database = FirebaseDatabase.getInstance();
        request = database.getReference("Requests");

        recyclerView = findViewById(R.id.ListaSolicitudes);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        btnPedir = (FButton)findViewById(R.id.btnContratar);



        loadListPersonal();
    }

    private void loadListPersonal() {
        contrato = new Database(this).getSolicitudes();
        adapter = new AdapterSolicitud(contrato, this);
        recyclerView.setAdapter(adapter);



    }
    }



