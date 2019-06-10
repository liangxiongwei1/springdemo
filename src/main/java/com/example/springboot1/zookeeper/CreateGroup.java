package com.example.springboot1.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author liang.xiongwei
 * @version V1.5.0-weixinApp
 * @Title: CreateGroup
 * @Package com.example.springboot1.zookeeper
 * @Description
 * @date 2018/11/20 11:24
 */
public class CreateGroup implements Watcher {
    private static final int SESSION_TIMEOUT = 5000;
    private ZooKeeper zk;
    private CountDownLatch connectedSignal = new CountDownLatch(1);
    public void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        connectedSignal.await();
    }
    @Override
    public void process(WatchedEvent event) { // Watcher interface
        if (event.getState() == Event.KeeperState.SyncConnected) {
            connectedSignal.countDown();
        }
    }
    public void create(String groupName) throws KeeperException,
            InterruptedException {
        String path = "/" + groupName;
        String createdPath = zk.create(path, null/*data*/, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println("Created " + createdPath);
    }
    public void close() throws InterruptedException {
        zk.close();
    }
    public static void main(String[] args) throws Exception {
        CreateGroup createGroup = new CreateGroup();
        createGroup.connect("localhost:2181");
        createGroup.create("test");
        createGroup.close();

    }
}
