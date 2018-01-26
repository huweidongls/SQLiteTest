package com.example.a99zan.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SQLiteDatabase db = null;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.listview)
    ListView listView;
    private List<BookEntity> data = new ArrayList<>();
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    private void init() {

        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("member_id", "9527");//添加用户名
        cv.put("book_name", "如何说客户才会听"); //添加密码
        cv.put("book_yanjiang", "小宇哥");
        cv.put("book_date", "2018-01-12");
        cv.put("book_time", "19:12");
        cv.put("book_zhangjie_name", "【第一节】如何说客户才会听懂");
        cv.put("book_path", "/com/99zan/download/yinpin");
        db.insert("booklist", null, cv);//执行插入操作

    }

    private void init1() {

        ContentValues cv = new ContentValues();
        cv.put("member_id", "9528");//添加用户名
        cv.put("book_name", "如何说客户才会听1"); //添加密码
        cv.put("book_yanjiang", "小宇哥1");
        cv.put("book_date", "2018-01-12");
        cv.put("book_time", "19:12");
        cv.put("book_zhangjie_name", "【第一节】如何说客户才会听懂1");
        cv.put("book_path", "/com/99zan/download/yinpin1");
        db.insert("booklist", null, cv);//执行插入操作

    }

    private String select() {
        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();
        String a = "";
        String sql = "select * from booklist where member_id=?";
        Cursor c = db.rawQuery(sql, new String[]{"9527"});
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String book_path = c.getString(c.getColumnIndex("book_path"));
            a = book_path;
        }
        c.close();
        db.close();
        return a;
    }

    private List<BookEntity> getData() {
        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();
        Cursor c = db.query("booklist", null, null, null, null, null, null);//查询并获得游标
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String member_id = c.getString(c.getColumnIndex("member_id"));
            String book_name = c.getString(c.getColumnIndex("book_name"));
            String book_yanjiang = c.getString(c.getColumnIndex("book_yanjiang"));
            String book_date = c.getString(c.getColumnIndex("book_date"));
            String book_time = c.getString(c.getColumnIndex("book_time"));
            String book_zhangjie_name = c.getString(c.getColumnIndex("book_zhangjie_name"));
            String book_path = c.getString(c.getColumnIndex("book_path"));
            data.add(new BookEntity(member_id, book_name, book_yanjiang, book_date, book_time, book_zhangjie_name, book_path));
        }
        c.close();
        db.close();
        return data;
    }

    @OnClick({R.id.btn, R.id.btn1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
//                init();
//                init1();
                Toast.makeText(MainActivity.this, select(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn1:
                adapter = new BookAdapter(this, getData());
                listView.setAdapter(adapter);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
