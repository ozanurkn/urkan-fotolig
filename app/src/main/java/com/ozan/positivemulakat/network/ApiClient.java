package com.ozan.positivemulakat.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ozanurkan on 6.10.2017.
 */

public class ApiClient {

    public static final String BASE_URL = "http://www.posta.com.tr/api/LiveScore/"; //Analink yazilacak
    private static Retrofit retrofit = null;



    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
