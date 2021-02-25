package com.example.quinto2020_2021.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quinto2020_2021.R;
import com.example.quinto2020_2021.modelos.Docente;

import java.util.List;

public class DocenteAdapter extends RecyclerView.Adapter<DocenteAdapter.ViewHolderDocente> implements View.OnClickListener{

    List<Docente> lista;
    public DocenteAdapter(List<Docente> lista){
        this.lista=lista;
    }
    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public DocenteAdapter.ViewHolderDocente onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //agregando el layout al recycle view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_docente, null);
        return new ViewHolderDocente(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocenteAdapter.ViewHolderDocente holder, int position) {
    holder.cedula.setText(lista.get(position).getCedula());
    holder.nombres.setText(lista.get(position).getNombres());
    holder.apellidos.setText(lista.get(position).getApellidos());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolderDocente extends RecyclerView.ViewHolder{
        TextView cedula,nombres, apellidos;


        public ViewHolderDocente(@NonNull View itemView){
            super(itemView);
            cedula=itemView.findViewById(R.id.lblCedulaRecycler);
            nombres=itemView.findViewById(R.id.lblNombresRecycler);
            apellidos=itemView.findViewById(R.id.lblApellidosRecycler);
        }
    }
}
