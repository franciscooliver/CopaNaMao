package com.app.fran.copanamao.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.fran.copanamao.R;
import com.app.fran.copanamao.entidades.JogoDoDia;
import com.app.fran.copanamao.entidades.Video;
import com.app.fran.copanamao.utils.Constantes;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerVideoAdapter extends RecyclerView.Adapter<RecyclerVideoAdapter.VideoInfoHolder>  {


   //these ids are the unique id for each video
    //String[] VideoID = {"P3mAtvs5Elc", "nCgQDjiotG0", "P3mAtvs5Elc"};
    Context ctx;
    List<Video> vds;
    Video[] videos;


    public RecyclerVideoAdapter(Context context,List<Video> videos) {
        this.ctx = context;
        this.vds = videos;

    }

    @Override
    public VideoInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_item, parent, false);
        return new VideoInfoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VideoInfoHolder holder, final int position) {

        Video video = vds.get(position);
        holder.progressBar.setVisibility(View.VISIBLE);
        holder.progressBar.setIndeterminate(true);

        Picasso.with(holder.playButton.getContext())
                .load("https://cdn.icon-icons.com/icons2/1094/PNG/128/playbutton_78507.png")
                .into(holder.playButton);


        holder.title_video.setText(video.getText());

        final YouTubeThumbnailLoader.OnThumbnailLoadedListener  onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.relativeLayoutOverYouTubeThumbnailView.setVisibility(View.VISIBLE);
                holder.progressBar.setVisibility(View.GONE);

            }
        };

        holder.youTubeThumbnailView.initialize(Constantes.YOUTUBE_API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(vds.get(position).getVideoId());
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
                youTubeThumbnailView.forceLayout();
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
            }
        });
    }

    @Override
    public int getItemCount() {
        return vds.size();
    }

    public class VideoInfoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        YouTubeThumbnailView youTubeThumbnailView;
        protected ImageView playButton;
        private TextView title_video;
        ProgressBar progressBar;

        public VideoInfoHolder(View itemView) {
            super(itemView);
            playButton=(ImageView)itemView.findViewById(R.id.btnYoutube_player);
            playButton.setOnClickListener(this);
            relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.youtube_thumbnail);
            title_video = itemView.findViewById(R.id.title_video);
            progressBar = itemView.findViewById(R.id.indeterminateBar);
        }

        @Override
        public void onClick(View v) {

            videos = new Video[vds.size()];
            int index = 0;
            for (Video video : vds){
                videos[index] = (Video) video;
                index++;
            }

            Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) ctx, Constantes.YOUTUBE_API_KEY, videos[getLayoutPosition()].getVideoId(),100, true, true);
            ctx.startActivity(intent);
        }
    }
}
