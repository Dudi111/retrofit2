package com.example.retrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etpostid;
    private Button mbtnfetch;
    private RecyclerView recycle;
    private List<ResponseModel> responseModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initi();
    }

    private void initi() {
        etpostid=findViewById(R.id.etPostId);
        mbtnfetch=findViewById(R.id.btnFetch);
        recycle=findViewById(R.id.recyclerView);
        mbtnfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallApi();
            }
        });
    }

    private void CallApi() {
     ApiService apiService=Network.getInstance().create(ApiService.class);
     int postId= Integer.parseInt(etpostid.getText().toString());
     apiService.getposts(postId).enqueue(new Callback<List<ResponseModel>>() {
         @Override
         public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
             if(response.body()!=null){
                 responseModelList=response.body();
                 setRecyclerView();
             }
         }

         @Override
         public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

         }
     });
    }

    private void setRecyclerView() {
        PostAdapter postAdapter=new PostAdapter(responseModelList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycle.setLayoutManager(linearLayoutManager);
        recycle.setAdapter(postAdapter);
    }

}