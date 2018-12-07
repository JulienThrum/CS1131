//Harley Merkaj
//Julien Thrum
//Kai Borah
public class BinarySearchTree<V extends Comparable> {
	private class TreeNode {
		V value = null;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(V value) {
			this.value = value;
		}

		public String toString() {
			return value.toString();
		}
	}

	TreeNode root = null;
	int size = 0;

	public boolean insert(V value) {
		boolean result = false;
		if (root == null) {
			root = new TreeNode(value);
			result = true;
			size++;
		} else {
			if (value.compareTo(root.value) == 0) {
				result = false;
			} else if (value.compareTo(root.value) < 0) {
				if ( root.left == null ) {
					root.left = new TreeNode(value);
					result = true;
					size++;
				}
			} else {
				if ( root.right == null ) {
					root.right = new TreeNode(value);
					result = true;
					size++;
				}
			}
		}
		return result;
	}

	public V delete( V value ) {

		return value;
	}

	public V delete(TreeNode node, V value) {
		TreeNode nextGreat = find(root, value);
		if(nextGreat.right != null) {
			while(nextGreat.left != null) {
				nextGreat = nextGreat.left;
			}
		}
		TreeNode leftRoot = root.left;
		root = nextGreat;
		root.left = leftRoot;
		return value;
	}

	public TreeNode find(TreeNode node, V value) {
		if(node.value == value) {
			return node;
		} else if(node.value.compareTo(value) < 0) {//Go right
			return find(node.right, value);
		} else {
			return find(node.left, value);
		}
	}

	public interface Visitor {
		void visit(BinarySearchTree.TreeNode node);
	}

	public void preorder(TreeNode node, Visitor v) {
		if(node == null) {
			return;
		}
		v.visit(node);
		preorder(node.left, v);
		preorder(node.right, v);
	}

	public void inorder(TreeNode node, Visitor v) {
		if(node == null) {
			return;
		}
		preorder(node.left, v);
		v.visit(node);
		preorder(node.right, v);
	}

	public void postorder(TreeNode node, Visitor v) {
		if(node == null) {
			return;
		}
		preorder(node.left, v);
		preorder(node.right, v);
		v.visit(node);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(0);
		tree.insert(1);
		tree.insert(2);

		tree.inorder(tree.root, e ->{
			System.out.println(e.toString());
		});
	}
}
