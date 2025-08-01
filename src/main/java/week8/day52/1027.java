import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxVisible = 0;
        
        for (int i = 0; i < N; i++) {
            int visible = 0;
            
            // 왼쪽 건물들 확인
            double maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(buildings[j] - buildings[i]) / (j - i);
                if (slope > maxSlope) {
                    visible++;
                    maxSlope = slope;
                }
            }
            
            // 오른쪽 건물들 확인
            maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double slope = (double)(buildings[j] - buildings[i]) / (j - i);
                if (slope > maxSlope) {
                    visible++;
                    maxSlope = slope;
                }
            }
            
            maxVisible = Math.max(maxVisible, visible);
        }
        
        System.out.println(maxVisible);
    }
}