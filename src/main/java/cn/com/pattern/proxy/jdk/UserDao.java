package cn.com.pattern.proxy.jdk;

/**
 * @author xuekun
 * @create 2019-11-25 11:38
 **/
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据！");
    }

    @Override
    public void delete() {
        System.out.println("删除数据！");
    }

    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        int b[]=a;

        b[0]=9;

        System.out.println(a[0]);
    }
}
