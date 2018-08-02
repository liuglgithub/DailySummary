package com.liugl.alltest.recyclerview.defualt;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by liugl on 2018/7/6.
 */

public class AdapterDelegatesManager<VH extends RecyclerView.ViewHolder> {

    private SparseArrayCompat<AdapterDelegate<Object, VH>> delegates = new SparseArrayCompat<>();
    private SparseArray<String> dataTypeWithTags = new SparseArray<>();


    public AdapterDelegatesManager addDelegate(AdapterDelegate<Object,VH> delegate,String tag){
        Type superclass = delegate.getClass().getGenericSuperclass();
        Class<?> clazz = (Class<?>) ((ParameterizedType) superclass).getActualTypeArguments()[0];
        String typeWithTag = getTypeWithTag(clazz,tag);
        int viewTypeIndex = delegates.size();
        delegates.put(viewTypeIndex,delegate);
        dataTypeWithTags.put(viewTypeIndex,typeWithTag);

        return this;
    }

    private String getTypeWithTag(Class clazz, String tag) {
        if (tag.length() == 0) {
            return clazz.getName();
        } else {
            return clazz.getName() + ":" + tag;
        }
    }

}
