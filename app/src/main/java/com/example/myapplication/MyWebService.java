package com.example.myapplication;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyWebService {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    String FEED = "posts";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //get list of posts
    @GET(FEED)
    Call<List<Customer>> getCustomer();



}
