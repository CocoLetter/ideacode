package java2;

/**
 * 栈上分配测试
 * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * @author shkstart  shkstart@126.com
 * @create 2020  10:31
 */
public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        // 查看执行时间
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为： " + (end - start) + " ms");
        // 为了方便查看堆内存中对象个数，线程sleep
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    private static void alloc() {
        User user = new User();//未发生逃逸
    }

    static class User {

    }
}

/**
 * -Xmx700m
 * -Djava.awt.headless=true
 * -Djdt.compiler.useSingleThread=true
 * -Dpreload.project.path=C:/IdeaCode/深入理解java虚拟机
 * -Dpreload.config.path=C:/Users/刘晟/.IntelliJIdea2019.3/config/options
 * -Dcompile.parallel=false
 * -Drebuild.on.dependency.change=true
 * -Djava.net.preferIPv4Stack=true
 * -Dio.netty.initialSeedUniquifier=4271851982819679569
 * -Dfile.encoding=GBK
 * -Duser.language=zh
 * -Duser.country=CN
 * -Didea.paths.selector=IntelliJIdea2019.3
 * -Didea.home.path=C:\Program Files\JetBrains\IntelliJ IDEA 2019.3
 * -Didea.config.path=C:\Users\刘晟/.IntelliJIdea2019.3/config
 * -Didea.plugins.path=C:\Users\刘晟/.IntelliJIdea2019.3/config/plugins
 * -Djps.log.dir=C:/Users/刘晟/.IntelliJIdea2019.3/system/log/build-log
 * -Djps.fallback.jdk.home=C:/Program Files/JetBrains/IntelliJ IDEA 2019.3/jbr
 * -Djps.fallback.jdk.version=11.0.4
 * -Dio.netty.noUnsafe=true
 * -Djava.io.tmpdir=C:/Users/刘晟/.IntelliJIdea2019.3/system/compile-server/深入理解java虚拟机_41e36898/_temp_
 * -Djps.backward.ref.index.builder=true
 * -Dkotlin.incremental.compilation=true
 * -Dk
 */
