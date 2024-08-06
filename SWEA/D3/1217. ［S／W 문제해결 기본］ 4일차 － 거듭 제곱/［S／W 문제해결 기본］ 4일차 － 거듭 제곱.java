import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, n, m;
 
        for (int tc = 1; tc <= 10; tc++) {
            t = sc.nextInt();
            n = sc.nextInt();
            m = sc.nextInt();
            System.out.printf("#%d %d\n", t, pow(n, m));
        }
    }
    static int pow(int n, int m) {
        if (m <= 1) return n;
        else return n * pow(n, m - 1);
    }
}