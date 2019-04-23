package com.example.springboot1.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liang.xiongwei
 * @Title: BusinessPool
 * @Package com.intellif.cloud.building.services.common.utils
 * @Description 空转时，让出cpu资源
 * @date 2019/4/22 16:16
 */
@Component
public class BusinessBlockPool {

    /**my queue*/
    private LinkedBlockingQueue<List<Runnable>> businessQueue = new LinkedBlockingQueue<>();

    /**work pool*/
    private ThreadPoolExecutor executor;

    private int poolSize = 2;

    @PostConstruct
    void initMonitor(){
        executor = new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                if (!executor.isShutdown()) {
                    while (executor.getQueue().remainingCapacity() == 0){};
                    executor.execute(r);

                }
            }
        }
        );

        new Thread(()->{
            while (true){
                monitorQueue();
            }
        }).start();
    }


    /**
     * 监听队列
     */
    private void monitorQueue(){
        List<Runnable> list;
        try {
            while ((list = businessQueue.take()).isEmpty() && executor.getQueue().remainingCapacity() == 0){
            }
            Runnable r = getCurrentRunnable(list);
            if(r!=null){
                executor.execute(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取当前线程
     * @return
     */
    private Runnable getCurrentRunnable(List<Runnable> list) throws Exception{
        Runnable runnable = null;
        if(!list.isEmpty()){
            runnable = list.remove(0);
            if(!list.isEmpty()){
                businessQueue.put(list);
            }
        }
        return runnable;
    }


    public void addWork(List<Runnable> workList){
        try {
            businessQueue.put(workList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        BusinessBlockPool businessPool = new BusinessBlockPool();
        businessPool.initMonitor();


        List<Runnable> list = new ArrayList<>();
        for(int i = 0; i <= 20;i++){
            if( i>0 && i%5 == 0){

                businessPool.addWork(list);
                list = new ArrayList<>();
            }

            final String threadName  = "thread————"+(i/5)+"num————"+(i%5);
            list.add(()->{
                System.out.println(threadName);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
