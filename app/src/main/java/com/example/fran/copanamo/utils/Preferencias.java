package com.example.fran.copanamo.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {

    private Context contexto;
    private SharedPreferences preferences;
    public final String NOME_ARQUIVO = "copa_na_mao.pref";
    public final int MODE = 0;
    private SharedPreferences.Editor editor;

    public static final String NOME_USER = "nome_user";

    public Preferencias( Context contextoParametro){

        contexto = contextoParametro;
        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, MODE );
        editor = preferences.edit();

    }

    public void salvaNomeUsuario(String nome){
        editor.putString(NOME_USER,nome);
        editor.commit();
    }

    public String recuperaNomeUsuario(){
        String nome = preferences.getString(NOME_USER,null);
        return nome;
    }

}
