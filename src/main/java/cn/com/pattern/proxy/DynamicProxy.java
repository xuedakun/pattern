package cn.com.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

//抽象角色：java动态代理的实现目前只支持接口，不支持抽象类
interface BusinessFoo {
	void foo();
	void foo2();
}

interface BusinessBar {
	String bar(String message);
}

// 真实角色：真正实现业务逻辑方法
class BusinessFooImpl implements BusinessFoo {
	public void foo() {
		System.out.println("BusinessFooImpl.foo()");
	}
	public void foo2() {
		System.out.println("BusinessFooImpl.foo2()");
	}
}

class BusinessBarImpl implements BusinessBar {
	public String bar(String message) {
		System.out.println("BusinessBarImpl.bar()");
		return message;
	}
}

// 动态角色：动态生成代理类
class BusinessImplProxy implements InvocationHandler {
	private Object obj;

	BusinessImplProxy() {
	}

	BusinessImplProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		doBefore();
		result = method.invoke(obj, args);
		doAfter();
		return result;
	}

	public void doBefore() {
		System.out.println("do something before Business Logic");
	}

	public void doAfter() {
		System.out.println("do something after Business Logic");
	}

	public static Object factory(Object obj) {
		Class<? extends Object> cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new BusinessImplProxy(obj));
	}
}
 
// 测试类
public class DynamicProxy {
	public static void main(String[] args) throws Throwable {
		BusinessFooImpl bfoo = new BusinessFooImpl();
		BusinessFoo bf = (BusinessFoo) BusinessImplProxy.factory(bfoo);
		bf.foo();
		bf.foo2();
		System.out.println();
		BusinessBarImpl bbar = new BusinessBarImpl();
		BusinessBar bb = (BusinessBar) BusinessImplProxy.factory(bbar);
		String message = bb.bar("Hello,World");
		System.out.println(message);
	}
}