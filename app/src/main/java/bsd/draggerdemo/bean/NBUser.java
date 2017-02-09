package bsd.draggerdemo.bean;

/**
 * Created by ShiDa.Bian on 2017/2/9.
 */
public class NBUser{
    private String name;
    private int age;

    public NBUser() {
    }

    public NBUser(String name, int age) {
        this.name = name+"_nb";
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
