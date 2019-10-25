package cn.com.pattern.Iterator.objectList;

import java.util.List;

/**
 * @author xuekun
 * @create 2019-08-15 15:52
 **/
public class ProductList extends AbstractObjectList {
    public ProductList(List<Object> objects) {
        super(objects);
    }

    @Override
    public AbstractIterator createIterator() {
        return null;
    }
}
