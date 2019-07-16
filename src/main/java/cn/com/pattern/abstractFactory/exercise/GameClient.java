package cn.com.pattern.abstractFactory.exercise;

/**
 * @author xuekun
 * @create 2019-07-15 15:33
 **/
public class GameClient {
    public static void main(String[] args) {
        GameAbstractFactory factory=new AndroidFactory();
        InterfaceController interfaceController=factory.getInterfaceController();
        OperationController operationController=factory.getOperationController();
        interfaceController.play();
        operationController.play();

    }
}
