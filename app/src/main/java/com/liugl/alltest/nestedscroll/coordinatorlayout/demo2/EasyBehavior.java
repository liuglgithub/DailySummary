package com.liugl.alltest.nestedscroll.coordinatorlayout.demo2;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by liugl on 2017/2/16.
 */

public class EasyBehavior extends CoordinatorLayout.Behavior<TextView>{  ////这里的泛型是child的类型，也就是观察者View

    /**
     * Default constructor for inflating Behaviors from layout. The Behavior will have
     * the opportunity to parse specially defined layout parameters. These parameters will
     * appear on the child view tag.
     *
     * @param context
     * @param attrs
     */
    public EasyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        // 告知监听的dependency是Button
        return dependency instanceof Button;
    }

    /**
     * 当 dependency(Button)变化的时候，可以对child(TextView)进行操作
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {

        child.setX(dependency.getX()+200);
        child.setY(dependency.getY()+200);
        child.setText(dependency.getX()+","+dependency.getY());

        return true;
    }
}
