package com.app.fran.copanamo.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.adapters.RecyclerVideoAdapter;
import com.app.fran.copanamo.entidades.Video;
import com.app.fran.copanamo.service.RetrofitService;
import com.app.fran.copanamo.service.RetrofitServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosFragment extends Fragment {
    RecyclerView rvVideos;
    List<Video> videos;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.videos_fragment, container, false);


        videos = new ArrayList<>();
        rvVideos = view.findViewById(R.id.myRv_videos);
        rvVideos.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar = view.findViewById(R.id.progressBarVideos);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);

        getVideos();
        return  view;
    }

    private void getVideos(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);
        Call<List<Video>> call = service.getVideosIds();

        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                if(response.isSuccessful()){
                    videos = response.body();
                    RecyclerVideoAdapter adapter = new RecyclerVideoAdapter(getContext(),videos);
                    rvVideos.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {

            }
        });
    }
}
