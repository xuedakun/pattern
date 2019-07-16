package cn.com.pattern.newPattern.proxy;

/**
 * @author xuekun
 * @create 2018-04-13 15:06
 **/
public class TargetDao implements ITargetDao {
    @Override
    public void save() {
        System.out.println("save.......");
    }

    @Override
    public void update() {
        System.out.println("update.......");
    }

    @Override
    public void find() {
        System.out.println("find.......");
    }
}
