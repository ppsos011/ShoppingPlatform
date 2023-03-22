package cn.zime.edu.bigdata2002.Model;

public class Menu {
    private String id;
    private String level;
    private String parentId;
    private String menu;

    public Menu(String id, String level, String parentId, String menu) {
        this.id = id;
        this.level = level;
        this.parentId = parentId;
        this.menu = menu;
    }

    public Menu() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
