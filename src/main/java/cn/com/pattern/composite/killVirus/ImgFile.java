package cn.com.pattern.composite.killVirus;

/**
 * @author xuekun
 * @create 2019-07-26 15:33
 **/
public class ImgFile extends  AbstractFile {
    public ImgFile(String name) {
        super(name);
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    @Override
    public  AbstractFile getChildren(Integer i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("对"+getName()+"进行杀毒！");
    }
}
