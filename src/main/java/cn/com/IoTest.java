package cn.com;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xuekun
 * @create 2019-11-06 11:52
 **/
public class IoTest {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        /* 字节流 */
        InputStream is = null;
        try {
            is = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* 字符流 */
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(is, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /* 提供缓存功能 */
        BufferedReader br = new BufferedReader(isr);

        String line;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) {
                    break;
                }
                System.out.println(line+"\r");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
