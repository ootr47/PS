package week5.day34_0712;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int n;
    static int m;
    static int[][] arr;
    static ArrayList<int[]> chickenList;
    static ArrayList<int[]> homeList;

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int [n][n];

        chickenList = new ArrayList<>();
        homeList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                }
                else if(arr[i][j] == 1) {
                    homeList.add(new int[]{i,j});
                }
            }
        }
        combination(0, new ArrayList<>());

        System.out.println(ans);
    }

    private static void combination(int index, ArrayList<int[]> selected) {
        if(selected.size() == m) {
            int sum = 0;
            for(int[] home: homeList) {
                int minDist = Integer.MAX_VALUE;
                for(int[] c : selected) {
                    int dist = Math.abs(home[0] - c[0]) + Math.abs(home[1] - c[1]);
                    minDist = Math.min(minDist, dist);
                }
                sum+=minDist;
            }
            ans = Math.min(sum, ans);
        }

        for(int i=index; i<chickenList.size(); i++) {
            selected.add(chickenList.get(i));
            combination(i+1, selected);
            selected.remove(selected.size()-1);
        }
        
    }

    
}