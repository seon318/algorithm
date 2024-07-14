import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] num = new int[10];
        for (int i=0; i<n.length(); i++) {
        	int x = Character.getNumericValue(n.charAt(i));
        	num[x] += 1;
        }
        
        int com = num[6] + num[9];
        if (com % 2 != 0) com += 1;
        num[6] = num[9] = com / 2;
        
        
        int ans = 0;
        for (int i=0; i<10; i++) {
        	ans = Math.max(ans, num[i]);
        }
        
        System.out.println(ans);
    }
}
