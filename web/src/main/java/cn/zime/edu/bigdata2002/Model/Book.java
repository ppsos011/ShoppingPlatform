package cn.zime.edu.bigdata2002.Model;

public class Book {
    private String id;
    private String imgUrl;
    private String title;
    private String price;
    private String discount;
    private String author;

    public Book() {
    }

    public Book(String id, String imgUrl, String title, String price, String discount, String author) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
