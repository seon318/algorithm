import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	class Node{
    		int idx;
    		int val;
			public Node(int idx, int val) {
				this.idx = idx;
				this.val = val;
			}
    	}
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}

    	StringBuilder sb = new StringBuilder();
    	Deque<Node> deque = new ArrayDeque<>();
    	for (int i = 0; i < N; i++) {
    		while (!deque.isEmpty() && deque.peekLast().val >= arr[i]) deque.pollLast();
    		deque.add(new Node(i, arr[i]));
    		while (deque.peekFirst().idx <= i - L) deque.pollFirst();
    		sb.append(deque.peekFirst().val).append(' ');
    	}
    	
    	System.out.println(sb);
    }
}