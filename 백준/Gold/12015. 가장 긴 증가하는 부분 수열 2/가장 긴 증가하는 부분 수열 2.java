import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[n + 1];
        int len = 0;

        for (int i = 1; i <= n; i++) {
            int left = 0, right = len;
            while (left < right) {
                int mid = (left + right) / 2;
                if (lis[mid] < arr[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            lis[left] = arr[i];
            if (left == len) {
                len++;
            }
        }

        System.out.println(len);
    }
}