package com.app.fran.copanamo.fragments;


import android.app.AlertDialog;
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

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.adapters.FinalRecyclerAdapter;
import com.app.fran.copanamo.adapters.OitavasRecyclerAdapter;
import com.app.fran.copanamo.entidades.FaseFinal;
import com.app.fran.copanamo.service.RetrofitService;
import com.app.fran.copanamo.service.RetrofitServiceGenerator;
import com.app.fran.copanamo.utils.Preferencias;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentFinal extends Fragment {
    View viewRoot;
    private RecyclerView myRv;
    private List<FaseFinal> finalList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.final_fragment, container, false);
        myRv = viewRoot.findViewById(R.id.myRv);
        myRv.setLayoutManager(new LinearLayoutManager(getContext()));

        finalList = new ArrayList<>();
        getFinal();

        return viewRoot;
    }

    private void getFinal(){
        RetrofitService service = RetrofitServiceGenerator.createService(RetrofitService.class);

        Call<List<FaseFinal>> call = service.getFinal();
        call.enqueue(new Callback<List<FaseFinal>>() {
            @Override
            public void onResponse(Call<List<FaseFinal>> call, Response<List<FaseFinal>> response) {
                if (response.isSuccessful()){

                    finalList = response.body();
                    FinalRecyclerAdapter adapter = new FinalRecyclerAdapter(finalList);
                    myRv.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<FaseFinal>> call, Throwable t) {

            }
        });
    }

    }



