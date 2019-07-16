package cn.com.pattern.newPattern.proxy;

/**
 * 静态代理
 *
 * @author xuekun
 * @create 2018-04-13 15:07
 **/
public class TargetProxy implements ITargetDao {

    private ITargetDao dao;

    public TargetProxy(ITargetDao dao) {
        this.dao = dao;
    }

    @Override
    public void save() {
        dao.save();
    }

    @Override
    public void update() {
        dao.update();
    }

    @Override
    public void find() {
        dao.find();
    }
}
