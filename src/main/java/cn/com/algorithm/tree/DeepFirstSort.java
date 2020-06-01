package cn.com.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 深度优先遍历
 */
public class DeepFirstSort {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        head.right = three;
        head.left = second;
        second.right = five;
        second.left = four;
        three.right = seven;
        three.left = six;
        System.out.print("广度优先遍历结果：");
        new DeepFirstSort().BroadFirstSearch(head);
        System.out.println();
        System.out.print("深度优先遍历结果：");
        new DeepFirstSort().depthFirstSearch(head);
    }

    /**
     * 广度优先遍历是使用队列实现的
     * 层序遍历
     * @param nodeHead
     */
    public void BroadFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null) {
            return;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(nodeHead);
        while (!myQueue.isEmpty()) {
            TreeNode node = myQueue.poll();
            System.out.print(node.val + " ");
            if (null != node.left) {
                //深度优先遍历，我们在这里采用每一行从左到右遍历
                myQueue.add(node.left);
            }
            if (null != node.right) {
                myQueue.add(node.right);
            }

        }
    }

    /**
     *   深度优先遍历
     */

    public void depthFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null) {
            return;
        }
        Stack<TreeNode> myStack = new Stack<>();
        myStack.add(nodeHead);
        while (!myStack.isEmpty()) {
            //弹出栈顶元素
            TreeNode node = myStack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
                myStack.push(node.right);
            }
            if (node.left != null) {
                myStack.push(node.left);
            }
        }

    }

}
