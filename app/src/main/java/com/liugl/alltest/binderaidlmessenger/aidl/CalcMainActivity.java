package com.liugl.alltest.binderaidlmessenger.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liugl.alltest.R;
import com.liugl.alltest.binderaidlmessenger.ICalcAIDL;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalcMainActivity extends AppCompatActivity {

    private ICalcAIDL mCalcAidl;
    @BindView(R.id.bindServicebtn)
    Button bindServicebtn;
    @BindView(R.id.unbindServicebtn)
    Button unbindServicebtn;
    @BindView(R.id.addInvokedbtn)
    Button addInvokedbtn;
    @BindView(R.id.minInvokedbtn)
    Button minInvokedbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bindServicebtn, R.id.unbindServicebtn, R.id.addInvokedbtn, R.id.minInvokedbtn,})
    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.bindServicebtn:
                bindService( );
                break;
            case R.id.unbindServicebtn:
                unbindService();
                break;
            case R.id.addInvokedbtn:
                try {
                    addInvoked();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.minInvokedbtn:
                try {
                    minInvoked();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private ServiceConnection mServiceConn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("client", "onServiceDisconnected");
            mCalcAidl = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("client", "onServiceConnected");
            mCalcAidl = ICalcAIDL.Stub.asInterface(service);
        }
    };


    /**
     * 点击BindService按钮时调用
     *
     */
    public void bindService( ) {
        Intent intent = new Intent();
        intent.setAction("com.zhy.aidl.calc");//aidl
        bindService(createExplicitFromImplicitIntent(this,intent), mServiceConn, Context.BIND_AUTO_CREATE);
    }

    /**
     * 点击unBindService按钮时调用
     *

     */
    public void unbindService( ) {
        unbindService(mServiceConn);
    }

    /**
     * 点击12+12按钮时调用
     *
     */
    public void addInvoked( ) throws Exception {

        if (mCalcAidl != null) {
            int addRes = mCalcAidl.add(12, 12);
            Toast.makeText(this, addRes + "", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "服务器被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT)
                    .show();

        }

    }

    /**
     * 点击50-12按钮时调用
     *
     */
    public void minInvoked( ) throws Exception {

        if (mCalcAidl != null) {
            int addRes = mCalcAidl.min(58, 12);
            Toast.makeText(this, addRes + "", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "服务端未绑定或被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT)
                    .show();

        }

    }
    /***
     * Android L (lollipop, API 21) introduced a new problem when trying to invoke implicit intent,
     * "java.lang.IllegalArgumentException: Service Intent must be explicit"
     *
     * If you are using an implicit intent, and know only 1 target would answer this intent,
     * This method will help you turn the implicit intent into the explicit form.
     *
     * Inspired from SO answer: http://stackoverflow.com/a/26318757/1446466
     * @param context
     * @param implicitIntent - The original implicit intent
     * @return Explicit Intent created from the implicit original intent
     */
    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        // Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }
}
