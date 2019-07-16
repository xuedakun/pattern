package cn.com.pattern.newPattern.strategy;

/**
 * @author xuekun
 * @create 2018-04-13 18:14
 **/
public class Context {

    private AbstractStrategy strategy;

    public Context(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    //具体的逻辑
    public void foo(){
        System.out.println("具体的逻辑");
        strategy.foo();
    }
}
