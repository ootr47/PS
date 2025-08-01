package week8.day50;
import java.io.*;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        Pattern pattern = Pattern.compile("(100+1+|01)+");
        
        for (int i = 0; i < T; i++) {
            String signal = br.readLine();
            if (pattern.matcher(signal).matches()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}