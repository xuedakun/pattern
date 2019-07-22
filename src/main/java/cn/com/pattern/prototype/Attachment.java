package cn.com.pattern.prototype;

import java.io.Serializable;

public class Attachment implements Serializable {
    //附件名
    private  String name;

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return this.name;

    }


    public void download() {

        System.out.println("下载附件，文件名为" + name);

    }

}
