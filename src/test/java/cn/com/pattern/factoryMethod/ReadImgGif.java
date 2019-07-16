package cn.com.pattern.factoryMethod;

/**
 * @author xuekun
 * @create 2018-01-17 11:54
 **/
public class ReadImgGif implements ReadImg {
    @Override
    public void readImg() {
        System.out.println("读取gif图片！");
    }
}
