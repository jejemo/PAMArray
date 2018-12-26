package com.maho.upi.pamarray.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.maho.upi.pamarray.Adapter.RecyclerListDataAdapter;
import com.maho.upi.pamarray.Apis.ApiInterface;
import com.maho.upi.pamarray.Apis.ApiService;
import com.maho.upi.pamarray.Model.ModelListData;
import com.maho.upi.pamarray.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    private ShimmerFrameLayout mShimmerViewContainer;
    List<ModelListData> modelListData;
    RecyclerView recyclerView;
    RecyclerListDataAdapter recyclerListDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelListData = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.RecyclerList);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerListDataAdapter = new RecyclerListDataAdapter(getApplicationContext(),modelListData);
        recyclerView.setAdapter(recyclerListDataAdapter);
        
        
        getAPI();
    }

    private void getAPI() {
        ApiInterface apiInterface = ApiService.getDataPemain().create(ApiInterface.class);
        Call<List<ModelListData>> call = apiInterface.ambildata();

        call.enqueue(new Callback<List<ModelListData>>() {
            @Override
            public void onResponse(Call<List<ModelListData>> call, Response<List<ModelListData>> response) {
                if(response.isSuccessful()){
                    if (response.code() == 200){
                        modelListData = response.body();
                        Log.d("","" + modelListData);
                        recyclerListDataAdapter.setModelListData(modelListData);
                    }
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<List<ModelListData>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }
}
