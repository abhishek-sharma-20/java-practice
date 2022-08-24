package com.impt.threads;

import java.util.concurrent.BlockingQueue;

class PoolThreadRunnable implements Runnable {

    BlockingQueue<Runnable> taskQueue = null;
    Thread thread = null;
    Boolean isStopped = false;
    PoolThreadRunnable(BlockingQueue<Runnable> taskQueue){
        this.taskQueue=taskQueue;
    }

    public void stop(){
        this.isStopped=true;
        this.thread.interrupt();
    }
    public void run() {
        this.thread = Thread.currentThread();
        while(!isStopped) {
            try {
                Runnable runnable = taskQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        }
    }
}
