package com.liugl.alltest.animation.defualtinterpolator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BaseInterpolator;
import android.widget.ImageView;

import com.liugl.alltest.R;

/**
 * Created by liugl on 2018/5/3.
 */

public abstract class InterpolatorBaseActivity extends AppCompatActivity{

    public ImageView imageView;
    public BaseInterpolator baseInterpolator;
    public Animation alphaAnimation, translateAnimation, scaleAnimation, rotateAnimaton, setAnimation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolatorbase_layout);
        imageView = (ImageView) findViewById(R.id.imageView);
        addBaseInterpolator();
        initAnimations();
    }

    /**
     *
     * 无论我们补间动画的哪一种都已经具备了这种属性，也都可以设置使用这些属性中的一个或多个
     *
     *
     * xml属性	                java方法	                        解释
     android:detachWallpaper	setDetachWallpaper(boolean)	    是否在壁纸上运行
     android:duration	        setDuration(long)	            动画持续时间，毫秒为单位
     android:fillAfter	        setFillAfter(boolean)	        控件动画结束时是否保持动画最后的状态
     android:fillBefore	        setFillBefore(boolean)	        控件动画结束时是否还原到开始动画前的状态
     android:fillEnabled	    setFillEnabled(boolean)	        与android:fillBefore效果相同
     android:interpolator	    setInterpolator(Interpolator)	设定插值器（指定的动画效果，譬如回弹等）
     android:repeatCount	    setRepeatCount(int)	            重复次数
     android:repeatMode	        setRepeatMode(int)	            重复类型有两个值，reverse表示倒序回放，restart表示从头播放
     android:startOffset	    setStartOffset(long)	        调用start函数之后等待开始运行的时间，单位为毫秒
     android:zAdjustment	    setZAdjustment(int)	            表示被设置动画的内容运行时在Z轴上的位置（top/bottom/normal），默认为normal
     */
    protected void initAnimations() {
        initAlphaAnimation();
        initTranslateAnimation();
        initRotateAnimation();
        initScaleAnimation();
        initSetAnimation();
    }


    abstract void addBaseInterpolator();

    /**
     * xml:  android:fromAlpha
     * java: AlphaAnimation(float fromAlpha, …)
     * 动画开始的透明度（0.0到1.0，0.0是全透明，1.0是不透明）
     *
     * xml:  android:toAlpha
     * java: AlphaAnimation(…, float toAlpha)
     * 动画结束的透明度，同上
     *
     */
    public void initAlphaAnimation(){
        alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.default_alpha);
        alphaAnimation.setInterpolator(baseInterpolator);
    }

    /**
     *  xml属性	            java方法	                                    解释
        android:fromXDelta	TranslateAnimation(float fromXDelta, …)	    起始点X轴坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）
        android:fromYDelta	TranslateAnimation(…, float fromYDelta, …)	起始点Y轴从标，同上规律
        android:toXDelta	TranslateAnimation(…, float toXDelta, …)	结束点X轴坐标，同上规律
        android:toYDelta	TranslateAnimation(…, float toYDelta)	    结束点Y轴坐标，同上规律
     */
    private void initTranslateAnimation() {
        translateAnimation = AnimationUtils.loadAnimation(this, R.anim.default_translate);
        translateAnimation.setInterpolator(baseInterpolator);
    }

    /**
     * xml属性	        java方法	                            解释
     android:fromXScale	ScaleAnimation(float fromX, …)	    初始X轴缩放比例，1.0表示无变化
     android:toXScale	ScaleAnimation(…, float toX, …)	    结束X轴缩放比例
     android:fromYScale	ScaleAnimation(…, float fromY, …)	初始Y轴缩放比例
     android:toYScale	ScaleAnimation(…, float toY, …)	    结束Y轴缩放比例
     android:pivotX	    ScaleAnimation(…, float pivotX, …)	缩放起点X轴坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）
     android:pivotY	    ScaleAnimation(…, float pivotY)	    缩放起点Y轴坐标，同上规律
     */
    private void initScaleAnimation() {
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.default_scale);
        scaleAnimation.setInterpolator(baseInterpolator);
    }

    /**
     * xml属性	            java方法	                                解释
     android:fromDegrees	RotateAnimation(float fromDegrees, …)	旋转开始角度，正代表顺时针度数，负代表逆时针度数
     android:toDegrees	    RotateAnimation(…, float toDegrees, …)	旋转结束角度，正代表顺时针度数，负代表逆时针度数
     android:pivotX	        RotateAnimation(…, float pivotX, …)	    缩放起点X坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）
     android:pivotY	        RotateAnimation(…, float pivotY)	    缩放起点Y坐标，同上规律
     */
    private void initRotateAnimation() {
        rotateAnimaton = AnimationUtils.loadAnimation(this, R.anim.default_rotate);
        rotateAnimaton.setInterpolator(baseInterpolator);
    }

    private void initSetAnimation() {
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.default_set);
        setAnimation.setInterpolator(baseInterpolator);
    }



    public void alpha(View view) {
        imageView.startAnimation(alphaAnimation);
    }

    public void translate(View view) {
        imageView.startAnimation(translateAnimation);
    }

    public void scale(View view) {
        imageView.startAnimation(scaleAnimation);
    }

    public void rotate(View view) {
        imageView.startAnimation(rotateAnimaton);
    }

    public void set(View view) {
        imageView.startAnimation(setAnimation);
    }

}
