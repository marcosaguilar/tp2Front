package com.example.appandroid.ficha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appandroid.R;

public class AdapterFicha extends RecyclerView.Adapter<AdapterFicha.ViewHolder>{
    private Ficha[] dsFicha;
    private ItemClickListener mItemListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_ficha, viewGroup,false);
        ViewHolder pvh=new ViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFicha.ViewHolder viewHolder, int i) {
        viewHolder.tvEmpleado.setText(dsFicha[i].getIdEmpleado().getNombre());
        viewHolder.tvCliente.setText(dsFicha[i].getIdCliente().getNombre());
        viewHolder.tvFecha.setText(dsFicha[i].getFechaHoraCadena());
        //viewHolder.tvHoraInicio.setText(dsFicha[i].getFechaDesdeCadena());
        //viewHolder.tvHoraFin.setText(dsFicha[i].getFechaHastaCadena());
        viewHolder.tvMotivoConsulta.setText(dsFicha[i].getMotivoConsulta());
        viewHolder.tvDiagnostico.setText(dsFicha[i].getDiagnostico());
        viewHolder.tvObservacion.setText(dsFicha[i].getObservacion());



        viewHolder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(dsFicha[i]);
        });
    }

    @Override
    public int getItemCount() {
        return dsFicha.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvEmpleado;
        public TextView tvCliente;
        public TextView tvFecha;
        public TextView tvHoraInicio;
        public TextView tvHoraFin;
        public TextView tvMotivoConsulta;
        public TextView tvDiagnostico;
        public TextView tvObservacion;

        public ViewHolder (View v) {
            super(v);
            tvEmpleado=v.findViewById(R.id.txtEmpleadoFicha);
            tvCliente=v.findViewById(R.id.txtClienteFicha);
            tvFecha=v.findViewById(R.id.txtFechaCadenaFicha);
            tvMotivoConsulta=v.findViewById(R.id.txtConsultaFicha);
            tvDiagnostico=v.findViewById(R.id.txtDiagnosticoFicha);
            tvObservacion=v.findViewById(R.id.txtObservacionFicha);
        }
    }

    public AdapterFicha(Ficha [] listaDeFichas, ItemClickListener itemClickListener) {
        this.dsFicha=listaDeFichas;
        this.mItemListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(Ficha ficha);
    }

}
