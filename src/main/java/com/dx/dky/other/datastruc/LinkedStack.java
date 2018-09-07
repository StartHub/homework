package com.dx.dky.other.datastruc;

/**
 * 链表实现栈
 *
 * @author : dengxu
 * @create 2018-09-06 9:36
 **/
public class LinkedStack {

    // 定义数据结构
    class Node{
        private Node next;
        public Object value;
    }

    private Node first = null;
    private int number = 0;

    public LinkedStack(){
//        first = new Node();
//        first.next = null;
//        first.value = null;
    }

    // 初始化数据结构
//    void init(){
//        first = new Node();
//        first.next = null;
//        first.value = null;
//    }

    // 往栈中添加一个新的元素
    public void push(Object element){

        if(first == null){
            first = new Node();
            first.value = element;
        }else {
            Node oldFirst = first;
            first = new Node();
            first.value = element;
            first.next = oldFirst;
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

        LinkedStack stack = new LinkedStack();
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
