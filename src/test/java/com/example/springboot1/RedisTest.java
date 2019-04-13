package com.example.springboot1;

import com.example.springboot1.config.RedisClient;
import com.example.springboot1.config.RedisConfig;
import com.example.springboot1.util.RedisQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
@Autowired
    RedisQuery redisQuery;
@Autowired
    RedisClient redisClient;
    @Test
    public void test() throws Exception {
        redisTemplate.opsForValue().get("vanruiSocketTime");
//        Map<String,Object> param  = new HashMap<>();
//        param.put("name","name111");
//        param.put("password",22);
//        redisTemplate.opsForValue().multiSet(param);
//        for(int i=0;i<300;i++){
//            Runnable runnable = ()-> {redisTemplate.opsForValue().increment("password",-1.01d); System.out.println("redisTest"+redisTemplate.opsForValue().get("password").toString());};
//            runnable.run();
//        }


//        redisTemplate.opsForList().rightPush("list",11);
//        redisTemplate.opsForList().rightPush("list",22);
//        redisTemplate.opsForList().rightPush("list",44);
//       List<Integer> list =  redisTemplate.opsForList().range("list",0,-1);
//       list.forEach(p->System.out.println(p));

//         Runnable runnable = ()-> {
//           while(true){
//               String t = redisTemplate.opsForList().leftPop("list").toString();
//               System.out.println("接收数据："+t);
//           }
//         };
//         runnable.run();

//        redisTemplate.opsForHash().put("redisHash","one","one");
//          redisTemplate.opsForSet().add("two","abb","aa");
//          Set<String> set1 =redisTemplate.opsForSet().union("one","two");
//          System.out.println(redisTemplate.opsForSet().isMember("one","aa"));
//          set1.forEach(p->System.out.println(p));
//        redisTemplate.opsForHyperLogLog().add("count","one","two","three");
//        redisTemplate.opsForHyperLogLog().size("count");
//        redisTemplate.multi();
//        redisTemplate.opsForValue().get("test").toString();
//        redisTemplate.opsForValue().set("test","gg");
//        redisTemplate.executePipelined()
//        redisTemplate.exec();


        //execute a transaction
//        List<Object> txResults = (List<Object>) redisTemplate.execute(new SessionCallback<List<Object>>() {
//            public List<Object> execute(RedisOperations operations) throws DataAccessException {
//                operations.multi();
//                operations.opsForSet().add("key", "value1");
//
//                // This will contain the results of all ops in the transaction
//                return operations.exec();
//            }
//        });
//        System.out.println("Number of items added to set: " + txResults.get(0));
//        redisQuery.insertData();
//        redisQuery.query();
//        long time = System.currentTimeMillis();
//        Cursor<ZSetOperations.TypedTuple<Object>> cursor = redisTemplate.opsForZSet().scan("redisQuery", ScanOptions.NONE);
//        while (cursor.hasNext()){
//            ZSetOperations.TypedTuple<Object> item = cursor.next();
//        }
//        System.out.println(System.currentTimeMillis()-time);
//        long time1 = System.currentTimeMillis();
//        Set<Integer> set = redisTemplate.opsForZSet().range("redisQuery",0,-1);
//        set.forEach(p->{});
//        System.out.println(System.currentTimeMillis()-time1);
//        Map<String,Object> param  = new HashMap<>();
//        param.put("name","name111");
//        param.put("password",22);
//        Map<String,Object> param1  = new HashMap<>();
//        param1.put("name","name11111");
//        param1.put("password",221);
//        redisTemplate.opsForZSet().add("aaa",param,1);
//        redisTemplate.opsForZSet().add("aaa",param1,2);
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Map<String,Object> map = new HashMap<>(5);
//        map.put("personId",8532);
//        map.put("cameraIds","108");
//        map.put("startTime","2018-11-11 09:55");
//        map.put("endTime","2018-11-11 09:55");
//        map.put("id",1);
//       redisTemplate.opsForZSet().add("cache", map,sf.parse(String.valueOf(map.get("startTime"))).getTime()/(1000*60));
//        redisTemplate.opsForZSet().remove("cache",map);
//        Set<Map<String,Object>> set = redisTemplate.opsForZSet().range("aaa",0,3);
//        set.forEach(p->{
//            System.out.println(p.get("password").toString());
//            if(221 == Long.valueOf(p.get("password").toString())){
//                redisTemplate.opsForZSet().remove("aaa",p);
//            }
//        });

//        long time = System.currentTimeMillis();
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        stringRedisTemplate.opsForValue().get("cronsssss");

//        System.out.println("开始");
//        int count=0;
//        Cursor<Object> cursor = null;
//        for (int i =0;i<9;i++){
////                redisTemplate.opsForSet().members("Dnake_accessList");
//            try {
//              cursor = redisTemplate.opsForSet().scan("Dnake_accessList", ScanOptions.NONE);
//
//                while(cursor.hasNext()){
//                    String id = cursor.next().toString();
//                    System.out.println(count++);
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally {
//
//            }

        }
//        Runnable runnable = ()->{
//            for (int i =0;i<10;i++){
////                redisTemplate.opsForSet().members("Dnake_accessList");
//                Cursor<Object> cursor = redisTemplate.opsForSet().scan("Dnake_accessList", ScanOptions.NONE);
//                while(cursor.hasNext()){
//                    String id = cursor.next().toString();
//                    System.out.println(id);
//                }
//
//            }
//        };
//
//       runnable.run();
//        System.out.println("结束");
//        redisTemplate.opsForValue().set("aaaa",1);
//        System.out.println("结束");


}
