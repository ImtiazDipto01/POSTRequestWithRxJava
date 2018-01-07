package com.example.dipto.postrequestwithrxjava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sakib on 1/7/2018.
 */

public class RetrofitClient {

    public static final String BASE_URL = "http://sadikulsathi.com/" ;

    public static Retrofit retrofit = null ;

    public static Retrofit getRetrofitClient(){

        if(retrofit == null){

            //creating Gson object
            Gson gson = new GsonBuilder().setLenient().create();

            //creating OkHttp object
            OkHttpClient okHttpClient = new OkHttpClient() ;

            //creating Retrofit object following Singleton pattern
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit ;
    }
}
