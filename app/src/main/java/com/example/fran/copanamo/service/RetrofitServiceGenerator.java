package com.example.fran.copanamo.service;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fran_oliver on 27/05/2018
 */

public class RetrofitServiceGenerator {
    //URL base do endpoint. Deve sempre terminar com /
    //public static final String API_BASE_URL ="http://jhsdev.com/index.php/api/";
    public static final String API_BASE_URL ="http://35.196.177.226/index.php/api/";
    public static <S> S createService( Class<S> serviceClass) {

        //Instancia do interceptador das requisições

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS);

        httpClient.addInterceptor(loggingInterceptor);

        //Instância do retrofit

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient.build())
                .build();

        return retrofit.create(serviceClass);
    }
}