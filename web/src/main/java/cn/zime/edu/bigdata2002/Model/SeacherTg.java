package cn.zime.edu.bigdata2002.Model;

/**
 * 推广广告类
 */
public class SeacherTg {
    private int id;
    private String pic2;
    private String de2;
    private String price2;
    private String discount2;


    public SeacherTg() {
    }

    public SeacherTg(int id, String pic2, String de2, String price2, String discount2) {
        this.id = id;
        this.pic2 = pic2;
        this.de2 = de2;
        this.price2 = price2;
        this.discount2 = discount2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getDe2() {
        return de2;
    }

    public void setDe2(String de2) {
        this.de2 = de2;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getDiscount2() {
        return discount2;
    }

    public void setDiscount2(String discount2) {
        this.discount2 = discount2;
    }
}
