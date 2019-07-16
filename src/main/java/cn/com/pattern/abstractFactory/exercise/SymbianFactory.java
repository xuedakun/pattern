package cn.com.pattern.abstractFactory.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:23
 **/
public class SymbianFactory implements GameAbstractFactory {
    @Override
    public InterfaceController getInterfaceController() {
        return new SymbianInterfaceController();
    }

    @Override
    public OperationController getOperationController() {
        return new SymbianOperationController();
    }
}
