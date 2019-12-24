package com.dx.dky.other.datastruc;

/**
 * @Descrintion: 单向链表以及操作
 * @Author: dengxu
 * @Date: Created in 23:29 2018/9/18
 */
public class SingleLinkedList {

    // 个数
    private int size;

    // 头结点
    private Node head;

    /**
     * 链表头插入
     *      新节点要插入到原头节点的前面，新节点的next指向原头节点，新节点作为新的头节点
     * @param value
     * @return
     */
    public Object addHead(Object value) {
        System.out.println("add head " + value + "……");
        Node node = new Node(value);
        if (size == 0) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        return value;
    }

    // 链表头删除
    public Object delHead() {
        Object value = head.value;
        head = head.next;
        size--;
        System.out.println("delete head " + value + "……");
        return value;
    }

    // 查找指定元素
    public Node find(Object value) {

        Node current = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (current.value.equals(value)) {
                return current;
            } else {
                current = head.next;
            }
            tempSize--;
        }
        return current;
    }

    // 删除指定元素
    public boolean delete(Object value) {

        if (isEmpty()) {
            return false;
        }

        Node current = head;
        Node preNode = head;
        while (!current.value.equals(value)) {
            if (current.next == null) {
                return false;
            } else {
                preNode = current;
                current = current.next;
            }
        }

        if (current == head) {
            head = current.next;
            size--;
        } else {
            preNode.next = current.next;
            size--;
        }

        return true;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return size >= 0;
    }

    // 显示节点信息
    public void display() {

        System.out.println("show nodes ……");
        if (head != null) {
            Node show = head;
            String flag = "->";
            String l = "[";
            String r = "]";
            StringBuilder sb = new StringBuilder("");
            while (show.next != null) {
                sb.append(l).append(show.value).append(r).append(flag);
                show = show.next;
            }
            sb.append(l).append(show.value).append(r);
            System.out.println(sb.toString());
        }
    }

    // 节点类
    class Node {

        // 数据
        Object value;

        // 下一个引用
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addHead(1);
        list.addHead(2);
        list.addHead(3);
        list.addHead(4);
        list.addHead(5);
        list.display();
        list.delHead();
        list.display();
    }


}
