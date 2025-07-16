import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[n - i - 1] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();

        stk.push(arr[0]);
        al.add(-1);
        int idx = 1;
        while(idx < n) {
            int top = stk.peek();
            if(top > arr[idx]) {
                al.add(top);
            } else {
                while(!stk.isEmpty() && arr[idx] >= stk.peek()) {
                    stk.pop();
                }
                if(stk.isEmpty()) {
                    al.add(-1);
                } else {
                    al.add(stk.peek());
                }
            }
            stk.push(arr[idx++]);
        }
        
        for(int i = n - 1; i >= 0; i--) {
            sb.append(al.get(i)).append(" ");
        }
        System.out.println(sb.toString());

        br.close();
    }
}