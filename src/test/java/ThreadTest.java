import com.springtestlzc.dtos.CountCownLatchThread;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ThreadTest {

    @Test
    public void threadFiveTest() {
        Thread threadX = new Thread(new Runnable() {
            CountDownLatch latch = new CountDownLatch(2);

            public void run() {
                System.out.println("主线程需要等待子线程执行完成后再执行");
                Thread threadA = new Thread(new CountCownLatchThread("A", latch));
                Thread threadB = new Thread(new CountCownLatchThread("B", latch));
                threadA.start();
                threadB.start();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行完成了，主线程继续执行");
            }
        });
        //启动主线程X
        threadX.start();
    }
}
