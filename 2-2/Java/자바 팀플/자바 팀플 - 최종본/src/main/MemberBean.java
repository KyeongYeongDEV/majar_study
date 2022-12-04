package main;

public class MemberBean {
    int group_code;
    String id;
    String name;
    String password;

    String group;
    String group_check;

    public String getGroup_check() {
        return group_check;
    }

    public void setGroup_check(String group_check) {
        this.group_check = group_check;
    }

    public int getGroup_code() {
        return group_code;
    }

    public void setGroup_code(int group_code) {
        this.group_code = group_code;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroup(){return group;}

    public void setGroup(String group){this.group = group;
    }
}
