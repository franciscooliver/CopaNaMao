package com.example.fran.copanamo.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.fran.copanamo.R;
import com.example.fran.copanamo.adapters.GrupoRecyclerAdapter;
import com.example.fran.copanamo.entidades.Grupo;

import java.util.ArrayList;
import java.util.List;

public class GruposFragment extends Fragment {
    private RecyclerView myRv;
    Grupo grupo;
    Grupo grupo2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View viewRoot = inflater.inflate(R.layout.fragment_grupo, container, false);

         myRv = viewRoot.findViewById(R.id.myRv);
         myRv.setLayoutManager(new LinearLayoutManager(getContext()));


        grupo = new Grupo();
        List<Grupo> grupos = new ArrayList<>();
        grupo.setBandeira1(getResources().getDrawable(R.drawable.russia));
        grupo.setBandeira2(getResources().getDrawable(R.drawable.arabia_saudita));
        grupo.setBandeira3(getResources().getDrawable(R.drawable.egito));
        grupo.setBandeira4(getResources().getDrawable(R.drawable.uruguai));
        grupo.setTexview1(getResources().getString(R.string.txt1));
        grupo.setTexview2(getResources().getString(R.string.txt2));
        grupo.setTexview3(getResources().getString(R.string.txt3));
        grupo.setTexview4(getResources().getString(R.string.txt4));

        grupos.add(grupo);

        grupo2 = new Grupo();
        grupo2.setBandeira1(getResources().getDrawable(R.drawable.portugal));
        grupo2.setBandeira2(getResources().getDrawable(R.drawable.espanha));
        grupo2.setBandeira3(getResources().getDrawable(R.drawable.marrocos));
        grupo2.setBandeira4(getResources().getDrawable(R.drawable.ira));
        grupo2.setTexview1(getResources().getString(R.string.txt5));
        grupo2.setTexview2(getResources().getString(R.string.txt6));
        grupo2.setTexview3(getResources().getString(R.string.txt7));
        grupo2.setTexview4(getResources().getString(R.string.txt8));

        grupos.add(grupo2);

        GrupoRecyclerAdapter adapter = new GrupoRecyclerAdapter(grupos);
        myRv.setAdapter(adapter);


        return viewRoot;
    }
}
