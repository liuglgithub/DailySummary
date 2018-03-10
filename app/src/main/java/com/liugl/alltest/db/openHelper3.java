package com.liugl.alltest.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by liugl on 2017/10/26.
 */

public class openHelper3 extends SQLiteOpenHelper {

String tag = "ceshidblgl";
    private static final String DB_NAME = "lgdfltestdb.db"; // 数据库名称
    private static final int version = 2; // 数据库版本




    public openHelper3(Context context ) {
        super(context, DB_NAME, null, version);
    }


    public openHelper3(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 编写【从0开始到最新状态】建表语句
        Log.i(tag, "没有数据库，创建v4.0数据库");
        //0-->v3.0
        String sql_message = "create table t_message (id int primary key,userName varchar(50),lastMessage varchar(50),datetime  varchar(50),isdel bit default 0)";
        String inse="insert into t_message values(1,'TT','一起去旅游','10月1号',0)";
        db.execSQL(sql_message);

        db.execSQL(inse);
        Log.i(tag,"ok");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(tag, "开始执行onUpgrade");
        if(oldVersion==1) {
            String inse2="insert into t_message values(2,'TT2','一起去旅游','10月1号',0)";
            String inse3="insert into t_message values(3,'TT3','一起去旅游','10月1号',0)";
            db.execSQL(inse2);
            db.execSQL(inse3);
            Log.i("hi", "升级v1.0-->v3.0数据库");
        }

//        //v2.0--->3.0
//        if(oldVersion==2) {
//            String sql="alter table t_message add column isdel bit default 0";
//            db.execSQL(sql);
//            Log.i("hi", "升级v2.0-->v3.0数据库");
//        }

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(tag, "开始执行onDowngrade");
    }

}
