package com.maho.upi.pamarray.Apis;

import com.maho.upi.pamarray.Model.ModelListData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

@SuppressWarnings("ALL")
public interface ApiInterface {

    @GET("bins/96w8c")
    Call<List<ModelListData>> ambildata();
}
