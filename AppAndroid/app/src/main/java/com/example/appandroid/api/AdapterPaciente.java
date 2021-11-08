package com.example.appandroid.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

public class AdapterPaciente extends RecyclerView.Adapter<AdapterPaciente.ViewHolder>{
    private Paciente[] dsPaciente;
    private ItemClickListener mItemListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_paciente, viewGroup,false);
        ViewHolder pvh=new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPaciente.ViewHolder viewHolder, int i) {
        viewHolder.tvPaciente.setText(dsPaciente[i].getNombre());
        viewHolder.tvEmail.setText(dsPaciente[i].getEmail());

        viewHolder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(dsPaciente[i]);
        });
    }

    @Override
    public int getItemCount() {
        return dsPaciente.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPaciente;
        public TextView tvEmail;
        public ViewHolder (View v) {
            super(v);
            tvPaciente=v.findViewById(R.id.txtPaciente);
            tvEmail=v.findViewById(R.id.txtEmail);
        }
    }

    public AdapterPaciente(Paciente [] listaDePacientes, ItemClickListener itemClickListener) {
        this.dsPaciente=listaDePacientes;
        this.mItemListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(Paciente paciente);
    }

}
