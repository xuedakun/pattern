package cn.com.pattern.composite.killVirus;

/**
 * @author xuekun
 * @create 2019-07-26 15:17
 **/
public abstract class AbstractFile {
    public AbstractFile(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChildren(Integer i);

    public abstract void killVirus();
}
