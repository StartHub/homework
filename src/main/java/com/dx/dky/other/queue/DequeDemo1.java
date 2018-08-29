package com.dx.dky.other.queue;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-01-18 14:09
 **/
public class DequeDemo1 {

    public static void main(String[] args) {

//        dequeForLinkedList();
//        dequeForArrayDeque();
        dequeForLinkedBlockingDeque();
    }

    private static void dequeForLinkedBlockingDeque() {

        Deque<Integer> deque = new LinkedBlockingDeque<>();

        //队列
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        System.out.println(JSON.toJSONString(deque));
        System.out.println(deque.pollFirst());

        //堆栈
        deque.push(9);
        deque.push(8);
        deque.push(7);
        deque.push(6);
        System.out.println(JSON.toJSONString(deque));
        System.out.println(deque.pop());


    }

    private static void dequeForArrayDeque() {
        Deque<Integer> deque = new ArrayDeque<>(5);

        System.out.println(deque.size());

        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.push(5);
        deque.push(6);
        deque.push(6);
        deque.push(6);
        deque.push(7);

        System.out.println(deque.size());

        System.out.println(JSON.toJSONString(deque));

        deque.removeFirstOccurrence(5);

        System.out.println(JSON.toJSONString(deque));

    }

    private static void dequeForLinkedList() {
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        // 队列
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        System.out.println(JSON.toJSONString(deque));
        System.out.println(deque.peekFirst());
        System.out.println(deque.pollFirst());
        System.out.println("**************************************");

        // 堆栈
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        System.out.println(JSON.toJSONString(deque));
//        System.out.println(deque2.peek());
//        System.out.println(deque2.pop());
    }


}
