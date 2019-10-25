package cn.com.pattern.command;

/**
 * @Author:xuekun
 * @Description:具体命令类
 * @DateTime:2019/8/14 17:57
 */
public class ConcreteCommand extends Command {
    private Receiver receiver;

    @Override
    public void execute() {
        System.out.println("触发命令");
        receiver.action();
    }

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
