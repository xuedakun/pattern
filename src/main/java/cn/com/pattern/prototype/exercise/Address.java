package cn.com.pattern.prototype.exercise;

import java.io.Serializable;

/**
 * @author xuekun
 * @create 2019-07-16 18:21
 **/
public class Address implements Cloneable, Serializable {
    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
