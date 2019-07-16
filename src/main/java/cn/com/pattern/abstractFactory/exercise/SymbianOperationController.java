package cn.com.pattern.abstractFactory.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:28
 **/
public class SymbianOperationController implements OperationController {
    @Override
    public void play() {
        System.out.println("塞班系统游戏操作控制.....");
    }
}
