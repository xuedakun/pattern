package cn.com.pattern.prototype;

import java.io.IOException;

/**
 * @author xuekun
 * @create 2019-07-16 15:23
 **/
public class WeeklyClient {

    public static void main(String[] args) {

        WeeklyLog log_previous=null, log_new=null;

        log_previous = new WeeklyLog(); //创建原型对象

        Attachment attachment = new Attachment(); //创建附件对象

        log_previous.setAttachment(attachment);  //将附件添加到周报中

        try {
            log_new = log_previous.deepClone(); //调用克隆方法创建克隆对象
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //比较周报

        System.out.println("周报是否相同？ " + (log_previous == log_new));

        //比较附件

        System.out.println("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));
    }
}
