package com.example.appandroid.ficha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

public class AdapterCategoria extends RecyclerView.Adapter<AdapterCategoria.ViewHolder>{
    private Categoria[] dsCategoria;
    private ItemClickListener mItemListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_categoria, viewGroup,false);
        ViewHolder pvh=new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategoria.ViewHolder viewHolder, int i) {
        viewHolder.tvCategoria.setText(dsCategoria[i].getDescripcion());
        viewHolder.tvSubCategoria.setText(dsCategoria[i].getDescripcion());

        viewHolder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(dsCategoria[i]);
        });
    }

    @Override
    public int getItemCount() {
        return dsCategoria.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCategoria;
        public TextView tvSubCategoria;

        public ViewHolder (View v) {
            super(v);
            tvCategoria=v.findViewById(R.id.txtCategoria);
            tvSubCategoria=v.findViewById(R.id.txtSubCategoria);
        }
    }

    public AdapterCategoria(Categoria [] listaDeCategorias, ItemClickListener itemClickListener) {
        this.dsCategoria=listaDeCategorias;
        this.mItemListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(Categoria categoria);
    }

}
