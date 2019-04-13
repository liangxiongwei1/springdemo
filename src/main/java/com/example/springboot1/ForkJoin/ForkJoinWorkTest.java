package com.example.springboot1.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

public class ForkJoinWorkTest {
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture =  pool.submit(new ForkJoinWork(1,1001));
        try {
            Integer result = taskFuture.get();
            System.out.println("result = " + result);
            pool.awaitTermination(2, TimeUnit.SECONDS);
            pool.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }


    }
}
