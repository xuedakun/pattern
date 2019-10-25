package cn.com.pattern.command;

/**
 * @Author:xuekun
 * @Description:命令执行者
 * @DateTime:2019/8/14 17:57
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}
