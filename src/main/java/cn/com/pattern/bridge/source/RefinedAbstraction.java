package cn.com.pattern.bridge.source;
public class RefinedAbstraction extends Abstraction {
    
    public RefinedAbstraction(Implementor impl) {
        super(impl);
    }
    //其他的操作方法
    public void otherOperation(){
        
    }
}