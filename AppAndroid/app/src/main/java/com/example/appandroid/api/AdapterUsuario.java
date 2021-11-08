package com.example.appandroid.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.ViewHolder>{
    private Usuario[] dsUsuario;
    private ItemClickListener mItemListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup,false);
        ViewHolder pvh=new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsuario.ViewHolder viewHolder, int i) {
        viewHolder.tvUsuario.setText(dsUsuario[i].getName());
        viewHolder.tvEmail.setText(dsUsuario[i].getEmail());

        viewHolder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(dsUsuario[i]);
        });
    }

    @Override
    public int getItemCount() {
        return dsUsuario.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvUsuario;
        public TextView tvEmail;
        public ViewHolder (View v) {
            super(v);
            tvUsuario=v.findViewById(R.id.txtUsuario);
            tvEmail=v.findViewById(R.id.txtEmail);
        }
    }

    public AdapterUsuario(Usuario [] listaDeUsuarios, ItemClickListener itemClickListener) {
        this.dsUsuario=listaDeUsuarios;
        this.mItemListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(Usuario usuario);
    }

}
