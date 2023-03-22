package cn.zime.edu.bigdata2002.Model;

public class Bookd {
    private int id;
    private String book_id;

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

    public String getKaiben() {
        return kaiben;
    }

    public void setKaiben(String kaiben) {
        this.kaiben = kaiben;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getBaozhuang() {
        return baozhuang;
    }

    public void setBaozhuang(String baozhuang) {
        this.baozhuang = baozhuang;
    }

    public String getTaozhuang() {
        return taozhuang;
    }

    public void setTaozhuang(String taozhuang) {
        this.taozhuang = taozhuang;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    private String kaiben;
    private String paper;
    private String baozhuang;
    private String taozhuang;
    private String ISBN;

    public Bookd(int id, String book_id, String kaiben, String paper, String baozhuang, String taozhuang, String ISBN) {
        this.id = id;
        this.book_id = book_id;
        this.kaiben = kaiben;
        this.paper = paper;
        this.baozhuang = baozhuang;
        this.taozhuang = taozhuang;
        this.ISBN = ISBN;
    }
}
