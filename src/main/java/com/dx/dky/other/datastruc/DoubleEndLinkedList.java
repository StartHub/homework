package com.dx.dky.other.datastruc;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-19 19:01
 **/
public class DoubleEndLinkedList extends AbstractDataStrucMethod{

    private int size;

    private Node head;

    private Node tail;

    DoubleEndLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    boolean addHead(Object data) {
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
            size ++;
        }else {
            node.next = head;
            head = node;
            size ++;
        }

        return true;
    }

    @Override
    boolean addTail(Object data) {
        Node node = new Node(data);
        if(tail == null){
            tail = node;
            head = node;
        }else {
            tail.next = node;
            tail = node;
        }
        size ++;

        return true;
    }

    @Override
    boolean delHead() {

        if(head.next == null){

        }else {
            head = head.next;
        }
        size --;

        return false;
    }

    @Override
    boolean delTail() {
        return false;
    }


    class Node{
        Object value;
        Node next;

        Node(Object data){
            this.value = data;
        }
    }
}
