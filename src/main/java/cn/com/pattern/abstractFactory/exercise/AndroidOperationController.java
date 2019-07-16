package cn.com.pattern.abstractFactory.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:28
 **/
public class AndroidOperationController implements OperationController {
    @Override
    public void play() {
        System.out.println("安卓系统游戏操作控制.....");
    }
}
