package cn.com.pattern.factoryMethod;

/**
 * @author xuekun
 * @create 2018-01-17 11:54
 **/
public class ReadImgJpg implements ReadImg {
    @Override
    public void readImg() {
        System.out.println("读取jpg图片！");
    }
}
