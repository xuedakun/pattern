package cn.com.pattern.factoryMethod.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:56
 **/
public class GifImgFactory implements ImgAbstractFactory {
    @Override
    public ImgRread getImgRead() {
        return new GifImgRead();
    }
}
