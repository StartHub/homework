package com.dx.dky.other.datastruc;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-11 18:09
 **/
public class BinaryTree {

    private Node root = null;

    BinaryTree(int value){
        root = new Node(value);
        root.leftChild = null;
        root.rightChile = null;
    }

    // todo 插入
    public String insert(int value){
        String error = null;
        Node node = new Node(value);
        if(root == null){
            root = node;
            node.rightChile = null;
            node.leftChild = null;
        }else {
            Node current = root;
            Node parent = null;
            while(true){
                if(value < current.value){
                    parent = current;
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        break;
                    }
                }else if(value > current.value){
                    parent = current;
                    current = current.rightChile;
                    if(current == null){
                        parent.rightChile = node;
                        break;
                    }
                }else {
                    error = "Have same node in current tree!";
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
                return current = current.rightChile;
            }else if(value < current.value){
                return current = current.leftChild;
            }

        }
    }

    // todo 删除
    // todo
    // todo
    // todo
    // todo





    class Node{

        int value;
        Node leftChild;
        Node rightChile;

        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        System.out.println(tree.toString());
        System.out.println(tree.search(5));

    }
}
