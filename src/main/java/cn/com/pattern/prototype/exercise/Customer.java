package cn.com.pattern.prototype.exercise;

import java.io.*;

/**
 * @author xuekun
 * @create 2019-07-16 18:20
 **/
public class Customer implements Cloneable, Serializable {

    private String name;
    private int age;
    private int sex;
    private Address address;

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Customer clone() {

        Object obj = null;

        try {

            obj = super.clone();

            return (Customer) obj;

        } catch (CloneNotSupportedException e) {

            System.out.println("不支持复制！");

            return null;

        }

    }

    public Customer deepClone() {


        try {

            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (Customer) ois.readObject();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return null;
    }
}
