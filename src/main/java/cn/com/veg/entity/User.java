package cn.com.veg.entity;

public class User {

    private int id;
    private String usr;
    private String pwd;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(int id, String usr, String pwd) {
        this.id = id;
        this.usr = usr;
        this.pwd = pwd;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usr='" + usr + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
