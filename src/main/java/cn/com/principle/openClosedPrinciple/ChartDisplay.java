package cn.com.principle.openClosedPrinciple;

/**
 * @Author:xuekun
 * @Description: 单一关闭原则 面向对象编程语言中都提供了接口、抽象类等机制，可以通过它们定义系统的抽象层，
 * 再通过具体类来进行扩展。如果需要修改系统的行为，无须对抽象层进行任何改动，
 * 只需要增加新的具体类来实现新的业务功能即可，实现在不修改已有代码的基础上扩展系统的功能，达到开闭原则的要求。
 * @DateTime:2018/1/8 17:56
 */
public class ChartDisplay {

    private AbstractChart abstractChart;

    private void setChart(AbstractChart chart) {
        abstractChart = chart;
    }

    void display() {
        abstractChart.display();
    }
}
