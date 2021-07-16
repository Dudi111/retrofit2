package com.example.retrofit2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private List<ResponseModel> responseModelList;

    public PostAdapter(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  PostViewHolder holder, int position) {
      ResponseModel responseModel=responseModelList.get(position);
      holder.setdata(responseModel);

    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}
