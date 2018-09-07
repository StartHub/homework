package com.dx.dky.other.datastruc;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-06 15:04
 **/
public class LinkedQueue {

    // 定义数据结构
    class Node{
        private Node next;
        public Object value;
    }

    private Node first = null;

    private int number = 0;

    // 往栈中添加一个新的元素
    public void push(Object element){

        if(first == null){
            first = new Node();
            first.value = element;
        }else {
            Node node = new Node();
            node.value = element;
            first.next = node;
        }
        number ++;
    }

    // 移除并返回最近添加的元素
    public Object pop(){

        if(first == null){
            return null;
        }

        Object value = first.value;
        first = first.next;
        number --;
        return value;
    }

    public static void main(String[] args) {

        LinkedQueue stack = new LinkedQueue();
//        stack.init();
//        for(int i = 0; i < 10; i ++){
//            stack.push("Dx" + i);
//        }
        stack.push("zhangsan");
        stack.push("lisi");
        System.out.println(stack.number);
        System.out.println(stack.pop());
        System.out.println(stack.number);

    }
}
