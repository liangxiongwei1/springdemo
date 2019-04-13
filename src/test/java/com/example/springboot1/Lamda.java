package com.example.springboot1;


import io.swagger.models.auth.In;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lamda {
    public static void main(String[] args){
//        Runnable runnable = ()->System.out.println("lamda");
//        runnable.run();
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        Integer[] ints = {};
        for(int i=0;i<10000;i++){
            ints[i] = i;
        }
        Integer[] intlist = {1,3,3,10};
        List<Integer> players = Arrays.asList(ints);
//        players.stream().range(0, 10000).parallel().forEach(p->System.out.println(p));
//        List<Map<String,String>> list = new ArrayList<>();
//        Map<String,String> map = new HashMap<>();
//        map.put("sss","sss1");
//        Map<String,String> map1 = new HashMap<>();
//        map1.put("sss","ss1");
//        list.add(map);
//        list.add(map1);
//        List<Integer> players1 = Arrays.asList(intlist);
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//       for(int i=0;i<10;i++){
//           list1.add(i);
//       }
//       list1.add(662);
//        list1.forEach(p->System.out.println(p));
//       for(int i =0;i<20;i++){
//           list2.add(i);
//       }
//       list2.removeAll(list1);
//        list2.forEach(p->System.out.println(p));
//      StringBuffer stringBuffer = new StringBuffer("");
//
//        stringBuffer.substring(0,stringBuffer.length()-1);
//        atp[0]="test";
//        players.set(0,"test");

//        players.forEach(player->System.out.println(player+","));
//        for(String s:atp){
//            System.out.println(s+",");
//        }
//        Arrays.sort(ints, (Integer s1, Integer s2) -> (s1.compareTo(s2)));
//        Map<Integer,Integer> newPlayers = players.stream().map(p->p+1).collect(Collectors.toMap(p1->p1, p1->p1,(old1, new1)->new1));
//        Map<String,String> newPlayers1  = list.stream().collect(Collectors.toMap(p1->p1.get("sss"),p1->p1.get("sss"),(old1, new1)->new1));
//        newPlayers1.forEach((k,v)->System.out.println(k+"_"+v));
//        newPlayers.stream().forEach(p->System.out.println(p));
//        Predicate<Integer> ageFilter = (p) -> (p > 25 || p<10);
//        players.stream().filter(p -> (p > 25 || p<10)).forEach(p->System.out.println(p+","));
//        for(Integer s:ints){
//            System.out.println(s+",");
//        }

//        Arrays.sort(atp,(String s1,String s2)->(s1.compareTo(s2)));
//        for(String s:atp){
//            System.out.println(s+",");
//        }


//
//        players.parallelStream().forEach((number) -> {
//            try {
//                System.out.println("second:"+number);
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//            }
//        });
//        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
//        forkJoinPool.submit(() -> {
//            players.parallelStream().forEach((number) -> {
//                try {
//                    System.out.println("first:"+number);
//                    Thread.sleep(5);
//                } catch (InterruptedException e) { }
//            });
//        });
//
//        ForkJoinPool forkJoinPool2 = new ForkJoinPool(3);
//        forkJoinPool2.submit(() -> {
//            players.parallelStream().forEach((number) -> {
//                try {
//                    System.out.println("second:"+number);
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                }
//            });
//        });
//        List<Integer> list= players.stream()
//                .filter(p->p<5)
//                .distinct()
//                .collect(Collectors.toList());
//        list.forEach(p->System.out.println(p));
    }
}
