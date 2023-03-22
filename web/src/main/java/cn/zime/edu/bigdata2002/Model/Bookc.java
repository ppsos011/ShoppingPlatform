package cn.zime.edu.bigdata2002.Model;

import java.util.Date;

public class Bookc {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    public Date getUser_ctime() {
        return user_ctime;
    }

    public void setUser_ctime(Date user_ctime) {
        this.user_ctime = user_ctime;
    }

    public String getUser_grade() {
        return user_grade;
    }

    public void setUser_grade(String user_grade) {
        this.user_grade = user_grade;
    }

    private String book_id;
    private String user_name;
    private String user_comment;
    private Date user_ctime;
    private String user_grade;

    public Bookc(int id, String book_id, String user_name, String user_comment, Date user_ctime, String user_grade) {
        this.id = id;
        this.book_id = book_id;
        this.user_name = user_name;
        this.user_comment = user_comment;
        this.user_ctime = user_ctime;
        this.user_grade = user_grade;
    }



}
