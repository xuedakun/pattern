package cn.com.pattern.newPattern.strategy;

/**
 * 具体策略类
 * @author xuekun
 * @create 2018-04-13 18:12
 **/
public class ConcreteStrategyA extends AbstractStrategy {
    @Override
    public void strategy() {
        System.out.println("a....");
    }
}
