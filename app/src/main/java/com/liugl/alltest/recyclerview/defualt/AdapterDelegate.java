package com.liugl.alltest.recyclerview.defualt;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by liugl on 2018/7/6.
 */

public abstract class AdapterDelegate<T,VH extends RecyclerView.ViewHolder> {
    public AdapterDelegate(){

    }

    protected boolean isForViewType(T item,int position){
        return true;
    }

    protected abstract VH onCreateViewHolder(ViewGroup parent);

    protected abstract void onBindViewHolder(VH holder,int position,T item);

}
