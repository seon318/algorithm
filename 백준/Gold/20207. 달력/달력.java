import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cal = new int[366];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            for(int j=S; j<=E; j++) cal[j]++;
        }
        int ans=0;
        for(int i=0; i<=365; i++) {
            if(cal[i]==0) continue;
            int beg=i;
            int end=i;
            int height=cal[i];
            while(cal[end]!=0) {
                end++;
                if (end == 366) break;
                if (cal[end]>height) height=cal[end];
            }
            ans+=(end-beg)*height;
            i+=end-beg;
        }
        System.out.print(ans);
    }
}