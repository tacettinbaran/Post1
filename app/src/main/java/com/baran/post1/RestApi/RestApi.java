package com.baran.post1.RestApi;

import com.baran.post1.Models.ResultModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {

    @FormUrlEncoded
    @POST("/sartliekle.php")
    Call<ResultModel> addUser(@Field("ad") String ad, @Field("soyad") String soyad);


}

