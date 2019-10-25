package cn.com.pattern.Iterator.objectList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuekun
 * @create 2019-08-15 15:48
 **/
public abstract class AbstractObjectList {

    private List<Object> objects = new ArrayList<>();

    public AbstractObjectList(List<Object> objects) {
        this.objects = objects;
    }

    public void addObject(Object object) {
        objects.add(object);
    }
    public void removeObject(Object object) {
        objects.remove(object);
    }

    public List<Object> getObjects() {
        return objects;
    }
    public abstract AbstractIterator createIterator();
}
