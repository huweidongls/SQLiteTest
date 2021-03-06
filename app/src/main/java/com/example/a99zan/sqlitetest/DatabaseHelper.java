package com.example.a99zan.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 99zan on 2018/1/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "book.db";//数据库名字
    private static final int DATABASE_VERSION = 1;//数据库版本号

    /**
     * @param context  上下文环境（例如，一个 Activity）
     * @param name   数据库名字
     * @param factory  一个可选的游标工厂（通常是 Null）
     * @param version  数据库模型版本的整数
     *
     * 会调用父类 SQLiteOpenHelper的构造函数
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    /**
     *  在数据库第一次创建的时候会调用这个方法
     *
     *根据需要对传入的SQLiteDatabase 对象填充表和初始化数据。
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("111", "onCreate");
        db.execSQL("CREATE TABLE booklist(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "member_id TEXT, book_name TEXT, book_yanjiang TEXT, book_date TEXT, " +
                "book_time TEXT, book_zhangjie_name TEXT, book_path TEXT);");
    }

    /**
     * 当数据库需要修改的时候（两个数据库版本不同），Android系统会主动的调用这个方法。
     * 一般我们在这个方法里边删除数据库表，并建立新的数据库表.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //三个参数，一个 SQLiteDatabase 对象，一个旧的版本号和一个新的版本号

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        // 每次成功打开数据库后首先被执行
        super.onOpen(db);
    }
}
