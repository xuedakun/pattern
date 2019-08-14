package cn.com.pattern.composite.killVirus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xuekun
 * @create 2019-07-26 15:33
 **/
public class Folder extends AbstractFile {
    private List<AbstractFile> child=new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void add(AbstractFile file) {
        child.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        child.remove(file);
    }

    @Override
    public  AbstractFile getChildren(Integer i) {
        return child.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("----");
        System.out.println("开始对["+getName()+"]夹进行杀毒");

        child.forEach(i->{
            i.killVirus();

        }); System.out.println("----");
    }
}
