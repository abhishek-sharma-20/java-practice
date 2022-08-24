package com.impt.threads;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.List;

public class ThreadPool {
    BlockingQueue<Runnable> taskQueue = null;
    boolean isStopped ;
    List<PoolThreadRunnable> threadRunnableList = new ArrayList<>();
    ThreadPool(int numberOfThreads, int numberOfTasks){
        taskQueue = new ArrayBlockingQueue<>(numberOfTasks);
        for(int i =0;i<numberOfThreads;i++)
            threadRunnableList.add(new PoolThreadRunnable(taskQueue));
        for(PoolThreadRunnable poolThreadRunnable : threadRunnableList)
            new Thread(poolThreadRunnable).start();
    }
    public synchronized void stopAll() throws InterruptedException {
        this.isStopped = true;
        for(PoolThreadRunnable poolThreadRunnable : threadRunnableList)
            poolThreadRunnable.stop();
    }
    public synchronized void execute(Runnable task) throws InterruptedException {
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool is stopped");
        this.taskQueue.offer(task);
    }
    public synchronized void waitUntilAllTasksFinished() {
        while(this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(3,10);
        for(int i = 0;i<12;i++){
            final int taskNo = i;
            threadPool.execute(() -> {
                String message =
                        Thread.currentThread().getName()
                                + ": Task " + taskNo;
                System.out.println(message);
            });
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stopAll();

    }

}
