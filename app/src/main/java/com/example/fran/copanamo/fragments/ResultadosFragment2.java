package com.example.fran.copanamo.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fran.copanamo.MainActivity;
import com.example.fran.copanamo.R;
import com.example.fran.copanamo.adapters.PartidaRecyclerAdapter2;
import com.example.fran.copanamo.adapters.ResultadoRecyclerAdapter2;
import com.example.fran.copanamo.entidades.Fase2Dados;
import com.example.fran.copanamo.entidades.Resultado;
import com.example.fran.copanamo.service.RetrofitService;
import com.example.fran.copanamo.service.RetrofitServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultadosFragment2 extends Fragment {
    View viewRoot;
    List<Resultado> resultados2;
    private RecyclerView recycler_fragment2;
    private int cont;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot =  inflater.inflate(R.layout.fragment_resultados_tabbed2, container, false);

        resultados2 = new ArrayList<>();
        recycler_fragment2 = viewRoot.findViewById(R.id.rv_result2);
        recycler_fragment2.setLayoutManager(new LinearLayoutManager(getActivity()));

        retornaPlacarFase2();
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.show();


        return viewRoot;
    }

    private void retornaPlacarFase2(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);

        //chamada do metodo que retorna os placares da fase 2 de jogos
        Call<List<Resultado>> call = service.getPlacarTwo();

        call.enqueue(new Callback<List<Resultado>>() {
            @Override
            public void onResponse(Call<List<Resultado>> call, Response<List<Resultado>> response) {
                if(response.isSuccessful()){
                    resultados2 = response.body();

                    ResultadoRecyclerAdapter2 adapter = new ResultadoRecyclerAdapter2(resultados2);
                    recycler_fragment2.setAdapter(adapter);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<Resultado>> call, Throwable t) {

            }
        });


    }

}
