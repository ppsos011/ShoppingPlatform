package cn.zime.edu.bigdata2002.Model;


/**
 * 用户类
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String phonenum;
    private String profession;

    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password,String phonenum,String profession) {
        this.username = username;
        this.password = password;
        this.phonenum = phonenum;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
