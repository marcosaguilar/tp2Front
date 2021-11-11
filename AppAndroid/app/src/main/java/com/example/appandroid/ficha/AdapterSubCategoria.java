package com.example.appandroid.ficha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

public class AdapterSubCategoria extends RecyclerView.Adapter<AdapterSubCategoria.ViewHolder>{
    private SubCategoria[] dsSubCategoria;
    private ItemClickListener mItemListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_subcategoria, viewGroup,false);
        ViewHolder pvh=new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSubCategoria.ViewHolder viewHolder, int i) {
        viewHolder.tvSubCategoriaDescripcion.setText(dsSubCategoria[i].getDescripcion());

        viewHolder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(dsSubCategoria[i]);
        });
    }

    @Override
    public int getItemCount() {
        return dsSubCategoria.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvSubCategoriaDescripcion;

        public ViewHolder (View v) {
            super(v);
            tvSubCategoriaDescripcion=v.findViewById(R.id.txtSubcategoriaDescripcion);
        }
    }

    public AdapterSubCategoria(SubCategoria [] listaDeSubCategorias, ItemClickListener itemClickListener) {
        this.dsSubCategoria=listaDeSubCategorias;
        this.mItemListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(SubCategoria subcategoria);
    }

}
