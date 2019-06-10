package com.example.springboot1.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liang.xiongwei
 * @Title: BusinessPool
 * @Package com.intellif.cloud.building.services.common.utils
 * @Description
 * @date 2019/4/22 16:16
 */
@Component
public class BusinessPool {

    /**my queue*/
    private List<List<Runnable>> businessQueue = new CopyOnWriteArrayList<>();

    /**work pool*/
    private ThreadPoolExecutor executor;

    private int index = 0 ;

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
        });

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
        while (businessQueue.isEmpty()){
        };
        Runnable r = getCurrentRunnable();
        if(r!=null){
            executor.execute(r);
        }
    }

    /**
     * 获取当前线程
     * @return
     */
    private Runnable getCurrentRunnable(){
        Runnable runnable = null;
        List<Runnable> list;

        while (runnable ==null && !businessQueue.isEmpty()){
            list = businessQueue.get(getCurrentIndex());
            if(list.isEmpty()){
                businessQueue.remove(list);
                index++;
            }else {
                runnable =  list.remove(0);
            }
        }
        index++;
        if(runnable==null){
            index = 0 ;
        }
        return runnable;
    }

    /**
     * 获取当前业务index
     * @return
     */
    private int getCurrentIndex(){
        if(index>=businessQueue.size()){
            index = 0;
        }
        return index;
    }

    public void addWork(List<Runnable> workList){
        businessQueue.add(workList);
    }

    public static void main(String[] args){
        BusinessPool businessPool = new BusinessPool();
        businessPool.initMonitor();


        List<Runnable> list = new ArrayList<>();
        for(int i = 0; i <= 20;i++){
            if( i>0 && i%5 == 0){
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                businessPool.addWork(list);
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
