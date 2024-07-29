import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, max, total;
		
        for (int x=1; x<=10; x++) {
        	n = sc.nextInt();
        	int[] height = new int[n];
        	for (int i=0; i<n; i++) {
        		height[i] = sc.nextInt();
        	}
        	total = 0;
        	
        	for (int i=2; i<n-2; i++) {
        		max = 0;
        		for (int j=i-2; j<=i+2; j++) {
        			if (j == i) continue;
        			max = Math.max(max, height[j]);
        		}
        		if (height[i] > max) total += (height[i]-max);
        	}
        	
        	System.out.println("#"+x+ " "+total);
		}
	}
}