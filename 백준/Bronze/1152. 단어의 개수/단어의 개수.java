import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	List<String> L = new ArrayList<>();
	String[] s = sc.nextLine().split(" ");
	for(int i =0;i<s.length;i++) {
			L.add(s[i]);
	}
	for(int i =0;i<L.size();i++) {
		if(L.get(i).equals("")) {
			L.remove(i);
		}
	}
	System.out.println(L.size());
	sc.close();
}
}
