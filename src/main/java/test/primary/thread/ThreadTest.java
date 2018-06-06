package test.primary.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.jupiter.api.Test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
class Ticket {

    private Integer tickets = 50;
    Lock lock = new ReentrantLock();

    public void sale() {

        while (this.tickets > 0) {
            try {
                lock.lock();
                Thread.sleep(500);
                log.info(Thread.currentThread().getName() + "正在买第：{}张票，还剩下{}张票", 50 - (--tickets), tickets);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}

// 再次强调，多线程测试不要放在@Test方法中进行测试，再三强调！！！
@Slf4j
public class ThreadTest {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {              // java中的lambda表达式完美解决匿名内部类的书写（编程式接口类型）
            ticket.sale();
        }, "aa").start();

        new Thread(() -> {
            ticket.sale();
        }, "bb").start();

        new Thread(() -> {
            ticket.sale();
        }, "cc").start();
    }

}
