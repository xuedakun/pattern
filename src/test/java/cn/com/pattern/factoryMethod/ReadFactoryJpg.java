package cn.com.pattern.factoryMethod;

/**
 * @author xuekun
 * @create 2018-01-17 11:56
 **/
public class ReadFactoryJpg extends ReadFactory {
    @Override
    public ReadImg createReadImg() {

        return new ReadImgJpg();
    }
}
