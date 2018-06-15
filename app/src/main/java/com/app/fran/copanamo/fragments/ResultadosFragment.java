package com.app.fran.copanamo.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.os.ResultReceiver;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.fran.copanamo.ActivityResultadosTabbed;
import com.app.fran.copanamo.MainActivity;
import com.app.fran.copanamo.R;
import com.app.fran.copanamo.adapters.ResultadoRecyclerAdapter1;
import com.app.fran.copanamo.entidades.Resultado;
import com.app.fran.copanamo.service.RetrofitService;
import com.app.fran.copanamo.service.RetrofitServiceGenerator;
import com.app.fran.copanamo.utils.TimeService;


import java.lang.ref.WeakReference;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultadosFragment extends Fragment {
    private View viewRoot;
    private RecyclerView recyclerViewResult1;
    private List<Resultado> resultados;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot =  inflater.inflate(R.layout.fragment_resultados_tabbed1, container, false);
        recyclerViewResult1 = viewRoot.findViewById(R.id.rv_result);
        recyclerViewResult1.setLayoutManager(new LinearLayoutManager(getContext()));


        resultados = new ArrayList<>();

        getResultadosJogos();

        return viewRoot;
    }

    private void getResultadosJogos(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);

        Call<List<Resultado>> call = service.getPlacarOne();
        call.enqueue(new Callback<List<Resultado>>() {
            @Override
            public void onResponse(Call<List<Resultado>> call, Response<List<Resultado>> response) {
                if(response.isSuccessful()){
                    resultados = response.body();

                    ResultadoRecyclerAdapter1 adapter = new ResultadoRecyclerAdapter1(resultados);
                    recyclerViewResult1.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Resultado>> call, Throwable t) {

            }
        });
    }


}
