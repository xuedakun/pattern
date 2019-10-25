package cn.com.pattern.Iterator;

/**
 * @author xuekun
 * @create 2019-08-15 15:15
 **/
public class ConcreteAggregate implements Aggregate {
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}
