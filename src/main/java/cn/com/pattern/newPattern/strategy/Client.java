package cn.com.pattern.newPattern.strategy;

/**
 * @author xuekun
 * @create 2018-04-13 18:16
 **/
public class Client {
    public static void main(String[] args) {
        AbstractStrategy strategy=new ConcreteStrategyB();
        Context context=new Context(strategy);
        context.foo();
    }
}
