package com.example.appandroid.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

public class AdapterReserva extends RecyclerView.Adapter<AdapterReserva.ViewHolder>{
    private Reserva[] dsReserva;
    private ItemClickListener mItemListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_reserva, viewGroup,false);
        ViewHolder pvh=new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReserva.ViewHolder viewHolder, int i) {
        viewHolder.tvEmpleado.setText(dsReserva[i].getIdEmpleado().getNombre());
        viewHolder.tvCliente.setText(dsReserva[i].getIdCliente().getNombre());
        viewHolder.tvFecha.setText(dsReserva[i].getFechaCadena());
        viewHolder.tvHoraInicio.setText(dsReserva[i].getHoraInicioCadena());
        viewHolder.tvHoraFin.setText(dsReserva[i].getHoraFinCadena());

        viewHolder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(dsReserva[i]);
        });
    }

    @Override
    public int getItemCount() {
        return dsReserva.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvEmpleado;
        public TextView tvCliente;
        public TextView tvFecha;
        public TextView tvHoraInicio;
        public TextView tvHoraFin;
        public ViewHolder (View v) {
            super(v);
            tvEmpleado=v.findViewById(R.id.txtEmpleado);
            tvCliente=v.findViewById(R.id.txtCliente);
            tvFecha=v.findViewById(R.id.txtFechaCadena);
            tvHoraInicio=v.findViewById(R.id.txtHoraInicioCadena);
            tvHoraFin=v.findViewById(R.id.txtHoraFinCadena);
        }
    }

    public AdapterReserva(Reserva [] listaDeReservas, ItemClickListener itemClickListener) {
        this.dsReserva=listaDeReservas;
        this.mItemListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(Reserva reserva);
    }

}
