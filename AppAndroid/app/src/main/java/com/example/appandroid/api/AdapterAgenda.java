package com.example.appandroid.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

public class AdapterAgenda extends RecyclerView.Adapter<AdapterAgenda.ViewHolder>{
    private Agenda[] dsAgenda;
    private ItemClickListener mItemListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_agenda, viewGroup,false);
        ViewHolder pvh=new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAgenda.ViewHolder viewHolder, int i) {
        viewHolder.tvHoraInicio.setText(dsAgenda[i].getHoraInicio());
        viewHolder.tvHoraFin.setText(dsAgenda[i].getHoraFin());

        viewHolder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(dsAgenda[i]);
        });
    }

    @Override
    public int getItemCount() {
        return dsAgenda.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHoraInicio;
        public TextView tvHoraFin;
        public ViewHolder (View v) {
            super(v);
            tvHoraInicio=v.findViewById(R.id.txtHoraInicioAgenda);
            tvHoraFin=v.findViewById(R.id.txtHoraFinAgenda);
        }
    }

    public AdapterAgenda(Agenda [] listaDeAgendas, ItemClickListener itemClickListener) {
        this.dsAgenda=listaDeAgendas;
        this.mItemListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(Agenda agenda);
    }

}
