package edu.tomerbu.lec11firebase;


//Firebase database rules for custom objects:
public class User {
    //property:
    private String name;
    private String uid;

    //required empty constructor
    public User() {
    }
    public User(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
