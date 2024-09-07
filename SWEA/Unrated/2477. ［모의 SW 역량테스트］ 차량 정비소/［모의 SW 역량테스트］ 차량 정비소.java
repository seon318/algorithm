import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Customer implements Comparable<Customer> {
		int num, time, submitNum, maintainNum;

		public Customer(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Customer [num=" + num + ", time=" + time + ", submitNum=" + submitNum + ", maintainNum="
					+ maintainNum + "]";
		}

		@Override
		public int compareTo(Customer o) {
			if (this.time == o.time) return this.submitNum - o.submitNum;
			return this.time - o.time;
		}
	}
	
	static int n, m, k, a, b, time, sum;
	static int[] submitTime, maintainTime;
	static boolean[] submitDesk, maintainDesk;
	static Queue<Customer> customers = new LinkedList<>();
	static Queue<Customer> waitingSub = new LinkedList<>();
	static Queue<Customer> waitingMain = new LinkedList<>();
	static PriorityQueue<Customer> submitQueue = new PriorityQueue<>();
	static PriorityQueue<Customer> maintainQueue = new PriorityQueue<>();
	static Customer now;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			submitTime = new int[n + 1];
			maintainTime = new int[m + 1];
			submitDesk = new boolean[n + 1];
			maintainDesk = new boolean[m + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				submitTime[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				maintainTime[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= k; i++) {
				customers.add(new Customer(i, Integer.parseInt(st.nextToken())));
			}
			
			time = 0;
			sum = 0;
			while (true) {
				//정비 완료된 고객 
				while (!maintainQueue.isEmpty() && maintainQueue.peek().time == time) {
					now = maintainQueue.poll();
					maintainDesk[now.maintainNum] = false;
					if (now.submitNum == a && now.maintainNum == b) sum += now.num;
				}
				
				//접수 완료된 고객
				while (!submitQueue.isEmpty() && submitQueue.peek().time == time) {
					now = submitQueue.poll();
					submitDesk[now.submitNum] = false;
					waitingMain.add(now);
				}
				
				//기다리는 고객
				while (!waitingMain.isEmpty() && maintainQueue.size() < m) {
					now = waitingMain.poll();
					for (int i = 1; i <= m; i++) {
						if (!maintainDesk[i]) {
							now.maintainNum = i;
							now.time = time + maintainTime[i];
							maintainDesk[i] = true;
							break;
						}
					}
					maintainQueue.add(now);
				}
				
				//도착한 고객 
				while (!customers.isEmpty() && customers.peek().time == time) {
					waitingSub.add(customers.poll());
				}
				
				//기다리는 고객
				while (!waitingSub.isEmpty() && submitQueue.size() < n) {
					now = waitingSub.poll();
					for (int i = 1; i <= n; i++) {
						if (!submitDesk[i]) {
							now.submitNum = i;
							now.time = time + submitTime[i];
							submitDesk[i] = true;
							break;
						}
					}
					submitQueue.add(now);
				}
				
				if (customers.isEmpty() && submitQueue.isEmpty() && maintainQueue.isEmpty()) break;
				++time;
			}
			
			if (sum == 0) sum = -1;
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	static void submitLine(Customer x) {
		
	}
}