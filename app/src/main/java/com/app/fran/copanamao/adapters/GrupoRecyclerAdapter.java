package com.app.fran.copanamao.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.app.fran.copanamao.R;
import com.app.fran.copanamao.entidades.Grupo;
import com.squareup.picasso.Picasso;


import java.util.List;


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
        TextView nome_grupo,p_russia,v_russia,e_russia,d_russia;
        TextView p_egito,v_egito,e_egito,d_egito;
        TextView p_arabia,v_arabia,e_arabia,d_arabia;
        TextView p_uru,v_uru,e_uru,d_uru;

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
            nome_grupo = itemView.findViewById(R.id.nome_grupo);
            p_russia = itemView.findViewById(R.id.p_russia);
            v_russia = itemView.findViewById(R.id.v_russia);
            e_russia = itemView.findViewById(R.id.e_russia);
            d_russia = itemView.findViewById(R.id.d_russia);

            p_arabia = itemView.findViewById(R.id.p_arabia);
            v_arabia = itemView.findViewById(R.id.v_arabia);
            e_arabia = itemView.findViewById(R.id.e_arabia);
            d_arabia = itemView.findViewById(R.id.d_arabia);

            p_egito = itemView.findViewById(R.id.p_egito);
            v_egito = itemView.findViewById(R.id.v_egito);
            e_egito = itemView.findViewById(R.id.e_egito);
            d_egito = itemView.findViewById(R.id.d_egito);

            p_uru = itemView.findViewById(R.id.p_uru);
            v_uru = itemView.findViewById(R.id.v_uru);
            e_uru = itemView.findViewById(R.id.e_uru);
            d_uru = itemView.findViewById(R.id.d_uru);

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

        Picasso.with(grupoViewHolder.imageRussia.getContext())
                .load(grupo.getCam_img1())
                .into(grupoViewHolder.imageRussia);

        Picasso.with(grupoViewHolder.imageArabia.getContext())
                .load(grupo.getCam_img2())
                .into(grupoViewHolder.imageArabia);

        Picasso.with(grupoViewHolder.imageEgito.getContext())
                .load(grupo.getCam_img3())
                .into(grupoViewHolder.imageEgito);

        Picasso.with(grupoViewHolder.imageUruguai.getContext())
                .load(grupo.getCam_img4())
                .into(grupoViewHolder.imageUruguai);

        grupoViewHolder.txtRussia.setText(grupo.getNome_selecao1());
        grupoViewHolder.txtArabia.setText(grupo.getNome_selecao2());
        grupoViewHolder.txtEgito.setText(grupo.getNome_selecao3());
        grupoViewHolder.txtUruguai.setText(grupo.getNome_selecao4());
        grupoViewHolder.nome_grupo.setText(grupo.getNome_grupo());

        grupoViewHolder.p_russia.setText(String.valueOf(grupo.getPontos_sel1()));
        grupoViewHolder.v_russia.setText(String.valueOf(grupo.getVitorias_sel1()));
        grupoViewHolder.e_russia.setText(String.valueOf(grupo.getEmpates_sel1()));
        grupoViewHolder.d_russia.setText(String.valueOf(grupo.getDerrotas_sel1()));

        grupoViewHolder.p_arabia.setText(String.valueOf(grupo.getPontos_sel2()));
        grupoViewHolder.v_arabia.setText(String.valueOf(grupo.getVitorias_sel2()));
        grupoViewHolder.e_arabia.setText(String.valueOf(grupo.getEmpates_sel2()));
        grupoViewHolder.d_arabia.setText(String.valueOf(grupo.getDerrotas_sel2()));

        grupoViewHolder.p_egito.setText(String.valueOf(grupo.getPontos_sel3()));
        grupoViewHolder.v_egito.setText(String.valueOf(grupo.getVitorias_sel3()));
        grupoViewHolder.e_egito.setText(String.valueOf(grupo.getEmpates_sel3()));
        grupoViewHolder.d_egito.setText(String.valueOf(grupo.getDerrotas_sel3()));

        grupoViewHolder.p_uru.setText(String.valueOf(grupo.getPontos_sel4()));
        grupoViewHolder.v_uru.setText(String.valueOf(grupo.getVitorias_sel4()));
        grupoViewHolder.e_uru.setText(String.valueOf(grupo.getEmpates_sel14()));
        grupoViewHolder.d_uru.setText(String.valueOf(grupo.getDerrotas_sel4()));
    }

    @Override
    public int getItemCount() {
        return grupos.size();
    }
}

