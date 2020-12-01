package com.baran.post1.RestApi;

import com.baran.post1.Models.ResultModel;
import retrofit2.Call;


public class ManagerAll extends BaseManager {


    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<ResultModel> addUser(String ad, String soyad){
        Call<ResultModel> call = getRestApiClient().addUser(ad,soyad);
        return call;
    }



}
