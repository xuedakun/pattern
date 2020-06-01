package cn.com.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuekun
 * @create 2020-01-08 16:09
 **/
public class ReConstructBinaryTree {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     * @param pre  前位排序的二叉树数组
     * @param preL 左树 index
     * @param preR 右树index
     * @param inL  当前节点在中未排序index
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    public static void main(String[] args) {
        //前序遍历
        Integer[] preorder = {3, 9, 20, 15, 7};
        //中序遍历
        Integer[] inorder = {9, 3, 15, 20, 7};

    }
}
