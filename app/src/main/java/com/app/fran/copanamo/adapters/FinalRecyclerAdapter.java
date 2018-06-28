package com.app.fran.copanamo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.entidades.FaseFinal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FinalRecyclerAdapter extends RecyclerView.Adapter<FinalRecyclerAdapter.ViewHolder> {

    private final List<FaseFinal> finalList;

    public FinalRecyclerAdapter(final List<FaseFinal> finalList) {
        this.finalList = finalList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       private TextView data,data2;
       private TextView horario,horario2;
       private ImageView img_sel1,img_sel2,img_sel1_3_lugar,img_sel2_3_lugar;
       private TextView nome_sel1,nome_sel2,nome_sel1_3_lugar,nome_sel2_3_lugar;
       private TextView placar1,placar2,placar1_3_lugar,placar2_3_lugar,campeao;

        public ViewHolder(final View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.data);
            horario = itemView.findViewById(R.id.horario);
            img_sel1 = itemView.findViewById(R.id.img_sel1_oitavas);
            img_sel2 = itemView.findViewById(R.id.img_sel2_oitavas);
            nome_sel1 = itemView.findViewById(R.id.nome_sel1);
            nome_sel2 = itemView.findViewById(R.id.nome_sel2);
            placar1 = itemView.findViewById(R.id.placar1);
            placar2 = itemView.findViewById(R.id.placar2);
            data2 = itemView.findViewById(R.id.data2);
            horario2 = itemView.findViewById(R.id.horario2);
            img_sel1_3_lugar = itemView.findViewById(R.id.img_sel1_3_lugar);
            img_sel2_3_lugar = itemView.findViewById(R.id.img_sel2_3_lugar);
            nome_sel1_3_lugar = itemView.findViewById(R.id.nome_sel1_3_lugar);
            nome_sel2_3_lugar = itemView.findViewById(R.id.nome_sel2_3_lugar);
            placar1_3_lugar = itemView.findViewById(R.id.placar1_3_lugar);
            placar2_3_lugar = itemView.findViewById(R.id.placar2_3_lugar);
            campeao = itemView.findViewById(R.id.campeao);

        }
    }

    @Override
    public FinalRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha_final, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(FinalRecyclerAdapter.ViewHolder linhaViewHolder , int position) {

        FaseFinal linha = finalList.get(0);
        FaseFinal linha3lugar = finalList.get(1);
        FaseFinal campeao = finalList.get(2);

        Picasso.with(linhaViewHolder.img_sel1.getContext())
                .load(linha.getUrl_sel1())
                .into(linhaViewHolder.img_sel1);

        Picasso.with(linhaViewHolder.img_sel2.getContext())
                .load(linha.getUrl_sel2())
                .into(linhaViewHolder.img_sel2);

        linhaViewHolder.data.setText(linha.getData()+",");
        linhaViewHolder.horario.setText(linha.getHorario());
        linhaViewHolder.nome_sel1.setText(linha.getNome_sel1());
        linhaViewHolder.nome_sel2.setText(linha.getNome_sel2());
        linhaViewHolder.placar1.setText(linha.getPlacar1());
        linhaViewHolder.placar2.setText(linha.getPlacar2());

        //dados 3 lugar
        Picasso.with(linhaViewHolder.img_sel1_3_lugar.getContext())
                .load(linha3lugar.getUrl_sel1())
                .into(linhaViewHolder.img_sel1_3_lugar);

        Picasso.with(linhaViewHolder.img_sel2_3_lugar.getContext())
                .load(linha3lugar.getUrl_sel2())
                .into(linhaViewHolder.img_sel2_3_lugar);

        linhaViewHolder.data2.setText(linha3lugar.getData()+",");
        linhaViewHolder.horario2.setText(linha3lugar.getHorario());
        linhaViewHolder.nome_sel1_3_lugar.setText(linha3lugar.getNome_sel1());
        linhaViewHolder.nome_sel2_3_lugar.setText(linha3lugar.getNome_sel2());
        linhaViewHolder.placar1_3_lugar.setText(linha3lugar.getPlacar1());
        linhaViewHolder.placar2_3_lugar.setText(linha3lugar.getPlacar2());

        linhaViewHolder.campeao.setText(campeao.getNome_sel1());


    }

    @Override
    public int getItemCount() {
        //para que a linha seja exibida apenas uma vez
        return 1;
    }
}

