package com.app.fran.copanamo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.entidades.Fase2Dados;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PartidaRecyclerAdapter2 extends RecyclerView.Adapter<PartidaRecyclerAdapter2.ViewHolder> {
    List<Fase2Dados> dados_fase2;

    public PartidaRecyclerAdapter2(List<Fase2Dados> dados_fase2){
        this.dados_fase2 = dados_fase2;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_sel1;
        private ImageView img_sel2;
        private ImageView img_sel3;
        private ImageView img_sel4;
        private TextView nome_sel1;
        private TextView nome_sel2;
        private TextView nome_sel3;
        private TextView nome_sel4;
        private TextView data_partida_1;
        private TextView data_partida_2;
        private TextView hora_part1;
        private TextView hora_partisa2;
        private TextView placar1,placar2,placar3,placar4;

        public ViewHolder(final View itemView) {
            super(itemView);

            img_sel1  = itemView.findViewById(R.id.img1_result);
            img_sel2 = itemView.findViewById(R.id.img2_resul);
            img_sel3 =itemView.findViewById(R.id.img3_result);
            img_sel4 =itemView.findViewById(R.id.img4_result);
            nome_sel1 = itemView.findViewById(R.id.sel1_result);
            nome_sel2 = itemView.findViewById(R.id.sel2_result);
            nome_sel3 = itemView.findViewById(R.id.sel3_result);
            nome_sel4 = itemView.findViewById(R.id.sel4_result);
            data_partida_1 = itemView.findViewById(R.id.data1);
            data_partida_2 = itemView.findViewById(R.id.data2);
            hora_part1 = itemView.findViewById(R.id.hora1);
            hora_partisa2 = itemView.findViewById(R.id.hora2);
            placar1  =itemView.findViewById(R.id.placar1);
            placar2  =itemView.findViewById(R.id.placar2);
            placar3  =itemView.findViewById(R.id.placar3);
            placar4  =itemView.findViewById(R.id.placar4);

        }
    }


    @NonNull
    @Override
    public PartidaRecyclerAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha_adapter_partidas_tabbed2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidaRecyclerAdapter2.ViewHolder holder, int position) {
            Fase2Dados partida = dados_fase2.get(position);

        Picasso.with(holder.img_sel1.getContext())
                .load(partida.getImg_sel1())
                .into(holder.img_sel1);

        Picasso.with(holder.img_sel2.getContext())
                .load(partida.getImg_sel3())
                .into(holder.img_sel2);

        Picasso.with(holder.img_sel3.getContext())
                .load(partida.getImg_sel2())
                .into(holder.img_sel3);

        Picasso.with(holder.img_sel4.getContext())
                .load(partida.getImg_sel4())
                .into(holder.img_sel4);

        holder.nome_sel1.setText(partida.getNome_sel1());
        holder.nome_sel2.setText(partida.getNome_sel3());
        holder.nome_sel3.setText(partida.getNome_sel2());
        holder.nome_sel4.setText(partida.getNome_sel4());

        holder.data_partida_1.setText(partida.getData_partida1());
        holder.data_partida_2.setText(partida.getData_partida2());
        holder.hora_part1.setText(partida.getHorario_partida1());
        holder.hora_partisa2.setText(partida.getHorario_partida2());

        holder.placar1.setText(partida.getPlacar1());
        holder.placar2.setText(partida.getPlacar2());
        holder.placar3.setText(partida.getPlacar3());
        holder.placar4.setText(partida.getPlacar4());

    }

    @Override
    public int getItemCount() {
        return dados_fase2.size();
    }

}
