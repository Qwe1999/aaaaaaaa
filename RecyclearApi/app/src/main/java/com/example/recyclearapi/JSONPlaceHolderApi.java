package com.example.recyclearapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("users/by_username/")
    public Call<User> getPostWithUser(@Query("url") String user);

    @GET("articles")
    public Call<List<Articll>> getPostAll();
}