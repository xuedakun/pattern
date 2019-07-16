package cn.com.pattern.factoryMethod.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:55
 **/
public class JpgImgRead implements ImgRread {
    @Override
    public void play() {
        System.out.println("读取JPG图片....");
    }
}
