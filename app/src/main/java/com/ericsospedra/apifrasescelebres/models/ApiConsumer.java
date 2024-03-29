package com.ericsospedra.apifrasescelebres.models;

import com.ericsospedra.apifrasescelebres.interfaces.IApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConsumer {
    private static IApiService instance;
    private static final String BASE_URL ="http://frases.germangascon.com/";

    private ApiConsumer() {
    }
    public synchronized static IApiService getInstance(){
        if(instance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = retrofit.create(IApiService.class);
        }
        return instance;
    }
}
