package cn.com.code151;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author xuekun
 * @create 2018-03-13 16:15
 **/
public class TestJavaScript {
    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        Bindings bindings = engine.createBindings();
        bindings.put("factor", 2);
        engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int f = scanner.nextInt();
            int s = scanner.nextInt();
            System.out.printf("x:%d,y:%d", f, s);
            System.out.println("");
            engine.eval(new FileReader("D:/test.js"));
            if (engine instanceof Invocable) {
                Invocable in = (Invocable) engine;
                double re = (double) in.invokeFunction("test", f, s);
                System.out.println(re);
            }
        }
    }
}
