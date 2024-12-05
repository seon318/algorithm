import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] idx = new int[N];

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
                idx[i] = list.size() - 1;
            } else {
                int left = 0, right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) >= arr[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                list.set(right, arr[i]);
                idx[i] = right;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size() - 1).append("\n");

        Stack<Integer> stack = new Stack<>();
        int index = list.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (index == idx[i]) {
                stack.push(arr[i]);
                index--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}