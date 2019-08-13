package com.example.repararapido.ViewHolder;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.repararapido.Interface.ItemClickListener;
import com.example.repararapido.Model.Solicitud;
import com.example.repararapido.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class SolicitudViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtNombreEmpleado,txtProfesionEmpleado;

    private ItemClickListener itemClickListener;

    public void setTxtNombreEmpleado(TextView txtNombreEmpleado){
        this.txtNombreEmpleado = txtNombreEmpleado;
    }

    public SolicitudViewHolder(@NonNull View itemView) {
        super(itemView);

        txtNombreEmpleado = (TextView)itemView.findViewById(R.id.NombrePersonal);
        txtProfesionEmpleado = (TextView)itemView.findViewById(R.id.profesion);
    }

    @Override
    public void onClick(View view) {

    }
}

public class AdapterSolicitud extends RecyclerView.Adapter<SolicitudViewHolder> {

    private List<Solicitud> listData = new ArrayList<>();
    private Context context;

    public AdapterSolicitud(List<Solicitud> listData, Context context){
        this.listData = listData;
        this.context = context;
    }
    @NonNull
    @Override
    public SolicitudViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.solicitud_layout,parent,false);

        return new SolicitudViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SolicitudViewHolder holder, int position) {
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(""+listData.get(position).getEmpleadoCategoria(), Color.RED);

        Locale locale = new Locale("en", "US");

        holder.txtNombreEmpleado.setText(listData.get(position).getEmpleadoNombre());
        holder.txtProfesionEmpleado.setText(listData.get(position).getEmpleadoCategoria());


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
