package com.app.fran.copanamo.service;

import com.app.fran.copanamo.entidades.Fase1Dados;
import com.app.fran.copanamo.entidades.Fase2Dados;
import com.app.fran.copanamo.entidades.Fase3Dados;
import com.app.fran.copanamo.entidades.Grupo;
import com.app.fran.copanamo.entidades.JogoDoDia;
import com.app.fran.copanamo.entidades.Noticia;
import com.app.fran.copanamo.entidades.Resultado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by handerson on 23/04/18.
 */

public interface RetrofitService {
    //headers é caso de api autenticada
    //@Headers("X-Mashape-Key: AuuyclCPjcmshv2iOPq190OpzLrMp1FJWwejsnJrdfwOUr4h44")

    @GET("grupos")
    Call<List<Grupo>> getGrupos();

    @GET("noticias")
    Call<List<Noticia>> getNoticias();

    @GET("dadosfases")
    Call<List<Fase1Dados>> getDadosFases();

    @GET("dadosfases2get")
    Call<List<Fase2Dados>> getDadosFases2();

    @GET("dadosfases3get")
    Call<List<Fase3Dados>> getDadosFases3();

    @GET("dadospartidasdiarias")
    Call<List<JogoDoDia>> getPartidasDoDia();

    @GET("placarfaseone")
    Call<List<Resultado>> getPlacarOne();

    @GET("placarfasetwo")
    Call<List<Resultado>> getPlacarTwo();

    @GET("placarfasetree")
    Call<List<Resultado>> getPlacarTree();

}
