package test.primary.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.hamcrest.CoreMatchers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ShareNumber {

    private Integer num = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            // 不满足条件就睡眠（while循环有效避免虚假唤醒）
            while (num != 0) {
                condition.await();
            }
            // 满足条件就执行，并唤醒
            log.info(Thread.currentThread().getName() + "执行了加操作，num={}", ++num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            log.info(Thread.currentThread().getName() + "执行了减法操作，num={}", --num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class ThreadCommunicateTest {

    public static void main(String[] args) {
        ShareNumber shareNumber = new ShareNumber();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                shareNumber.increment();
            }

        }, "aa").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                shareNumber.decrement();
            }
        }, "bb").start();
        
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                shareNumber.increment();
            }
        }, "cc").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                shareNumber.decrement();
            }
        }, "dd").start();

    }
}
