package cn.com.pattern.proxy.jdk;

/**
 * @author xuekun
 * @create 2019-11-25 11:39
 **/
public class UserDaoProxy implements IUserDao {
    private IUserDao uerDao;

    @Override
    public void save() {
        System.out.println("save before");
        uerDao.save();
        System.out.println("save end");
    }

    @Override
    public void delete() {
        System.out.println("delete before");
        uerDao.delete();
        System.out.println("delete before");
    }

    public UserDaoProxy(IUserDao uerDao) {
        this.uerDao = uerDao;
    }
}
