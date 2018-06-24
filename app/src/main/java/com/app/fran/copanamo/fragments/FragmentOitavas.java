package com.app.fran.copanamo.fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.adapters.OitavasRecyclerAdapter;
import com.app.fran.copanamo.entidades.FaseFinal;
import com.app.fran.copanamo.entidades.Grupo;
import com.app.fran.copanamo.entidades.JogoDoDia;
import com.app.fran.copanamo.service.RetrofitService;
import com.app.fran.copanamo.service.RetrofitServiceGenerator;
import com.app.fran.copanamo.utils.Preferencias;
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
    private Preferencias preferencias;
    AlertDialog alertDialog;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.oitavas_final_fragment, container, false);
        preferencias = new Preferencias(getActivity());


        //verifica se a tela de info não foi exibida, caso retorne false, a tela será exibida
        if(!preferencias.getStatusInfoFaseFinal()){
            View view = getLayoutInflater().inflate(R.layout.layout_info, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Deslize o dedo para esquerda para visualizar todas as fases finais");
            builder.setCancelable(false);
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    preferencias.salvaStatusInfoFinais(true);
                    alertDialog.dismiss();
                }
            });
            builder.setView(view);

            alertDialog = builder.create();
            alertDialog.show();
        }
        myRv = viewRoot.findViewById(R.id.myRv);
        myRv.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar  = viewRoot.findViewById(R.id.progress_oit);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);

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
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<List<FaseFinal>> call, Throwable t) {

            }
        });
    }

    }



