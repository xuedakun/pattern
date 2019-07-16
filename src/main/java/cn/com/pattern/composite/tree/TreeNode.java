package cn.com.pattern.composite.tree;

import java.util.ArrayList;
import java.util.List;
/**
 * 组合模式
 * @author xuekun
 *
 */
public class TreeNode extends Tree {

	private Long id;

	private Long parentId;

	private List<Tree> children;

	private String text;

	private String state;

	private Boolean checked;

	public static class Builder {
		private Long id;

		private Long parentId;

		private List<Tree> children = new ArrayList<Tree>();

		private String text;

		private String state;

		private Boolean checked;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder parentId(Long parentId) {
			this.parentId = parentId;
			return this;
		}

		public Builder children(List<Tree> children) {
			this.children = children;
			return this;
		}

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public Builder state(String state) {
			this.state = state;
			return this;
		}

		public Builder checked(Boolean checked) {
			this.checked = checked;
			return this;
		}

		public Tree build() {
			return new TreeNode(this);
		}
	}

	@Override
	public void add(Tree tree) {
		children.add(tree);
	}

	@Override
	public void remove(Tree tree) {
		children.remove(tree);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(1000);
		sb.append("{id:");
		sb.append(id);
		sb.append(",text:\"");
		sb.append(text);
		sb.append("\",iconCls:");
		sb.append("\"icon-ok\"");
		sb.append(",children:");
		sb.append(children.toString());
		sb.append("}");
		return sb.toString();
	}

	private TreeNode(Builder builder) {
		id = builder.id;
		parentId = builder.parentId;
		children = builder.children;
		text = builder.text;
		state = builder.state;
		checked = builder.checked;
	}

	public Long getId() {
		return id;
	}

	public Long getParentId() {
		return parentId;
	}

	public String getText() {
		return text;
	}

	public String getState() {
		return state;
	}

	public Boolean getChecked() {
		return checked;
	}

	public List<Tree> getChildren() {
		return children;
	}

	@Override
	public void add(Tree[] trees) {
		for (Tree tree : trees) {
			children.add(tree);
		}
	}

	public static void main(String[] args) {
		Tree root = new TreeNode.Builder().text("根节点").build();
		Tree parent1 = new TreeNode.Builder().text("父节点1").build();
		Tree parent2 = new TreeNode.Builder().text("父节点2").build();
		root.add(parent1);
		root.add(parent2);
		Tree son11 = new TreeNode.Builder().text("子节点11").build();
		Tree son12 = new TreeNode.Builder().text("子节点12").build();
		parent1.add(son11);
		parent2.add(son12);
		System.out.println(root.toString());
	}
}
