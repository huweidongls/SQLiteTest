package com.example.a99zan.sqlitetest;

/**
 * Created by 99zan on 2018/1/16.
 */

public class BookEntity {
    String member_id;
    String book_name;
    String book_yanjiang;
    String book_date;
    String book_time;
    String book_zhangjie_name;
    String book_path;

    public BookEntity() {
    }

    public BookEntity(String member_id, String book_name, String book_yanjiang, String book_date, String book_time, String book_zhangjie_name, String book_path) {
        this.member_id = member_id;
        this.book_name = book_name;
        this.book_yanjiang = book_yanjiang;
        this.book_date = book_date;
        this.book_time = book_time;
        this.book_zhangjie_name = book_zhangjie_name;
        this.book_path = book_path;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_yanjiang() {
        return book_yanjiang;
    }

    public void setBook_yanjiang(String book_yanjiang) {
        this.book_yanjiang = book_yanjiang;
    }

    public String getBook_date() {
        return book_date;
    }

    public void setBook_date(String book_date) {
        this.book_date = book_date;
    }

    public String getBook_time() {
        return book_time;
    }

    public void setBook_time(String book_time) {
        this.book_time = book_time;
    }

    public String getBook_zhangjie_name() {
        return book_zhangjie_name;
    }

    public void setBook_zhangjie_name(String book_zhangjie_name) {
        this.book_zhangjie_name = book_zhangjie_name;
    }

    public String getBook_path() {
        return book_path;
    }

    public void setBook_path(String book_path) {
        this.book_path = book_path;
    }
}
