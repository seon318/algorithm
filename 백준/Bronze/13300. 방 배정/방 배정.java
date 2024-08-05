import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int s, y;
    	int room = 0;
    	
    	int[][] students = new int[7][2];
    	for (int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		s = Integer.parseInt(st.nextToken());
    		y = Integer.parseInt(st.nextToken());
    		students[y][s]++;
    	}
    	
    	for (int i=1; i<7; i++) {
    		for (int j=0; j<2; j++) {
    			room += students[i][j]/k;
    			if (students[i][j]%k != 0) room++;
    		}
    	}
    	
    	System.out.println(room);
    }
}
