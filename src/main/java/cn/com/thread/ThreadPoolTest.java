package cn.com.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest implements Runnable {
    private  String t;

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public ThreadPoolTest(String t) {
        this.t = t;
    }

    @Override
    public void run() {
        try {
            System.out.println("执行第 "+t+" 个线程");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue =
                new LinkedBlockingQueue<Runnable>(6);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 20, 60, TimeUnit.SECONDS, queue);
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        /**
         * 线程池线程执行顺序  核心线程，大于核心线程+队列长度的线程；队列中的线程最后执行
         */
        for (int i = 0; i < 20; i++) {
            threadPool.execute(
                    new Thread(new ThreadPoolTest(i+""), "Thread".concat(i + "")));
            System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
            if (queue.size() > 0) {
                System.out.println("----------------队列中阻塞的线程数" + queue.size());
            }
        }
        threadPool.shutdown();
    }
    /**
     * D:\tools\Java\jdk1.8.0_111\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.5\lib\idea_rt.jar=56503:C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.5\bin" -Dfile.encoding=UTF-8 -classpath D:\workspace\pattern\target\classes;D:\tools\Java\jdk1.8.0_111\jre\lib\charsets.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\deploy.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\access-bridge-64.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\cldrdata.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\dnsns.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\jaccess.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\jfxrt.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\localedata.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\nashorn.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\sunec.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\sunjce_provider.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\sunmscapi.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\sunpkcs11.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\ext\zipfs.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\javaws.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\jce.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\jfr.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\jfxswt.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\jsse.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\management-agent.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\plugin.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\resources.jar;D:\tools\Java\jdk1.8.0_111\jre\lib\rt.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\poi\poi-ooxml\3.14\poi-ooxml-3.14.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\poi\poi\3.14\poi-3.14.jar;D:\tools\Maven\maven3.2.5\repository\commons-codec\commons-codec\1.10\commons-codec-1.10.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\poi\poi-ooxml-schemas\3.14\poi-ooxml-schemas-3.14.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\xmlbeans\xmlbeans\2.6.0\xmlbeans-2.6.0.jar;D:\tools\Maven\maven3.2.5\repository\stax\stax-api\1.0.1\stax-api-1.0.1.jar;D:\tools\Maven\maven3.2.5\repository\com\github\virtuald\curvesapi\1.03\curvesapi-1.03.jar;D:\tools\Maven\maven3.2.5\repository\joda-time\joda-time\2.9.9\joda-time-2.9.9.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\commons\commons-lang3\3.4\commons-lang3-3.4.jar;D:\tools\Maven\maven3.2.5\repository\net\sourceforge\javacsv\javacsv\2.0\javacsv-2.0.jar;D:\tools\Maven\maven3.2.5\repository\org\springframework\spring-core\5.0.5.RELEASE\spring-core-5.0.5.RELEASE.jar;D:\tools\Maven\maven3.2.5\repository\org\springframework\spring-jcl\5.0.5.RELEASE\spring-jcl-5.0.5.RELEASE.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\kafka\kafka-clients\0.11.0.0\kafka-clients-0.11.0.0.jar;D:\tools\Maven\maven3.2.5\repository\net\jpountz\lz4\lz4\1.3.0\lz4-1.3.0.jar;D:\tools\Maven\maven3.2.5\repository\org\xerial\snappy\snappy-java\1.1.2.6\snappy-java-1.1.2.6.jar;D:\tools\Maven\maven3.2.5\repository\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\kafka\kafka-streams\0.11.0.0\kafka-streams-0.11.0.0.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\kafka\connect-json\0.11.0.0\connect-json-0.11.0.0.jar;D:\tools\Maven\maven3.2.5\repository\org\apache\kafka\connect-api\0.11.0.0\connect-api-0.11.0.0.jar;D:\tools\Maven\maven3.2.5\repository\com\fasterxml\jackson\core\jackson-databind\2.8.5\jackson-databind-2.8.5.jar;D:\tools\Maven\maven3.2.5\repository\com\fasterxml\jackson\core\jackson-annotations\2.8.0\jackson-annotations-2.8.0.jar;D:\tools\Maven\maven3.2.5\repository\com\fasterxml\jackson\core\jackson-core\2.8.5\jackson-core-2.8.5.jar;D:\tools\Maven\maven3.2.5\repository\org\rocksdb\rocksdbjni\5.0.1\rocksdbjni-5.0.1.jar;D:\tools\Maven\maven3.2.5\repository\org\junit\jupiter\junit-jupiter-api\5.5.0-M1\junit-jupiter-api-5.5.0-M1.jar;D:\tools\Maven\maven3.2.5\repository\org\apiguardian\apiguardian-api\1.0.0\apiguardian-api-1.0.0.jar;D:\tools\Maven\maven3.2.5\repository\org\opentest4j\opentest4j\1.1.1\opentest4j-1.1.1.jar;D:\tools\Maven\maven3.2.5\repository\org\junit\platform\junit-platform-commons\1.5.0-M1\junit-platform-commons-1.5.0-M1.jar;D:\tools\Maven\maven3.2.5\repository\org\json\json\20160810\json-20160810.jar cn.com.thread.ThreadPoolTest
     * 线程池中活跃的线程数： 1
     * 线程池中活跃的线程数： 2
     * 线程池中活跃的线程数： 3
     * 线程池中活跃的线程数： 4
     * 线程池中活跃的线程数： 5
     * 线程池中活跃的线程数： 5
     * ----------------队列中阻塞的线程数1
     * 线程池中活跃的线程数： 5
     * ----------------队列中阻塞的线程数2
     * 线程池中活跃的线程数： 5
     * ----------------队列中阻塞的线程数3
     * 线程池中活跃的线程数： 5
     * ----------------队列中阻塞的线程数4
     * 线程池中活跃的线程数： 5
     * ----------------队列中阻塞的线程数5
     * 线程池中活跃的线程数： 5
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 6
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 7
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 8
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 9
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 10
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 11
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 12
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 13
     * ----------------队列中阻塞的线程数6
     * 线程池中活跃的线程数： 14
     * ----------------队列中阻塞的线程数6
     * 执行第 0 个线程
     * 执行第 1 个线程
     * 执行第 2 个线程
     * 执行第 3 个线程
     * 执行第 4 个线程
     * 执行第 11 个线程
     * 执行第 12 个线程
     * 执行第 13 个线程
     * 执行第 14 个线程
     * 执行第 15 个线程
     * 执行第 16 个线程
     * 执行第 17 个线程
     * 执行第 18 个线程
     * 执行第 19 个线程
     * 执行第 5 个线程
     * 执行第 6 个线程
     * 执行第 7 个线程
     * 执行第 8 个线程
     * 执行第 9 个线程
     * 执行第 10 个线程
     *
     * Process finished with exit code 0
     */
}
