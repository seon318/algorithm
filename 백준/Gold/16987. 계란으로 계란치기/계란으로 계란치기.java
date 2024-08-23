import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static int[] numbers;
	static Egg[] eggList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		eggList = new Egg[n];
		numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			eggList[i] = new Egg(s, w);
		}
		
		ans = 0;
		permR(0);
		
		System.out.println(ans);
	}
	
	static void permR(int cnt) {
		if (cnt == n) {
			ans = Math.max(ans, hitEgg(numbers));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (i == cnt) continue;
			numbers[cnt] = i;
			permR(cnt + 1);
		}
	}
	
	static int hitEgg(int[] order) {
	    Egg[] eggs = new Egg[n];
	    for (int i = 0; i < n; i++) {
	        eggs[i] = new Egg(eggList[i].s, eggList[i].w);
	    }
		
		int brokenEggs = 0;

		for (int i = 0; i < n; i++) {
			int j = order[i];
			if (eggs[i].isBroken) continue;
			if (eggs[j].isBroken) return 0;
			eggs[i].s -= eggs[j].w;
			eggs[j].s -= eggs[i].w;
			if (eggs[i].s <= 0) {
				eggs[i].isBroken = true;
				brokenEggs++;
			}
			if (eggs[j].s <= 0) {
				eggs[j].isBroken = true; 
				brokenEggs++;
			}
			if (brokenEggs == n - 1) break;
		}

		return brokenEggs;
	}
}

class Egg {
	int s, w;
	boolean isBroken;

	public Egg(int s, int w) {
		this.s = s;
		this.w = w;
		this.isBroken = false;
	}
}