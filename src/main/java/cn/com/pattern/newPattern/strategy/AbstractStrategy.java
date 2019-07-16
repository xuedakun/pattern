package cn.com.pattern.newPattern.strategy ;

/**
 * 抽象策略类
 * @author xuekun
 * @create 2018-04-13 17:53
 **/
public abstract class AbstractStrategy {

    public abstract void strategy();

    public void foo(){
        //公用的方法和逻辑
        System.out.println("公用的逻辑");
        this.strategy();//需要具体策略类实现的方法
    }
}
