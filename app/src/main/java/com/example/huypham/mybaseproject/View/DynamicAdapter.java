package com.example.huypham.mybaseproject.View;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
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

public class DynamicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int HEADER_TYPE = 0;
    private static final int FOOTER_TYPE = 2;
    private Context mContext;
    ArrayList<Places> list;
    boolean isEnableHeader;
    boolean isEnableFooter;


    public DynamicAdapter(ArrayList<Places> list, Context context){
        this.list = list;
        this.mContext = context;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         if(holder instanceof Viewholder){
             ((Viewholder) holder).titleView.setText(list.get(getRealPosition(position)).getName());
         }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_TYPE;
        }
        if (position == (getItemCount() - 1))
            return FOOTER_TYPE;
        return -1;
    }

    @Override
    public int getItemCount() {
        return list.size() + forHeaderFooter();
    }

    public int getRealPosition(int pos) {
        if(isEnableHeader) return pos -1;
        return pos;
    }

    public int forHeaderFooter(){
        int extraViewSize = 0;
        if (isEnableHeader)
            extraViewSize++;
        if (isEnableFooter)
            extraViewSize++;
        return extraViewSize;
    }

    public void setEnableHeader(boolean isEnableHeader) {
        this.isEnableHeader = isEnableHeader;
    }

    public void setEnableFooter(boolean enableFooter) {
        isEnableFooter = enableFooter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER_TYPE) {
            // TODO: inflate header
            // R.layout.item_header;
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false);
            return  new HeaderFooterViewHolder(itemView);
        }
        if(viewType == FOOTER_TYPE) {
            // R.layout.item_footer;
            // return
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer,parent,false);
            return  new HeaderFooterViewHolder(itemView);
        }

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, parent, false);
        return new Viewholder(itemView);
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        TextView titleView;
        public Viewholder(final View itemView) {
            super(itemView);

            titleView = itemView.findViewById(R.id.titleCard);

            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("MES",""+getAdapterPosition());
                    Intent intent = new Intent(mContext,Details.class);
                    intent.putExtra("title",list.get(getRealPosition(getAdapterPosition())).getName());
                    mContext.startActivity(intent);
                }
            });

        }
    }
    public class HeaderFooterViewHolder extends RecyclerView.ViewHolder {
        public HeaderFooterViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
