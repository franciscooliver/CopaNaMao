package com.example.fran.copanamo.fragments;

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

import java.util.ArrayList;
import java.util.List;

public class GruposFragment extends Fragment {
    private RecyclerView myRv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View viewRoot = inflater.inflate(R.layout.fragment_grupo, container, false);

         myRv = viewRoot.findViewById(R.id.myRv);
         myRv.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Integer> grupos = new ArrayList<>();
        grupos.add(0,R.string.txt1);
        grupos.add(1,R.string.txt2);
        grupos.add(2,R.string.txt3);
        grupos.add(3,R.string.txt4);

        GrupoRecyclerAdapter adapter = new GrupoRecyclerAdapter(grupos);
        myRv.setAdapter(adapter);


        return viewRoot;
    }
}
