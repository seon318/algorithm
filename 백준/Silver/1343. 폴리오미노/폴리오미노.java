import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int now = 0;
        String ans = "";
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                now += 1;
            }
            if (input.charAt(i) == '.' || i == input.length() - 1) {
                if (now > 0) {
                    String str = changeAlpha(now);
                    now = 0;
                    if (str.equals("-1")) {
                        ans = str;
                        break;
                    }
                    ans += str;
                }
                if (input.charAt(i) == '.') {
                    ans += '.';
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
    
    public static String changeAlpha(int now) {
        String str = "";
        if (now % 2 != 0) {
            return "-1";
        }
        while (now >= 4) {
            str += "AAAA";
            now -= 4;
        }
        while (now >= 2) {
            str += "BB";
            now -= 2;
        }
        return str;
    }
}
