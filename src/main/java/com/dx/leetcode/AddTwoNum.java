package com.dx.leetcode;

/**
 * @Author dx
 * @Date 2021/1/17 13:17
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNum {

    public static void main(String[] args) {

        // 123
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        // 456
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        invokeAddTwoNum1(node1, node4);
    }

    private static void invokeAddTwoNum1(ListNode l1, ListNode l2) {

        int num1 = getListNodeNum(l1);
        int num2 = getListNodeNum(l2);

        int sum = num1 + num2;
        System.out.println("两数相加之和：" + sum);
        ListNode node = null;
        StringBuilder sb = new StringBuilder("");

        while (sum % 10 > 0) {
            sb.append(sum % 10);

            if (node == null) {
                node = new ListNode(sum % 10);
            } else {
                ListNode listNode = new ListNode(sum % 10);
                ListNode current = null;
                current = node;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = listNode;
            }

            sum = sum / 10;
        }

        System.out.println("数字：" + sb.toString());

        if (node != null){
            StringBuilder nodeStr = new StringBuilder("");
            nodeStr.append(node.val + " -> ");
            while (node.next != null){
                nodeStr.append(node.next.val + " -> ");
                node = node.next;

            }
            System.out.println(nodeStr.toString());
        }

        System.out.println("节点：" + sb.toString());
    }

    private static int getListNodeNum(ListNode node) {

        if (node == null) {
            return 0;
        }

        StringBuilder sb = new StringBuilder("");
        sb.append(node.val);
        while (node.next != null) {
            node = node.next;
            sb.append(node.val);
        }

        return Integer.parseInt(sb.reverse().toString());
    }

}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
