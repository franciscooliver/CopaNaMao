package com.app.fran.copanamao.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.app.fran.copanamao.R;
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

public class MainFragment extends Fragment {
    private static final String KEY_API_ADMOB ="ca-app-pub-7136462619743657~9311752194";
    private AdView mAdView;
    private ImageView sel1,sel2;
    private TextView txt_sel1,txt_sel2,hora;
    private TextView txtinfo;
    View viewRoot;
    CarouselView carouselView;
    List<JogoDoDia> partidas;
    ProgressDialog progressDialog;
    JogoDoDia[] array;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_main, container, false);

        //carrega view carousel
        carouselView = viewRoot.findViewById(R.id.carouselView);
        txtinfo = viewRoot.findViewById(R.id.txt_info);
        MobileAds.initialize(getContext(),KEY_API_ADMOB);

        mAdView = viewRoot.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        partidas = new ArrayList<>();
        getPartidaDiaria();


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Carregando tela");
        progressDialog.setCancelable(false);
        progressDialog.show();

        carouselView.setSlideInterval(5000);
        carouselView.setViewListener(viewListener);


        return viewRoot;
    }

    private void getPartidaDiaria(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);

        Call<List<JogoDoDia>> call = service.getPartidasDoDia();

        call.enqueue(new Callback<List<JogoDoDia>>() {
            @Override
            public void onResponse(Call<List<JogoDoDia>> call, Response<List<JogoDoDia>> response) {
                if (response.isSuccessful()){

                    partidas = response.body();
                    array = new JogoDoDia[partidas.size()];
                    int index = 0;
                    for (JogoDoDia jogoDoDia : partidas){
                        array[index] = (JogoDoDia) jogoDoDia;
                        index++;
                    }

                    if(array.length <= 0)
                    {
                        txtinfo.setVisibility(viewRoot.VISIBLE);
                        progressDialog.dismiss();
                    }else {
                        txtinfo.setVisibility(viewRoot.GONE);
                        //seta quantidade de paginas
                        carouselView.setPageCount(array.length);
                        progressDialog.dismiss();
                    }




                }else {

                    Toast.makeText(getContext(), "Retonou vazio", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<JogoDoDia>> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });


    }


    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(R.layout.custom_view, null);

            sel1 = customView.findViewById(R.id.sel1_result);
            sel2 = customView.findViewById(R.id.sel2_result);
            txt_sel1 = customView.findViewById(R.id.txt_sel1);
            txt_sel2 = customView.findViewById(R.id.txt_sel2);
            hora = customView.findViewById(R.id.hora);


                Picasso.with(getContext()).load(array[position].getUrl_img1()).into(sel1);
                Picasso.with(getContext()).load(array[position].getUrl_img2()).into(sel2);
                //labelTextView.setText(titulos[position]);

                txt_sel1.setText(array[position].getText1());
                txt_sel2.setText(partidas.get(position).getText2());
                hora.setText(array[position].getHora_partida());

                carouselView.setIndicatorGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);

            return customView;
        }
    };


    }



