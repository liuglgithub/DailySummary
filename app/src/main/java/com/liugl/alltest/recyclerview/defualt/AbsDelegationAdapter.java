package com.liugl.alltest.recyclerview.defualt;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liugl on 2018/7/6.
 */

public abstract class AbsDelegationAdapter<VH extends RecyclerView.ViewHolder> extends   RecyclerView.Adapter<VH>{

    protected AdapterDelegatesManager<VH> delegatesManager;

    private List<Object> mDataItems = new ArrayList<>();


    public AbsDelegationAdapter(AdapterDelegatesManager delegatesManager){
        this.delegatesManager = delegatesManager;
    }

    public void addDelegate(AdapterDelegate delegate){
        addDelegate(delegate);
    }

    public void setDataItems(List dataItems){
        mDataItems = dataItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
//        return delegatesManager.get;
        return 1;
    }
}
