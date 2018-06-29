package com.liugl.alltest.nestedscroll.coordinatorlayout.csdn.adapter;

import android.content.Context;
import android.widget.TextView;

import com.liugl.alltest.R;
import com.liugl.alltest.nestedscroll.coordinatorlayout.csdn.recyclerview.BaseRecyclerAdapter;
import com.liugl.alltest.nestedscroll.coordinatorlayout.csdn.recyclerview.BaseRecyclerHolder;

import java.util.List;

/**
 * @ explain:
 * @ author：xujun on 2016/10/18 16:42
 * @ email：gdutxiaoxu@163.com
 */
public class ItemAdapter extends BaseRecyclerAdapter<String> {

    public ItemAdapter(Context context, List<String> datas) {
        super(context, R.layout.item_string, datas);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, String item, int position) {
        TextView tv=holder.getView(R.id.tv);
        tv.setText(item);

    }
}
