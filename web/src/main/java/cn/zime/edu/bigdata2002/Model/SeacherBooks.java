package cn.zime.edu.bigdata2002.Model;


/**
 * 书籍类
 */
public class SeacherBooks {
    private int id;
    private String pic;
    private String title;
    private String price;
    private String discount;
    private String author;
    private String comment;
    private String detail;

    public SeacherBooks() {
    }

    public SeacherBooks(int id, String pic, String title, String price, String discount, String author, String comment, String detail) {
        this.id = id;
        this.pic = pic;
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.author = author;
        this.comment = comment;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
