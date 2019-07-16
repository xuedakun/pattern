package cn.com.pattern.factoryMethod.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:59
 **/
public class ImgClient {

    public static void main(String[] args) {
        ImgAbstractFactory factory=new JpgImgFactory();
        factory.getImgRead().play();
        factory=new GifImgFactory();
        factory.getImgRead().play();
    }
}
