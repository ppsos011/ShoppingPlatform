package cn.edu.zime.bigdata2002.appdemo.dao.model;

import java.util.Date;

public class BookDetail {
    private int id;
    private String book_id;
    private String book_name;

    public String getBook_deimg() {
        return book_deimg;
    }

    public void setBook_deimg(String book_deimg) {
        this.book_deimg = book_deimg;
    }

    public BookDetail(int id, String book_id, String book_name, String book_press, Date book_time, Double book_price, String book_writer, String book_deimg, String book_img, String book_detailed) {
        this.id = id;
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_press = book_press;
        this.book_time = book_time;
        this.book_price = book_price;
        this.book_writer = book_writer;
        this.book_deimg = book_deimg;
        this.book_img = book_img;
        this.book_detailed = book_detailed;
    }

    private String book_press;
    private Date book_time;
    private Double book_price;
    private String book_writer;
    private String book_deimg;

    public BookDetail(String book_img) {
        this.book_img = book_img;
    }

    public BookDetail(int id, String book_id, String book_press, Date book_time, Double book_price, String book_writer, String book_detailed, String book_img) {
    }


    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    private String book_img;

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

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_press() {
        return book_press;
    }

    public void setBook_press(String book_press) {
        this.book_press = book_press;
    }

    public Date getBook_time() {
        return book_time;
    }

    public void setBook_time(Date book_time) {
        this.book_time = book_time;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }

    public String getBook_writer() {
        return book_writer;
    }

    public void setBook_writer(String book_writer) {
        this.book_writer = book_writer;
    }

    public String getBook_detailed() {
        return book_detailed;
    }

    public void setBook_detailed(String book_detailed) {
        this.book_detailed = book_detailed;
    }

    private String book_detailed;


}


