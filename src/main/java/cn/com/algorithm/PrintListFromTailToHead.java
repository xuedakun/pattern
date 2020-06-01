package cn.com.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author xuekun
 * @create 2020-01-07 16:46
 **/
public class PrintListFromTailToHead {

    public  ArrayList<Integer> printListFromTailToHead1(ListNode<Integer> listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead1(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * 头插法
     *
     * @param listNode
     * @return
     */
    public  ArrayList<Integer> printListFromTailToHead2(ListNode<Integer> listNode) {
        ListNode<Integer> head = null;
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head;
            head = listNode;
            listNode = memo;
//            head.next = listNode;
//            listNode.next = head.next;
//            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    /**
     * 使用栈的后进先出的特点
     *
     * @param listNode
     * @return
     */
    public  ArrayList<Integer> printListFromTailToHead3(ListNode<Integer> listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, null);
        listNode = listNode.build(2).build(3).build(4);
        ListNode listNode2=listNode;
        ListNode listNode3= new ListNode(1, null).build(2).build(3).build(4);
        PrintListFromTailToHead printListFromTailToHead =new PrintListFromTailToHead();
        ArrayList<Integer> ret = printListFromTailToHead.printListFromTailToHead1(listNode);
        ArrayList<Integer> ret2 = printListFromTailToHead.printListFromTailToHead2(listNode2);
         ArrayList<Integer> ret3 = printListFromTailToHead.printListFromTailToHead3(listNode3);
        for (Integer i : ret) {
            System.out.print(i+",");

        }
        System.out.println();
        for (Integer i : ret2) {
            System.out.print(i + ",");
          //  System.out.println();
        }
        System.out.println();
        for (Integer i : ret3) {
            System.out.print(i + ",");
          //  System.out.println();
        }
        System.out.println();
    }
}
