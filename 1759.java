import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int c;
    static String[] input;
    static boolean[] visited;
    static ArrayList<String> answer;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        c = Integer.parseInt(in[1]);

        visited = new boolean[c];
        input = new String[c];

        answer = new ArrayList<>();

        input = br.readLine().split(" ");
    
        
        Arrays.sort(input);

        recursive(0, new StringBuilder());

        for(String str : answer) {
            System.out.println(str);
        }
        
    }

    static String[] arr = {"a", "e", "i", "o", "u"};

    private static void recursive(int index, StringBuilder sb) {

        if(sb.length() == n) {
            int count = 0;
            for(String c : arr) {
                if(sb.toString().contains(c)) count ++;
            }

            if(count>0 && count <= sb.length() - 2) {
                answer.add(sb.toString());
            }
            
            return;
        }

        for(int i=index; i<c; i++) {
            if(visited[i]) continue;
            sb.append(input[i]);
            visited[i] = true;
            recursive(i+1, sb);
            visited[i] = false;
            sb.setLength(sb.length()-1);
        }
    }
}