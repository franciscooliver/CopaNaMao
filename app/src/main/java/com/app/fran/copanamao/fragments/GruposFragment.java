package com.app.fran.copanamao.fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;


import com.app.fran.copanamao.R;
import com.app.fran.copanamao.adapters.GrupoRecyclerAdapter;
import com.app.fran.copanamao.entidades.Grupo;
import com.app.fran.copanamao.service.RetrofitService;
import com.app.fran.copanamao.service.RetrofitServiceGenerator;

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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_grupo, container, false);

         myRv = viewRoot.findViewById(R.id.myRv);
         myRv.setLayoutManager(new LinearLayoutManager(getContext()));
         progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Carregando grupos");
        progressDialog.setCancelable(true);
        progressDialog.show();

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
                     progressDialog.dismiss();
                }else{
                    progressDialog.dismiss();
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
                progressDialog.dismiss();
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
