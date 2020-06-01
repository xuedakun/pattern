package cn.com.algorithm.tree;

/**
 * @author xuekun
 * @create 2020-01-08 16:07
 **/
public class TreeNode {
    //左树
    public TreeNode left;
    //右树
    public TreeNode right;
    //值
    public Integer val;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
