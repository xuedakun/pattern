package cn.com.pattern.factoryMethod;

/**
 * @author xuekun
 * @create 2018-01-17 11:55
 **/
public abstract class ReadFactory {
    public void read() {
        createReadImg().readImg();
    }

    public abstract ReadImg createReadImg();
}
