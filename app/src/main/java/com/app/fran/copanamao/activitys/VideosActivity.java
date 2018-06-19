package com.app.fran.copanamao.activitys;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app.fran.copanamao.R;
import com.app.fran.copanamao.adapters.RecyclerVideoAdapter;
import com.app.fran.copanamao.entidades.Video;
import com.app.fran.copanamao.service.RetrofitService;
import com.app.fran.copanamao.service.RetrofitServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class VideosActivity extends AppCompatActivity {

    Toolbar toolbar_videos;
    RecyclerView myRv_videos;
    List<Video> videos;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        videos = new ArrayList<>();
         recyclerView=( RecyclerView)findViewById(R.id.myRv_videos);
        //recyclerView.setHasFixedSize(true);
        //to use RecycleView, you need a layout manager. default is LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getVideos();

    }

    private void getVideos(){
        RetrofitService retrofitService = RetrofitServiceGenerator.createService(RetrofitService.class);
        Call<List<Video>> call = retrofitService.getVideosIds();

        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                if (response.isSuccessful()){
                    videos = response.body();
                    RecyclerVideoAdapter adapter=new RecyclerVideoAdapter(VideosActivity.this,videos);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {

            }
        });
    }


}
