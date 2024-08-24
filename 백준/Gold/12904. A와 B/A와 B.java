import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (t.length() > s.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
            } else {
                t = t.substring(0, t.length() - 1);
                t = new StringBuilder(t).reverse().toString();
            }
        }

        System.out.println(t.equals(s) ? 1 : 0);
    }
}
