package com.example.siva1.bunky;

import retrofit.client.Response;
import retrofit.http.FormUrlEncoded;
import retrofit.Callback;

import retrofit.http.Field;
import retrofit.http.POST;

/**
 * Created by siva1 on 18/04/2017.
 */
public interface Call {
    @FormUrlEncoded
    @POST("/Bunky")
      void getLogin(@Field("roll")String user,@Field("pass")String pass,Callback<Response>res);

}




