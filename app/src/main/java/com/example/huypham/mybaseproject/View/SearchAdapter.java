package com.example.huypham.mybaseproject.View;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.huypham.mybaseproject.Activity.Details;
import com.example.huypham.mybaseproject.Model.Places;
import com.example.huypham.mybaseproject.R;

import java.util.ArrayList;
import java.util.Locale;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>  {
    ArrayList<Places> arraylistPlace;
    ArrayList<Places> temp;

    Context mContext;

    public SearchAdapter(Context context, ArrayList<Places> list){
        this.mContext = context;
        this.arraylistPlace = list;
        temp = new ArrayList<>();
        for (Places place : list) {
            temp.add(place);
        }

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View itemView = layoutInflater.inflate(R.layout.card_view_item, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("MES","Vo duoc roi ne!");
        holder.textView.setText(arraylistPlace.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arraylistPlace.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.titleCard);
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("MES",""+getAdapterPosition());
                    Intent intent = new Intent(mContext,Details.class);
                    intent.putExtra("title",arraylistPlace.get(getAdapterPosition()).getName());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        arraylistPlace.clear();
        for(Places p : temp){
            Log.i("MES",p.getName());
        }
        if (charText.length() == 0) {
            arraylistPlace.addAll(temp);
        } else {

            for (Places p : temp) {
                if (p.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    arraylistPlace.add(p);
                    Log.i("MES","Vo nay roi ne!" + p.getName());
                }
            }
        }
        notifyDataSetChanged();
    }

}
