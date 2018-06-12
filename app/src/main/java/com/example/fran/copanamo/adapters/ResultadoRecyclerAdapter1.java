package com.example.fran.copanamo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fran.copanamo.R;
import com.example.fran.copanamo.entidades.Resultado;
import com.squareup.picasso.Picasso;

import java.net.InetAddress;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class ResultadoRecyclerAdapter1 extends RecyclerView.Adapter<ResultadoRecyclerAdapter1.ViewHolder> {
    List<Resultado> resultados;

    public ResultadoRecyclerAdapter1(List<Resultado> resultados){
        this.resultados = resultados;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img1_result;
        private ImageView img2_result;
        private ImageView img3_result;
        private ImageView img4_result;
        private TextView sel1_result;
        private TextView sel2_result;
        private TextView sel3_result;
        private TextView sel4_result;
        private TextView placar1;
        private TextView placar2;
        private TextView placar3;
        private TextView placar4;

        public ViewHolder(final View itemView) {
            super(itemView);

            img1_result  = itemView.findViewById(R.id.img1_result);
            img2_result = itemView.findViewById(R.id.img2_resul);
            img3_result =itemView.findViewById(R.id.img3_result);
            img4_result =itemView.findViewById(R.id.img4_result);
            sel1_result = itemView.findViewById(R.id.sel1_result);
            sel2_result = itemView.findViewById(R.id.sel2_result);
            sel3_result = itemView.findViewById(R.id.sel3_result);
            sel4_result = itemView.findViewById(R.id.sel4_result);
            placar1 = itemView.findViewById(R.id.placar1);
            placar2 = itemView.findViewById(R.id.placar2);
            placar3 = itemView.findViewById(R.id.placar3);
            placar4 = itemView.findViewById(R.id.placar4);

        }
    }


    @NonNull
    @Override
    public ResultadoRecyclerAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha_resultados_tabbed1, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoRecyclerAdapter1.ViewHolder holder, int position) {
            Resultado resultado = resultados.get(position);

        Picasso.with(holder.img1_result.getContext())
                .load(resultado.getImg_sel1())
                .into(holder.img1_result);

        Picasso.with(holder.img2_result.getContext())
                .load(resultado.getImg_sel2())
                .into(holder.img2_result);

        Picasso.with(holder.img3_result.getContext())
                .load(resultado.getImg_sel3())
                .into(holder.img3_result);

        Picasso.with(holder.img4_result.getContext())
                .load(resultado.getImg_sel4())
                .into(holder.img4_result);

        holder.sel1_result.setText(resultado.getNome_sel1());
        holder.sel2_result.setText(resultado.getNome_sel2());
        holder.sel3_result.setText(resultado.getNome_sel3());
        holder.sel4_result.setText(resultado.getNome_sel4());


        Calendar user = new GregorianCalendar(2018, Calendar.JUNE, 14);//informando a data

        Calendar now = new GregorianCalendar();

        if(now.before(user)){//retorna true se a data user for inferior a data atual

            holder.placar1.setText("Breve");
            holder.placar2.setText("Breve");
            holder.placar3.setText("Breve");
            holder.placar4.setText("Breve");
        }else{
            holder.placar1.setText(String.valueOf(resultado.getPlacar1()));
            holder.placar2.setText(String.valueOf(resultado.getPlacar2()));
            holder.placar3.setText(String.valueOf(resultado.getPlacar3()));
            holder.placar4.setText(String.valueOf(resultado.getPlacar4()));
        }


    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

}
