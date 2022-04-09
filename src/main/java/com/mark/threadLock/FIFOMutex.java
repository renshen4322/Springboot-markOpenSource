package com.mark.threadLock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * ClassName:FIFOMutex
 * Package:com.mark.springbootmarkopensource.threadLock
 * Description:
 *先进先出的锁
 * @Date:2021/5/29 0029 9:08
 * @Author: mark
 */
public class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean((false));
    private final Queue<Thread> waiters = new ConcurrentLinkedDeque<Thread>();
    public void lock(){
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);
        // 只有队首的线程可以获取锁(1)
        while (waiters.peek() != current || !locked.compareAndSet(false, true)){
            LockSupport.park(this);
            if (Thread.interrupted()){ // (2)
                wasInterrupted = true;
            }
        }
        waiters.remove();
        if (wasInterrupted){ // (3)
            current.interrupt();
        }
    }
    public void unlock(){
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}
