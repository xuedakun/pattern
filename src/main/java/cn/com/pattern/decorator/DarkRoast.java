package cn.com.pattern.decorator;

public class DarkRoast implements Beverage {
    @Override
    public double cost() {
        return 1;
    }
}
