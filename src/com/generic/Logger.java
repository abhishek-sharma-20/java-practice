package com.generic;

public class Logger {
    private static Logger logger = null;
    private static int count = 0;
    private Logger(){
        count++;
    }

    public void printLog(String message){
        System.out.println(message +" by com.hw.Logger "+count);
    }

    public static Logger getLogger(){
        if(logger == null) {
            logger = new Logger();
        }
            return logger;

    }
    public static void main(String[] args) throws InterruptedException {

        for(int i =0;i<5;i++) {
            Thread thread = new Thread(() ->Logger.getLogger().printLog("Hello Word"));
            thread.start();
            thread.join();
        }

    }

}

