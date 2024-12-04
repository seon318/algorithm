import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static Fish[] arr;
	static LinkedList<Fish>[] list;
	
	static class Fish {
		int num;
		int move;
		public Fish(int num) {
			this.num = num;
			this.move = 0;
		}
		public String toString() {
			return "fish [num=" + num + ", move=" + move + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new Fish[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = new Fish(Integer.parseInt(st.nextToken()));
		}
		int cnt = 0;
		
		list = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new LinkedList<>();
		}
		
		while (true) {
			//물고기 수 차이 확인
			int max = arr[0].num;
			int min = arr[0].num;
			for (int i = 1; i < n; i++) {
				max = Math.max(max, arr[i].num);
				min = Math.min(min, arr[i].num);
			}
			if (max - min <= k) break;
			
			cnt++;
			simulate(min);
		}
		System.out.println(cnt);
	}

	private static void simulate(int min) {
		//1. 물고기 추가하기 
		for (int i = 0; i < n; i++) {
			if (arr[i].num == min) arr[i].num++;
			list[i].add(arr[i]);
		}
		
		//2. 공중부양 시키기
		list[1].add(list[0].removeFirst());
		int start = -1, end = -1;
		while (true) {
			//2개 이상 쌓인 부분 찾기
			for (int i = 0; i < n; i++) {
				if (!list[i].isEmpty() && start == -1) start = i;
				if (list[i].size() >= 2) end = i;
			}
			if (list[end].size() > n - 1 - end) break; //오른쪽 바닥이 비는 경우는 멈추기
			
			for (int i = end; i >= start; i--) {
				int size = list[i].size();
				for (int j = 1; j <= size; j++) {
					list[end + j].add(list[i].removeFirst());
				}
			}
		}

		//3. 물고기 수 조절
		controlNum();

		//4. 다시 공중부양
		for (int i = 1; i <= n / 2; i++) {
			list[n/2 - i].add(arr[n - i]);
			list[n/2 - i].add(arr[i - 1]);
		}

		for (int i = n / 4; i < n / 2; i++) {
			while (!list[n / 2 - i - 1].isEmpty()) {
				list[i].addLast(list[n/2 - i - 1].removeLast());
			}
		}

		//5. 물고기 수 조절
		controlNum();
	}
	
	private static void controlNum() {
		//옮길 물고기 수 확인
		for (int i = 0; i < n; i++) {
			if (list[i].size() == 0) continue;
			for (int j = 0; j < list[i].size() - 1; j++) {
				Fish f1 = list[i].get(j);
				Fish f2 = list[i].get(j + 1);
				moveFish(f1, f2);
			}
			if (i == n - 1) break;
			for (int j = 0; j < Math.min(list[i].size(), list[i + 1].size()); j++) {
				Fish f1 = list[i].get(j);
				Fish f2 = list[i + 1].get(j);
				moveFish(f1, f2);
			}
		}
		
		//물고기 이동 시키기 
		for (int i = 0; i < n; i++) {
			arr[i].num += arr[i].move;
			arr[i].move = 0;
		}
		toLine();
	}
	
	private static void moveFish(Fish f1, Fish f2) {
		int diff = Math.abs(f1.num - f2.num) / 5;
		if (diff ==  0) return;
		if (f1.num > f2.num) {
			f1.move -= diff;
			f2.move += diff;
		} else {
			f1.move += diff;
			f2.move -= diff;
		}
	}
	
	private static void toLine() {
		int idx = 0;
		for (int i = 0; i < n; i++) {
			while (!list[i].isEmpty()) {
				arr[idx++] = list[i].removeFirst();
			}
		}
	}
}