package com.example.retrofit2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView tvname;
    private TextView tvemail;
    private  TextView tvbody;

    public PostViewHolder(@NonNull  View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View itemView){
        tvname=itemView.findViewById(R.id.tvName);
        tvemail=itemView.findViewById(R.id.tvEmail);
        tvbody=itemView.findViewById(R.id.tvBody);
    }
    public void setdata(ResponseModel responseModel){
      tvname.setText(responseModel.getName());
      tvbody.setText(responseModel.getBody());
      tvemail.setText(responseModel.getEmail());

    }
}
