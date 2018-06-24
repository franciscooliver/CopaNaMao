package com.app.fran.copanamo.fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.app.fran.copanamo.R;
import com.app.fran.copanamo.adapters.GrupoRecyclerAdapter;
import com.app.fran.copanamo.entidades.Grupo;
import com.app.fran.copanamo.service.RetrofitService;
import com.app.fran.copanamo.service.RetrofitServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GruposFragment extends Fragment {
    private RecyclerView myRv;
    ProgressDialog progressDialog;
    List<Grupo> grupos;
    View viewRoot;
    AlertDialog alert;
    ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_grupo, container, false);

         myRv = viewRoot.findViewById(R.id.myRv);
         myRv.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar = viewRoot.findViewById(R.id.progress_grupos);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);



         grupos = new ArrayList<>();

         retornaDadosGrupos();
         return viewRoot;
    }



    private void retornaDadosGrupos(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);

        Call<List<Grupo>> call = service.getGrupos();
        call.enqueue(new Callback<List<Grupo>>() {
            @Override
            public void onResponse(Call<List<Grupo>> call, Response<List<Grupo>> response) {
                if (response.isSuccessful()){
                     grupos = response.body();
                     GrupoRecyclerAdapter adapter = new GrupoRecyclerAdapter(grupos);
                     myRv.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }else{
                    progressBar.setVisibility(View.GONE);
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Erro");
                    builder.setMessage("Houve um erro durante o carregamento\n" +
                            "dos grupos, tente novamente");
                    builder.setCancelable(false);
                    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           retornaDadosGrupos();
                        }
                    });
                    alert = builder.create();
                    alert.show();

                }
                
            }

            @Override
            public void onFailure(Call<List<Grupo>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Erro");
                builder.setMessage("Houve um erro durante o carregamento\n" +
                        "dos grupos, tente novamente");
                builder.setCancelable(true);
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alert.dismiss();
                        retornaDadosGrupos();
                    }
                });
                alert = builder.create();
                alert.show();
                Toast.makeText(getContext(), "Erro na requisição / "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
