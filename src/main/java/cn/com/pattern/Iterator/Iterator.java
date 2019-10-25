package cn.com.pattern.Iterator;

/**
 * @Author:xuekun
 * @Description:抽象跌倒器
 * @DateTime:2019/8/15 15:03
 */
public interface Iterator {

    public void first();

    public void next();

    public boolean hasNext();

    public Object currentIte();
}
