package com.app.fran.copanamao.service;

import com.app.fran.copanamao.activitys.VideosActivity;
import com.app.fran.copanamao.entidades.Fase1Dados;
import com.app.fran.copanamao.entidades.Fase2Dados;
import com.app.fran.copanamao.entidades.Fase3Dados;
import com.app.fran.copanamao.entidades.FaseFinal;
import com.app.fran.copanamao.entidades.Grupo;
import com.app.fran.copanamao.entidades.JogoDoDia;
import com.app.fran.copanamao.entidades.Noticia;
import com.app.fran.copanamao.entidades.Resultado;
import com.app.fran.copanamao.entidades.Video;

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

    @GET("fasefinaloitavas")
    Call<List<FaseFinal>> getOitavas();

    @GET("videos")
    Call<List<Video>> getVideosIds();



}
