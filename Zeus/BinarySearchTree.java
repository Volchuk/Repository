
public class BinarySearchTree {

	public class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {
		}
		public TreeNode(int info) {
			this.data = info;
			this.right = null;
			this.left = null;
		}
	}
	
	TreeNode root;
	int n = 0;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public boolean treeIsEmpty(){
		return root == null;
	}
	
	public TreeNode insert(int key){
		TreeNode insertPoint = null;
		TreeNode temp = root;
		//boolean turnRight = false;
		while (temp != null) {
			if (temp.data == key) {
				throw new IllegalArgumentException();
				}
			insertPoint = temp;
			temp = temp.data < key ? temp.right : temp.left;
		}
		TreeNode newNode = new TreeNode(key);
		if (root == null) {
			root = newNode;
			// System.out.println("root = null"+newNode.data);
			return root;
		}
		// System.out.println("root data = "+root.data);
		// System.out.println("insert point"+insertPoint.data);
		if (insertPoint.data < key) {
			insertPoint.right = newNode;
		} else {
			insertPoint.left = newNode;
		}
		n++;
		// System.out.println("new node data "+newNode.data);
		return root;
	}
	
	public TreeNode delete(int key){
		TreeNode parent = null;
		TreeNode x = root;
		// if tree is empty
		if (root == null) {
			return null;
		}
		// searching for such key in tree
		// System.out.println(key);
		while (x != null) {
			if (x.data == key ) {
				break;
				}
			// System.out.println(x.data);
			parent = x;
			x = (x.data > key) ? x.left : x.right;
		}
		// if node with such key does not exist
		if (x == null) {
			throw new IllegalArgumentException();
		}
		
			// node has 2 children
		if ( x.right != null &&
				x.left != null ) { 
				TreeNode swap = x.left;
				TreeNode prev = x;
				while (swap.right != null) {
					prev = swap;
					swap = swap.right;
				}
				x.data = swap.data;
				x = swap;
				if ( swap.right != null ||
						swap.left != null ) {
					if (x == prev.right) {
						prev.right = swap.right != null ? swap.right :swap.left;
						}
					if (swap == prev.left) {
						
						prev.left = swap.right != null ? swap.right : swap.left;
						}
					n--;
					return root;
					}
			}
		
			// node has 1 child or none
			if ( x.right == null ||
					x.left == null ) {
				if (parent == null) {
					n--;
					root = x.left != null ? x.left : x.right;
					return root;
				}
				if (x == parent.right) {
					parent.right = x.right != null ? x.right :x.left;
					}
				if (x == parent.left) {
					parent.left = x.right != null ? x.right : x.left;
					}
				n--;
				return root;
				}
			return null;
		}

	public TreeNode search(int key){
		TreeNode temp = root;
		while (temp != null)
		if (temp.data == key) {
			return temp;
		} else if (temp.data < key){
			temp = temp.right;
		} else	if (temp.data > key) {
			temp = temp.left;
		} 
		return temp;
	}

		public CharSequence preOrderTraversal(TreeNode root, CharSequence str){
			str = str + Integer.toString(root.data);
			if ( root.left == null && root.right == null) {
				return str;
			}
			if (root.left != null)
				{ str = preOrderTraversal(root.left, str); }
			if (root.right != null)
				{ str = preOrderTraversal(root.right, str); }
			return str;
		}
		
		public static boolean checkIfSubtree(BinarySearchTree tree, BinarySearchTree newTree){
			String s1 =  tree.preOrderTraversal(tree.root, "").toString();
			CharSequence s2 = newTree.preOrderTraversal(newTree.root, "");
			System.out.println(s1+"\n"+s2);
			return s1.contains(s2);
		}

		
	public static void main(String[] args){
	
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(12);
		tree.insert(10);
		tree.insert(9);
		tree.insert(15);
		tree.insert(16);
		tree.insert(13);
		tree.insert(14);

		BinarySearchTree newTree = new BinarySearchTree();
		newTree.insert(13);
		newTree.insert(14);

		System.out.println("Is it true that 'tree' contains subtree 'newTree'? "+checkIfSubtree(tree, newTree));
	}
}