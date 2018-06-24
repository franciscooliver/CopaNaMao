package com.app.fran.copanamo.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.entidades.Noticia;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;


public class NoticiaRecyclerAdapter extends RecyclerView.Adapter<NoticiaRecyclerAdapter.ViewHolder> {

    private List<Noticia> noticias;
    private Context context;
    private MediaPlayer mediaPlayer;
    String video_url;

    public NoticiaRecyclerAdapter(List<Noticia> noticias, Context context){
        this.noticias = noticias;
        this.context =context;
        mediaPlayer = new MediaPlayer();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_noticia;
        private TextView title;
        private TextView supporting_text;
        private ImageButton btn_expandable;
        private Button btn_share;
        private VideoView videoView;

        public ViewHolder(final View itemView) {
            super(itemView);
            img_noticia = itemView.findViewById(R.id.media_image);
            title = itemView.findViewById(R.id.titulo_noticia);
            supporting_text = itemView.findViewById(R.id.supporting_text);
            btn_expandable = itemView.findViewById(R.id.expand_button);
            btn_share = itemView.findViewById(R.id.btn_share);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha_noticia, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final NoticiaRecyclerAdapter.ViewHolder noticiaViewHolder, int position) {
        Noticia noticia  = noticias.get(position);
        noticiaViewHolder.title.setText(noticia.getTitulo_noticia());
        noticiaViewHolder.supporting_text.setText(noticia.getConteudo_noticia());
        //noticiaViewHolder.videoView.setVisibility(View.GONE);

        Picasso.with(noticiaViewHolder.img_noticia.getContext())
                .load(noticia.getUrl_img())
                .into(noticiaViewHolder.img_noticia);

        noticiaViewHolder.btn_expandable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noticiaViewHolder.supporting_text.getVisibility() == View.VISIBLE){
                    noticiaViewHolder.btn_expandable.setImageResource(R.drawable.ic_expand_less_black_36dp);
                    noticiaViewHolder.supporting_text.setVisibility(View.GONE);
                }else{
                    noticiaViewHolder.btn_expandable.setImageResource(R.drawable.ic_expand_more_black_36dp);
                    noticiaViewHolder.supporting_text.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}
