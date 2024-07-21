import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			String input = sc.next();
			String room = "";
			if (input.equals("Algorithm")) room="204";
			else if (input.equals("DataAnalysis")) room="207";
			else if (input.equals("ArtificialIntelligence")) room="302";
			else if (input.equals("CyberSecurity")) room="B101";
			else if (input.equals("Network")) room="303";
			else if (input.equals("Startup")) room="501";
			else if (input.equals("TestStrategy")) room="105";
			
			System.out.println(room);
		}
		
	}
}
