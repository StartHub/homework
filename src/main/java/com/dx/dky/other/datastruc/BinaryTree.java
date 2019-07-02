package com.dx.dky.other.datastruc;

import static java.lang.System.*;

/**
 * 二叉查找树
 *
 * @author : dengxu
 * @create 2018-09-11 18:09
 **/
public class BinaryTree {

    private Node root = null;

    BinaryTree(int value){
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    // todo 插入
    public String insert(int value){
        String error = null;
        Node node = new Node(value);
        if(root == null){
            root = node;
            node.rightChild = null;
            node.leftChild = null;
        }else {
            Node current = root;
            Node parent = null;
            while(true){
                parent = current;
                if(value < current.value){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        break;
                    }
                }else if(value > current.value){
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        break;
                    }
                }else {
                    error = "Have same node in current tree!";
                    break;
                }
            }
        }
        return error;
    }

    // todo 查询
    public Node search(int value){

        Node current = root;
        while (true){
            if(current == null){
                return null;
            }

            if(value == current.value){
                return current;
            }else if(value > current.value){
                return current = current.rightChild;
            }else if(value < current.value){
                return current = current.leftChild;
            }

        }
    }

    // todo 删除
    public boolean delete(int value) {
        Node current = root;    //需要删除的节点
        Node parent = null;     //需要删除的节点的父节点
        boolean isLeftChild = true;   //需要删除的节点是否父节点的左子树

        if(current == null){

        }

        while (true){
            if(value == current.value){
                break;
            }else if(value < current.value){
                isLeftChild = true;
                parent = current;
                current = current.leftChild;
            }else {
                isLeftChild = false;
                parent = current;
                current = current.rightChild;
            }
        }

        return true;
    }

    /**
     *   todo 中序遍历(递归)
     *   1、调用自身来遍历节点的左子树
     *   2、访问这个节点
     *   3、调用自身来遍历节点的右子树
     */
    public void inOrderTraverse(Node node) {
        if(node == null){
            return;
        }
        inOrderTraverse(node.leftChild);
        node.printNode(node);
        inOrderTraverse(node.rightChild);
    }

    /**
     * todo 前序遍历
     *    1、访问这个节点
     *    2、调用自身来遍历节点的左子树
     *    3、调用自身来遍历节点的右子树
     */
    public void preOrderTraverse(Node node) {
        if(node == null){
            return;
        }
        node.printNode(node);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * todo 后序遍历
     *    1、调用自身来遍历节点的左子树
     *    2、调用自身来遍历节点的右子树
     *    3、访问这个节点
     */
    public void postOrderTraverse(Node node) {
        if(node == null){
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        node.printNode(node);
    }

    /**
     * todo 求二叉树中节点个数
     * 递归解法：
     *  如果二叉树为空，节点个数为0
     *  否则节点个数 = 左子树节点个数 + 右子树节点个数 + 1
     * @param root
     * @return
     */
    public int getNodeNum(Node root){
        if(root == null){
            return 0;
        }
        return getNodeNum(root.leftChild) + getNodeNum(root.rightChild) + 1;
    }

    // todo
    // todo

    class Node{
        int value;
        Node leftChild;
        Node rightChild;

        public Node(){
            super();
        }

        public Node(int value){
            super();
            this.value = value;
        }

        public Node(int value, Node leftChild, Node rightChild){
            super();
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public void printNode(Node node){
            if(node != null){
                out.println("当前节点value：" + node.value);
            }
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(30);
        tree.insert(10);
        tree.insert(20);
        tree.insert(40);
        tree.insert(25);
        tree.insert(45);
        tree.insert(15);
        tree.insert(50);
        tree.insert(60);

        System.out.println("中序遍历：");
        tree.inOrderTraverse(tree.root);
        System.out.println("前序遍历：");
        tree.preOrderTraverse(tree.root);
        System.out.println("后序遍历：");
        tree.postOrderTraverse(tree.root);

//        System.out.println(tree.toString());
//        System.out.println(tree.search(3));


        System.out.println("*********节点个数******");
        tree.getNodeNum(tree.root);





//        String avg = "abcdefghijklmnopqrstuvwxyz";
//        char[] avv = avg.toCharArray();
//        int start = 0;
//        int end = avv.length - 1;
//        while(true){
//            if(end > start){
//                char temp;
//                temp = avv[start];
//                avv[start] = avv[end];
//                avv[end] = temp;
//                start++;
//                end--;
//            }else {
//
//                break;
//            }
//        }
//        System.out.println(avg);
//        System.out.println(String.valueOf(avv));
    }
}
