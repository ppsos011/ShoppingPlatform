package cn.zime.edu.bigdata2002.Model;

import java.util.Date;

public class Order {
    private String order_id;
    private String imgURL;
    private String info;
    private Float price;
    private String count;
    private Float total;
    private String order_time;

    public Order(String order_id, String imgURL, String info, Float price, String count, Float total, String order_time) {
        this.order_id = order_id;
        this.imgURL = imgURL;
        this.info = info;
        this.price = price;
        this.count = count;
        this.total = total;
        this.order_time = order_time;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }
}
