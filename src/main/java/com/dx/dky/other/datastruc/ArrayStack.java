package com.dx.dky.other.datastruc;

/**
 * 数组实现栈
 *
 * @author : dengxu
 * @create 2018-09-06 11:06
 **/
public class ArrayStack {

    Object[] data;

    int length;

    int top;

    public ArrayStack(int length) {
        this.length = length;
        data = new Object[length];
        top = -1;
    }

    // 栈长度
    public int getLength() {
        return length;
    }

    // 栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    // 栈是否满栈
    public boolean isFull() {
        return top + 1 == length;
    }

    // 入栈
    public boolean push(Object element) {
        if (isFull()) {
            System.out.println("当前栈已经满了！！！");
            return false;
        }
        this.data[++top] = element;
        return true;
    }

    // 出栈
    public Object pop(){
        if(isEmpty()){
            System.out.println("当前栈已经空了！！！");
            return false;
        }
        return this.data[top--];
    }

    // 栈顶元素
    public Object peek(){
        return this.data[top];
    }

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);
        stack.push("a");
        stack.push(1);
        stack.push("wuwang");

        System.out.println("栈顶元素===>" + stack.peek());
        while (stack.top >= 0){
            System.out.println("出栈元素===>" + stack.pop());
        }

    }


}
