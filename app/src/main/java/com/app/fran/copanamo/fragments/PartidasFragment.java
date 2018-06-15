package com.app.fran.copanamo.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.fran.copanamo.MainActivity;
import com.app.fran.copanamo.R;
import com.app.fran.copanamo.adapters.PartidaRecyclerAdapter1;
import com.app.fran.copanamo.entidades.Fase1Dados;
import com.app.fran.copanamo.entidades.Grupo;
import com.app.fran.copanamo.service.RetrofitService;
import com.app.fran.copanamo.service.RetrofitServiceGenerator;
import com.app.fran.copanamo.utils.Preferencias;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartidasFragment extends Fragment {
    Preferencias pref;
    View viewRoot;
    List<Fase1Dados> partidas;
    private RecyclerView recycler_fragment1;
    int cont = 0;

    AlertDialog alertDialog;
    boolean viewInfo;
    ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_partidas_tabbed1, container, false);
        partidas = new ArrayList<>();
        recycler_fragment1 = viewRoot.findViewById(R.id.rv_frag1);
        recycler_fragment1.setLayoutManager(new LinearLayoutManager(getActivity()));
        pref = new Preferencias(getContext());

        if(!pref.getStatusInfo()){
            View view = getLayoutInflater().inflate(R.layout.layout_info, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Deslize o dedo para esquerda para ver todas as telas");
            builder.setCancelable(false);
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    pref.salvaStatusInfo(true);
                    alertDialog.dismiss();
                }
            });
            builder.setView(view);

            alertDialog = builder.create();
            alertDialog.show();
        }

        returnData();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.show();

        return viewRoot;
    }


    private void returnData(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);

        Call<List<Fase1Dados>> call = service.getDadosFases();

        call.enqueue(new Callback<List<Fase1Dados>>() {
            @Override
            public void onResponse(Call<List<Fase1Dados>> call, Response<List<Fase1Dados>> response) {
                if(response.isSuccessful()){
                    partidas = response.body();

                    PartidaRecyclerAdapter1 adapter1 = new PartidaRecyclerAdapter1(partidas);
                    recycler_fragment1.setAdapter(adapter1);

                    progressDialog.dismiss();
                    adapter1.notifyDataSetChanged();

                }else{
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Erro no carregamento\n"+
                            "Toque em ok para recarregar");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            returnData();
                            cont+=1;
                            Toast.makeText(getContext(), "Cont"+cont, Toast.LENGTH_SHORT).show();
                            if(cont >= 3){

                                Intent intent = new Intent(getContext(), MainActivity.class);
                                startActivity( intent );

                            }
                        }
                    });
                    builder.setCancelable(false);
                    builder.show();

                }
            }

            @Override
            public void onFailure(Call<List<Fase1Dados>> call, Throwable t) {
                Toast.makeText(getContext(), "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();

                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Erro no carregamento\n"+
                        "Toque em ok para recarregar");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        returnData();
                        cont+=1;
                        Toast.makeText(getContext(), "Cont"+cont, Toast.LENGTH_SHORT).show();
                        if(cont >= 3){

                            Intent intent = new Intent(getContext(), MainActivity.class);
                            startActivity( intent );

                        }
                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });
    }


}
