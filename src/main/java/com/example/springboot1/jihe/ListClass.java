package com.example.springboot1.jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: ListClass
 * @Package com.example.springboot1.jihe
 * @Description
 * @date 2018/10/15 14:03
 */
public class ListClass {
    public static void main(String[] args){
        ArrayList<Integer> list  = new ArrayList<>();
        for(int i = 0 ; i < 9 ; i ++){
            list.add(i);
            list.add(i);
        }
        list.forEach(p-> System.out.println(p));
        list = (ArrayList<Integer>) list.stream().distinct().collect(Collectors.toList());
//
//        Iterator<Integer> iterator = list.iterator();
//        int i = 0 ;
//        while(iterator.hasNext()) {
//            if (i == 3) {
//                iterator.remove();
//            }
//            System.out.println(iterator.next());
//            System.out.println("///"+list.size());
//
//            i ++;
//        }
//        System.out.println(list.size());

//


//        list.stream().forEach(System.out::println);
        list.forEach(p-> System.out.println(p));

        //LinkedList
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int j = 0; j< 9 ; j++){
//            linkedList.add(j);
//        }
//        int j = 0 ;
//        Iterator<Integer> iterator1 = linkedList.listIterator();
//        while (iterator1.hasNext()){
//            if (j == 3) {
//                iterator1.remove();
//            }
//            System.out.println(iterator1.next());
//            System.out.println("//"+linkedList.size());
//            j ++;
//        }
//        linkedList.add(8,10);
//        linkedList.stream().forEach(System.out::println);

    }
}
