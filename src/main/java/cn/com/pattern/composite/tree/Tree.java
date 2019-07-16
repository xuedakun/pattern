package cn.com.pattern.composite.tree;

public abstract class Tree {

	/**
	 * 添加一个树节点
	 * 
	 * @param tree
	 */
	public abstract void add(Tree tree);

	/**
	 * 批量添加树节点
	 * 
	 * @param trees
	 */
	public abstract void add(Tree[] trees);

	/**
	 * 移除一个树节点
	 * 
	 * @param tree
	 */
	public abstract void remove(Tree tree);

}
