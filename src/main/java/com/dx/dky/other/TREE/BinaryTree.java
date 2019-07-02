package com.dx.dky.other.TREE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.System.out;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-07-02 10:07
 **/
public class BinaryTree {

    private Node root = null;

    public BinaryTree(int value){
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    /**
     * todo 插入节点
     * @param value
     */
    public void insert(int value){

        Node node = new Node(value);
        if(root == null){
            root = node;
            root.rightChild = null;
            root.leftChild = null;
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
                    System.out.println("Have same node in current tree!");
                    break;
                }
            }
        }
    }

    /**
     * todo 节点最大值
     * 如果是完全二叉树怎么办？ 完全二叉树子树没有右节点 其左节点是不是该为最大值 ？
     * @return
     */
    public void getMaxValue(){

        if(root == null){
            System.out.println("The current tree node is null");
        }else {
            Node current = root;
            while (current.rightChild != null){
                current = current.rightChild;
            }
            System.out.println("The current tree node MAX value is " + current.value);
        }
    }

    /**
     * todo 节点最小值
     * @return
     */
    public void getMinValue(){

        if(root == null){
            System.out.println("The current tree node is null");
        }else {
            Node current = root;
            while (current.leftChild != null){
                current = current.leftChild;
            }
            System.out.println("The current tree node MIN value is " + current.value);
        }
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

    /**
     * todo 求二叉树的深度
     *      从根节点开始算起，根节点算第一层，自上而下增加，树中节点的最大层次称为树的深度
     * 递归解法：
     *  如果二叉树为空，二叉树的深度为0
     *  否则二叉树的深度 = max(左子树深度， 右子树深度) + 1
     * @param root
     * @return
     */
    public int getTreeDepth(Node root){
        if(root == null){
            return 0;
        }

        int left = getTreeDepth(root.leftChild);
        int right = getTreeDepth(root.rightChild);
        return left > right ? (left + 1) : (right + 1);
    }

    /**
     * 前序遍历
     *  访问根节点，前序遍历左子树，前序遍历右子树
     * @param node
     */
    public void preOrderTraverse(Node root) {
        if(root == null){
            return;
        }
        root.printNode(root);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    /**
     * 中序遍历
     *  遍历左子树，访问根节点，中序遍历右子树
     * @param node
     */
    public void inOrderTraverse(Node root) {
        if(root == null){
            return;
        }
        inOrderTraverse(root.leftChild);
        root.printNode(root);
        inOrderTraverse(root.rightChild);
    }

    /**
     * 后续遍历
     *  后序遍历左子树，后序遍历右子树，访问根节点
     * @param node
     */
    public void postOrderTraverse(Node root) {
        if(root == null){
            return;
        }
        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        root.printNode(root);
    }

    /**
     * todo 按层次遍历
     *  从根节点开始，每层从左至右，从上带下遍历每一个节点
     *  使用一个队列和一个LinkedList
     *      1.取出每一个节点，入队
     *      2.若不为空，则取出头部元素放到LinkedList，若该节点左子树节点不为空，则入队，若该节点右子树不为空，则入队
     *      3.重复2
     */
    public void levelOrderTraverse(){

        Node root = this.root;
        Queue<Node> queue = new LinkedList<>();
        List<Node> list = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            list.add(current);
            if(current.leftChild != null){
                queue.offer(current.leftChild);
            }
            if(current.rightChild != null){
                queue.offer(current.rightChild);
            }
        }

        Iterator<Node> it = list.iterator();
        while (it.hasNext()){
            Node node = it.next();
            System.out.print(node.value + " ");
        }
    }

    /**
     * todo 求二叉树第K层的节点个数
     * 递归解法：
     *  若 树为空或k<1 返回0
     *  若 k==1 返回1
     *  若 k>1 返回左子树中k-1层的节点个数与右子树中k-1层的节点个数之和
     * @param root
     * @param K
     * @return
     */
    public int getKLevelNodeNum(Node root, int k){

        if(root == null){
            return 0;
        }

        if(k == 0){
            return 1;
        }

        int leftNum = getKLevelNodeNum(root.leftChild, k-1);
        int rightNum = getKLevelNodeNum(root.rightChild, k-1);
//        System.out.println(root.leftChild.value, root.rightChild.value);
        return (leftNum + rightNum);
    }






    class Node {

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

        public void printNode(Node node) {
            if(node != null){
                out.println("The current node value is ：" + node.value);
            }
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(30);
        tree.insert(10);
        tree.insert(50);
        tree.insert(8);
        tree.insert(20);
        tree.insert(45);
        tree.insert(2);
        tree.insert(15);
        tree.insert(25);
        tree.insert(40);
        tree.insert(60);
        tree.insert(55);
        tree.insert(53);
        tree.insert(13);
        tree.insert(28);

        tree.getMaxValue();
        tree.getMinValue();
        System.out.println("This tree node num is " + tree.getNodeNum(tree.root));
        System.out.println("This tree node depth is " + tree.getTreeDepth(tree.root));

        System.out.println("**********前序遍历***********");
        tree.preOrderTraverse(tree.root);
        System.out.println("**********中序遍历***********");
        tree.inOrderTraverse(tree.root);
        System.out.println("**********后序遍历***********");
        tree.postOrderTraverse(tree.root);
        System.out.println("**********层次遍历***********");
        tree.levelOrderTraverse();
        System.out.println();
        System.out.println("**********第k层节点个数***********");
        System.out.println(tree.getKLevelNodeNum(tree.root, 0));
        System.out.println(tree.getKLevelNodeNum(tree.root, 1));
        System.out.println(tree.getKLevelNodeNum(tree.root, 2));
        System.out.println(tree.getKLevelNodeNum(tree.root, 3));
        System.out.println(tree.getKLevelNodeNum(tree.root, 4));

    }
}





