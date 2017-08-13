package com.salmanwahed.multipletypelistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Salman on 03-Aug-17.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<AdapterItem> mItems;
    private static final int TITLE_VIEW = 1234;
    private static final int ITEM_VIEW = 5678;


    public CustomAdapter(Context context, ArrayList<AdapterItem> items){
        mContext = context;
        mItems = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position).mType == TITLE_VIEW){
            return TITLE_VIEW;
        }
        return ITEM_VIEW;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TITLE_VIEW){
            View titleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_view, parent, false);
            holder = new TitleHolder(titleView);

        }else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_texview, parent, false);
            holder = new ItemHolder(itemView);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterItem item = mItems.get(position);
        if (holder instanceof ItemHolder){
            ((ItemHolder) holder).mTvItem.setText(item.mItem);
        }else if (holder instanceof TitleHolder){
            ((TitleHolder) holder).mTvTitle.setText(item.mItem);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    static class ItemHolder extends RecyclerView.ViewHolder{
        public TextView mTvItem;

        public ItemHolder(View itemView) {
            super(itemView);
            mTvItem = itemView.findViewById(R.id.tv_test_itm);

        }
    }

    static class TitleHolder extends RecyclerView.ViewHolder{
        public TextView mTvTitle;

        public TitleHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.textview_awesome_title);
        }
    }
}
