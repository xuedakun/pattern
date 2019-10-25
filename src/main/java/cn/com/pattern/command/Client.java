package cn.com.pattern.command;

public class Client {
    public static void main(String[] args) {
       Invoker invoker=new Invoker(new ConcreteCommand(new Receiver()));
        invoker.call();
    }

}
