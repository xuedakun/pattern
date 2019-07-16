package cn.com.pattern.abstractFactory.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:20
 **/
public interface GameAbstractFactory {

    InterfaceController getInterfaceController();
    OperationController getOperationController();
}
