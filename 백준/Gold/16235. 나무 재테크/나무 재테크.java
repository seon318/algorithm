import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, x, y, age;
	static int[][] map, nutrition;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static Tree[] arr;
	static Deque<Tree> trees = new ArrayDeque<>();
	static List<Tree> tmp;
	
	
	static class Tree implements Comparable<Tree> {
		int x, y, age;
		
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		nutrition = new int[n][n];
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nutrition[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		arr = new Tree[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			age = Integer.parseInt(st.nextToken());
			arr[i] = new Tree(x, y, age);
		}
		
		Arrays.sort(arr);
		
		for (Tree tree : arr) {
			trees.addLast(tree);
		}
		
		for (int time = 0; time < k; time++) {

			//봄 
			tmp = new ArrayList<>();
			int size = trees.size();
			for (int i = 0; i < size; i++) {
				Tree tree = trees.pollFirst();
				if (map[tree.x][tree.y] >= tree.age) {
					map[tree.x][tree.y] -= tree.age++;
					trees.addLast(tree);
				}
				else tmp.add(tree);
			}

			//여름 
			for (Tree tree : tmp) {
				map[tree.x][tree.y] += tree.age / 2;
			}
			
			//가을
			tmp = new ArrayList<>();
			for (Tree tree : trees) {
				if (tree.age % 5 != 0) continue;
				for (int d = 0; d < 8; d++) {
				int nx = tree.x + dx[d];
				int ny = tree.y + dy[d];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) tmp.add(new Tree(nx, ny, 1));
				}
			}
			
			for (Tree tree : tmp) {
				trees.addFirst(tree);
			}

			//겨울 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] += nutrition[i][j];
				}
			}
			
		}
		
		System.out.println(trees.size());
	}
}