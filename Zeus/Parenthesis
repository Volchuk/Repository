import java.util.Scanner;

public class Parenthesis {
	
	public Node root;
	public int variations, N;
	
	public Parenthesis (int n) {
		variations = 0;
		N = n;
		buildTree();
		System.out.println("Number of variations is "+ variations);
	}
	
	public class Node{
		Node left, right, next;
		int countLeft, countRight;
		StringBuffer expression = new StringBuffer("");

		public Node(int countL, int countR, String exp){
			this.countLeft = countL;
			this.countRight = countR;
			this.expression = expression.append(exp);;
			this.left = null;
			this.right = null;
			}
	}
	
	public Node buildTree() {
		Stack stack = new Stack();
		Node current = new Node(1, 0, "(");
		root = current;
		stack.addToStack(current);
		//System.out.println("Current.countLeft is "+ current.countLeft);
		//System.out.println("Current.countRight is "+ current.countRight);
		while (! stack.isEmpty()){
			addNode(current, stack);
		}
		return root;
	}
	
	public void addNode(Node current, Stack stack) {
		if(current.left == null && current.countLeft < N) {
			//System.out.println("took left");
			current.left = new Node (current.countLeft+1, current.countRight, current.expression + "(");
			current = current.left;
			stack.addToStack(current);
			//System.out.println("in addNode() Current.countLeft is "+ current.countLeft + "Current.countRight is "+ current.countRight);
			addNode(current, stack);
		}
		if (current.right == null && current.countRight < current.countLeft) {
			//System.out.println("took right");
			current.right = new Node(current.countLeft, current.countRight+1, current.expression + ")");
			current = current.right;
			stack.addToStack(current);
			//System.out.println("in addNode() Current.countLeft is "+ current.countLeft + "Current.countRight is "+ current.countRight);
			if (current.countRight < N) {
				addNode(current, stack);
			}
		}
		if (current.countRight == N) {
			variations++;
			System.out.println(current.expression);
		}
		stack.removeFromStack();
		current = stack.first;
		return;
	}
	
	public class Stack{
		
		public Node first;
		
		public Stack(){
			first = null;
		}
		
		public void addToStack(Node node){
			node.next = first;
			first = node;
		}
		
		public void removeFromStack(){
			first = first.next;
		}
		
		public boolean isEmpty(){
			return first == null;
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number N ");
		int n = sc.nextInt();
		sc.close();
		Parenthesis par = new Parenthesis(n);
	}

}
