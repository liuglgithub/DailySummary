package com.liugl.alltest.view.datapick;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liugl.alltest.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by liugl on 2017/2/7.
 */

public class CalendarView extends LinearLayout {


    /**
     * 年
     * 这个是年的显示的控件，所有的年都是在这一个控件中显示，
     * 这个控件中可以显示的年份的个数，可以动态配置
     */
    private SpinnerView mYearSpinnerView;

    /**
     * 月
     */
    private SpinnerView mMonthSpinnerView;

    /**
     * 日
     */
    private SpinnerView mDaySpinnerView;

    /**
     * 文本颜色
     */
    private int mTextColor;

    /**
     * 文本大小
     */
    private int mTextSize;

    /**
     * 选中文本的颜色
     */
    private int mSelectedTextColor;

    /**
     *  选中线的颜色
     */
    private int mSelectedLineColor;
    /**
     * 选择的年, 月，日
     */
    private int mSelectYear, mSelectMonth, mSelectDay;

    /**
     * 时间linarlayout
     */
    private LinearLayout mLlDate;

    /**
     * 时间选中的回调
     */
    private OnDateSelectedListener mOnDateSelectedListener;

    public interface OnDateSelectedListener {
        void onDateSelected(int year,int month,int day);
    }


    public CalendarView(Context context) {
        super(context);
    }

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context mContext,AttributeSet attrs){

        setOrientation(VERTICAL);
        initStyle(mContext,attrs);

        /**
         * 放置，时间控件的layout，
         */
        LayoutParams datelayoutLP = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mLlDate = new LinearLayout(mContext);
        mLlDate.setOrientation(HORIZONTAL);
        mLlDate.setLayoutParams(datelayoutLP);
        addView(mLlDate);

        /**
         * 时间控件和确定按钮的分割线
         */
        View divisionLineView = new View(mContext);
        divisionLineView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,1));
        divisionLineView.setBackgroundColor(mSelectedLineColor);
        addView(divisionLineView);

        /**
         *  添加按钮布局
         */
        TextView tvSure = new TextView(mContext);
        tvSure.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        tvSure.setGravity(Gravity.CENTER_HORIZONTAL);
        tvSure.setTextSize(16);
        tvSure.setPadding(0, 25, 0, 25);
        tvSure.setText("确定");
        addView(tvSure);
        tvSure.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnDateSelectedListener != null) {
                    mOnDateSelectedListener.onDateSelected(mSelectYear, mSelectMonth, mSelectDay);
                }
            }
        });

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 800);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mYearSpinnerView = new SpinnerView(mContext);
        addViewData(mYearSpinnerView, lp, getYearList(), "年");

        mMonthSpinnerView = new SpinnerView(mContext);
        addViewData(mMonthSpinnerView, lp, getMonthList(), "月");

        mDaySpinnerView = new SpinnerView(mContext);
        addViewData(mDaySpinnerView, lp, new ArrayList<String>(), "日");

        setListener();

    }

    private void setListener(){

        mYearSpinnerView.setmOnDataSelectedListener(new SpinnerView.OnDataSelectedListener() {
            @Override
            public void onSelected(int data) {
                mSelectYear = data;
                setDayAllDataAndCurrentData();//滑动年月的时候需要实时的调整日
            }
        });

        mMonthSpinnerView.setmOnDataSelectedListener(new SpinnerView.OnDataSelectedListener() {
            @Override
            public void onSelected(int data) {
                mSelectMonth = data;
                setDayAllDataAndCurrentData();//滑动年月的时候需要实时的调整日
            }
        });

        mDaySpinnerView.setmOnDataSelectedListener(new SpinnerView.OnDataSelectedListener() {
            @Override
            public void onSelected(int data) {
                mSelectDay = data;
            }
        });
    }
    public void setDate(String date) {
        String[] dateArray = date.split("-");
        switch (dateArray.length) {
            case 3:
                mSelectYear = Integer.valueOf(dateArray[0]);
                mSelectMonth = Integer.valueOf(dateArray[1]);
                mSelectDay = Integer.valueOf(dateArray[2]);
                break;
            case 2:
                mSelectYear = Integer.valueOf(dateArray[0]);
                mSelectMonth = Integer.valueOf(dateArray[1]);
                break;
            case 1:
                mSelectDay = Integer.valueOf(dateArray[0]);
                break;
        }
        mYearSpinnerView.setCurrentData(mSelectYear + "年");
        mMonthSpinnerView.setCurrentData((mSelectMonth > 9 ? mSelectMonth : "0" + mSelectMonth) + "月");
        setDayAllDataAndCurrentData();
    }
    private void setDayAllDataAndCurrentData(){
        List<String> dayList = getDayList(mSelectYear + "-" + (mSelectMonth > 9 ? mSelectMonth : "0" + mSelectMonth));
        mDaySpinnerView.setmAllDataList(dayList);
        checkDayIsExist(dayList);
        mDaySpinnerView.setCurrentData((mSelectDay > 9 ? mSelectDay : "0" + mSelectDay) + "日");
    }

    private void checkDayIsExist(List<String> dayList) {
        String selectDayStr = (mSelectDay > 9 ? mSelectDay : "0" + mSelectDay) + "日";
        if(!dayList.contains(selectDayStr)) {
            mSelectDay--;
            checkDayIsExist(dayList);
        }
    }

    private List<String> getYearList(){
        List<String> dataList = new ArrayList<>();
        for(int i = 1970; i < 2035; i++) {
            dataList.add(i + "年");
        }
        return dataList;
    }

    private List<String> getMonthList() {
        List<String> monthList = new ArrayList<>();
        for(int i = 1; i <= 12; i++) {
            monthList.add((i > 9 ? i : "0" + i) + "月");
        }
        return monthList;
    }

    private List<String> getDayList(String yearMonth) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate(yearMonth, "yyyy-MM"));
        int monthMaxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<String> dayList = new ArrayList<>();
        for(int i = 1; i <= monthMaxDay; i++) {
            dayList.add((i > 9 ? i : "0" + i) + "日");
        }
        return dayList;
    }

    private Date getDate(String dateStr, String datePattern){
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *
     * 将年、月、日的list集合展示在时间控件中。
     *
     * @param spinnerView
     * @param lp
     * @param dataList
     * @param unit
     */
    private void addViewData(SpinnerView spinnerView,LayoutParams lp,List<String> dataList,String unit){

        spinnerView.setLayoutParams(lp);
        mLlDate.addView(spinnerView);
        spinnerView.setmAllDataList(dataList);
        spinnerView.setmUnit(unit);
        setStyle(spinnerView);
    }

    private void setStyle(SpinnerView spinnerView){
        spinnerView.setmTextColor(mTextColor);
        spinnerView.setmTextSize(mTextSize);
        spinnerView.setmSelectedTextColor(mSelectedTextColor);
        spinnerView.setSelectLineColor(mSelectedLineColor);
        spinnerView.invalidate();
    }

    /**
     * 获取自定义的属性
     * @param
     * @param attrs
     */
    private void initStyle(Context context,AttributeSet attrs){

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CalendarViewStyle);
        mTextColor = typedArray.getColor(R.styleable.CalendarViewStyle_textColor, Color.parseColor("#999999"));
        mSelectedTextColor = typedArray.getColor(R.styleable.CalendarViewStyle_selectedTextColor, Color.parseColor("#3F51B5"));
        mSelectedLineColor = typedArray.getColor(R.styleable.CalendarViewStyle_selectedLineColor, Color.parseColor("#D6D6D6"));
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.CalendarViewStyle_selectedTextColor,50);
        typedArray.recycle();

    }

    public OnDateSelectedListener getmOnDateSelectedListener() {
        return mOnDateSelectedListener;
    }

    public void setOnDateSelectedListener(OnDateSelectedListener mOnDateSelectedListener) {
        this.mOnDateSelectedListener = mOnDateSelectedListener;
    }
}
