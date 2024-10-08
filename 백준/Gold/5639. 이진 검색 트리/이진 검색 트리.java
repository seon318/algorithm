import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
		
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		void insert(int n) {
			if (n < this.data) {
				if (this.left == null) this.left = new Node(n);
				else this.left.insert(n);
			} else {
				if (this.right == null) this.right = new Node(n);
				else this.right.insert(n);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Node root = new Node(Integer.parseInt(br.readLine()));
		while (true) {
			input = br.readLine();
			if (input == null || input.equals("")) break;
			root.insert(Integer.parseInt(input));
		}; 
		
		print(root);
		System.out.println(sb);
	}
	
	static void print(Node node) {
		if (node == null) return;
		print(node.left);
		print(node.right);
		sb.append(node.data).append("\n");
	}
}