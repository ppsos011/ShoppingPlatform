package cn.zime.edu.bigdata2002.Model;

public class Address {
    private int id;
    private String name;
    private String number;
    private String favor;
    private String favorAuthor;
    private String genda;
    private String input;
    private String autograph;
    private String fullAddress;

    public Address() {
    }

    public Address(int id, String name, String number, String favor, String favorAuthor, String genda, String input, String autograph, String fullAddress) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.favor = favor;
        this.favorAuthor = favorAuthor;
        this.genda = genda;
        this.input = input;
        this.autograph = autograph;
        this.fullAddress = fullAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

    public String getFavorAuthor() {
        return favorAuthor;
    }

    public void setFavorAuthor(String favorAuthor) {
        this.favorAuthor = favorAuthor;
    }

    public String getGenda() {
        return genda;
    }

    public void setGenda(String genda) {
        this.genda = genda;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
