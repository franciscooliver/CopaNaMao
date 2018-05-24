package com.example.fran.copanamo.adapters;

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

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class GrupoRecyclerAdapter extends RecyclerView.Adapter<GrupoRecyclerAdapter.ViewHolder> {

    private final List<Integer> grupos;

    public GrupoRecyclerAdapter(final List<Integer> grupos) {
        this.grupos = grupos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(final View itemView) {
            super(itemView);

        }
    }

    @Override
    public GrupoRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha_grupo, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return grupos.size();
    }
}

