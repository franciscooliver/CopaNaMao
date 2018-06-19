package com.app.fran.copanamao.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.fran.copanamao.R;
import com.app.fran.copanamao.adapters.OitavasRecyclerAdapter;
import com.app.fran.copanamao.entidades.FaseFinal;
import com.app.fran.copanamao.entidades.Grupo;
import com.app.fran.copanamao.entidades.JogoDoDia;
import com.app.fran.copanamao.service.RetrofitService;
import com.app.fran.copanamao.service.RetrofitServiceGenerator;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentOitavas extends Fragment {
    View viewRoot;
    private RecyclerView myRv;
    private List<FaseFinal> oitavas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.oitavas_final_fragment, container, false);
        myRv = viewRoot.findViewById(R.id.myRv);
        myRv.setLayoutManager(new LinearLayoutManager(getContext()));


        oitavas = new ArrayList<>();
        getOitavas();

        return viewRoot;
    }

    private void getOitavas(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);

        Call<List<FaseFinal>> call = service.getOitavas();
        call.enqueue(new Callback<List<FaseFinal>>() {
            @Override
            public void onResponse(Call<List<FaseFinal>> call, Response<List<FaseFinal>> response) {
                if (response.isSuccessful()){

                    oitavas = response.body();
                    OitavasRecyclerAdapter adapter = new OitavasRecyclerAdapter(oitavas);
                    myRv.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<FaseFinal>> call, Throwable t) {

            }
        });
    }

    }



