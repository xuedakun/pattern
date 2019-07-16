package cn.com.pattern.factoryMethod;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xuekun
 * @create 2018-01-17 11:57
 **/
@RunWith(SpringJUnit4ClassRunner.class)
public class Client22 {
    @Test
    public static void main(String[] args) {
//        ReadFactory factory = null;
//        try {
//            try {
//                factory = (ReadFactory) Class.forName("cn.com.pattern.factoryMethod.ReadFactoryGif").newInstance();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//            factory.read();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        JSONObject str=new JSONObject();
        JSONObject str2=str;
        System.out.println(str2==str);
        System.out.println(test(str)==str);
        System.out.println(test(str).equals(str));
        System.out.println(str.toJSONString());
        System.out.println(test(str).toJSONString());
        System.out.println(str.toJSONString());
    }

    public static JSONObject test(JSONObject s){
        s.put("1",2);
        s=new JSONObject();
        s.put("2",3);
        return s;
    }
}
