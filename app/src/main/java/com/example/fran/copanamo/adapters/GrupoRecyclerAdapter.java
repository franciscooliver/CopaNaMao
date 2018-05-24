package com.example.fran.copanamo.adapters;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fran.copanamo.R;
import com.example.fran.copanamo.entidades.Grupo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GrupoRecyclerAdapter extends RecyclerView.Adapter<GrupoRecyclerAdapter.ViewHolder> {

    private final List<Grupo> grupos;

    public GrupoRecyclerAdapter(final List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageRussia;
        ImageView imageArabia;
        ImageView imageEgito;
        ImageView imageUruguai;
        TextView txtRussia;
        TextView txtArabia;
        TextView txtEgito;
        TextView txtUruguai;


        public ViewHolder(final View itemView) {
            super(itemView);

            imageRussia = itemView.findViewById(R.id.imgRussia);
            imageArabia = itemView.findViewById(R.id.imgArabia);
            imageEgito = itemView.findViewById(R.id.imgEgito);
            imageUruguai = itemView.findViewById(R.id.imgUruguai);

            txtRussia = itemView.findViewById(R.id.txtRussia);
            txtArabia = itemView.findViewById(R.id.txtarabia);
            txtEgito = itemView.findViewById(R.id.txtEgito);
            txtUruguai = itemView.findViewById(R.id.txtUruguai);

        }
    }

    @Override
    public GrupoRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha_grupo, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GrupoRecyclerAdapter.ViewHolder grupoViewHolder , int position) {

            Grupo grupo = grupos.get(position);

            grupoViewHolder.imageRussia.setImageDrawable(grupo.getBandeira1());
            grupoViewHolder.imageArabia.setImageDrawable(grupo.getBandeira2());
            grupoViewHolder.imageEgito.setImageDrawable(grupo.getBandeira3());
            grupoViewHolder.imageUruguai.setImageDrawable(grupo.getBandeira4());

            grupoViewHolder.txtRussia.setText(grupo.getTexview1());
            grupoViewHolder.txtArabia.setText(grupo.getTexview2());
            grupoViewHolder.txtEgito.setText(grupo.getTexview3());
            grupoViewHolder.txtUruguai.setText(grupo.getTexview4());

    }

    @Override
    public int getItemCount() {
        return grupos.size();
    }
}

