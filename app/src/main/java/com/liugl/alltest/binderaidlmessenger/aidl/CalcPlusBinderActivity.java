package com.liugl.alltest.binderaidlmessenger.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalcPlusBinderActivity extends AppCompatActivity {
    @BindView(R.id.bindServicebtn)
    Button bindServicebtn;
    @BindView(R.id.unbindServicebtn)
    Button unbindServicebtn;
    @BindView(R.id.mulInvokedbtn)
    Button mulInvokedbtn;
    @BindView(R.id.divInvokedbtn)
    Button divInvokedbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_plus_binder);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bindServicebtn, R.id.unbindServicebtn, R.id.mulInvokedbtn, R.id.divInvokedbtn,})
    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.bindServicebtn:
                bindService();
                break;
            case R.id.unbindServicebtn:
                unbindService();
                break;
            case R.id.mulInvokedbtn:
                try {
                    mulInvoked();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.divInvokedbtn:
                try {
                    divInvoked();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    ////


    private IBinder mPlusBinder;
    private ServiceConnection mServiceConnPlus = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("client", "mServiceConnPlus onServiceDisconnected");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Log.e("client", " mServiceConnPlus onServiceConnected");
            mPlusBinder = service;
        }
    };


    public void bindService() {
        Intent intentPlus = new Intent();
        intentPlus.setAction("com.zhy.aidl.calcplus");
        boolean plus = bindService(IntentUtils.createExplicitFromImplicitIntent(this,intentPlus), mServiceConnPlus,
                Context.BIND_AUTO_CREATE);
        Log.e("plus", plus + "");
    }

    public void unbindService( ) {
        unbindService(mServiceConnPlus);
    }

    public void mulInvoked( ) {

        if (mPlusBinder == null) {
            Toast.makeText(this, "未连接服务端或服务端被异常杀死", Toast.LENGTH_SHORT).show();
        } else {
            android.os.Parcel _data = android.os.Parcel.obtain();
            android.os.Parcel _reply = android.os.Parcel.obtain();
            int _result;
            try {
                _data.writeInterfaceToken("CalcPlusService");
                _data.writeInt(50);
                _data.writeInt(12);
                mPlusBinder.transact(0x110, _data, _reply, 0);
                _reply.readException();
                _result = _reply.readInt();
                Toast.makeText(this, _result + "", Toast.LENGTH_SHORT).show();

            } catch (RemoteException e) {
                e.printStackTrace();
            } finally {
                _reply.recycle();
                _data.recycle();
            }
        }

    }

    public void divInvoked( ) {

        if (mPlusBinder == null) {
            Toast.makeText(this, "未连接服务端或服务端被异常杀死", Toast.LENGTH_SHORT).show();
        } else {
            android.os.Parcel _data = android.os.Parcel.obtain();
            android.os.Parcel _reply = android.os.Parcel.obtain();
            int _result;
            try {
                _data.writeInterfaceToken("CalcPlusService");
                _data.writeInt(36);
                _data.writeInt(12);
                mPlusBinder.transact(0x111, _data, _reply, 0);
                _reply.readException();
                _result = _reply.readInt();
                Toast.makeText(this, _result + "", Toast.LENGTH_SHORT).show();

            } catch (RemoteException e) {
                e.printStackTrace();
            } finally {
                _reply.recycle();
                _data.recycle();
            }
        }

    }

}
