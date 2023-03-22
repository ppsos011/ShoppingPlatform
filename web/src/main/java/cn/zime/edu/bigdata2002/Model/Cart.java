package cn.zime.edu.bigdata2002.Model;

public class Cart {
    private int cid;
    private String checkok;
    private String imgURL;
    private String info;
    private String price;
    private String count;
    private String total;

    public Cart(int cid,String checkok,String imgURL, String info, String price, String count, String total) {
        this.cid = cid;
        this.checkok = checkok;
        this.imgURL = imgURL;
        this.info = info;
        this.price = price;
        this.count = count;
        this.total = total;
    }

    public String getCheckok() {
        return checkok;
    }

    public void setCheckok(String checkok) {
        this.checkok = checkok;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
