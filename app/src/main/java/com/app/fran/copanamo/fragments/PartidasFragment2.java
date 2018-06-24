package com.app.fran.copanamo.fragments;

import android.app.AlertDialog;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.fran.copanamo.activitys.MainActivity;
import com.app.fran.copanamo.R;
import com.app.fran.copanamo.adapters.PartidaRecyclerAdapter2;
import com.app.fran.copanamo.entidades.Fase2Dados;
import com.app.fran.copanamo.service.RetrofitService;
import com.app.fran.copanamo.service.RetrofitServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartidasFragment2 extends Fragment {
    View viewRoot;
    List<Fase2Dados> partidas2;
    private RecyclerView recycler_fragment2;
    private int cont;
    private AlertDialog alert;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot =  inflater.inflate(R.layout.fragment_partidas_tabbed2, container, false);

        partidas2 = new ArrayList<>();
        recycler_fragment2 = viewRoot.findViewById(R.id.rv_frag2);
        recycler_fragment2.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar = viewRoot.findViewById(R.id.pb_partidas2);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);

        retornaDadosFase2();

        return viewRoot;
    }

    private void retornaDadosFase2(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);

        Call<List<Fase2Dados>> call = service.getDadosFases2();

        call.enqueue(new Callback<List<Fase2Dados>>() {
            @Override
            public void onResponse(Call<List<Fase2Dados>> call, Response<List<Fase2Dados>> response) {
                if (response.isSuccessful()){
                    partidas2 = response.body();
                    PartidaRecyclerAdapter2 partidaRecyclerAdapter2 = new PartidaRecyclerAdapter2(partidas2);
                    recycler_fragment2.setAdapter(partidaRecyclerAdapter2);
                    progressBar.setVisibility(View.GONE);
                }else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Erro no carregamento\n"+
                            "Toque em ok para recarregar");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            retornaDadosFase2();
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
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Fase2Dados>> call, Throwable t) {
                Toast.makeText(getContext(), "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
