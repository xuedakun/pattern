package cn.com.pattern.abstractFactory.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:24
 **/
public class AndroidFactory implements GameAbstractFactory {
    @Override
    public InterfaceController getInterfaceController() {
        return new AndroidInterfaceController();
    }

    @Override
    public OperationController getOperationController() {
        return new AndroidOperationController();
    }
}
