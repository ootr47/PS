import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int temp = routes[0][1];
        int count=1;
        
        for(int i=0; i<routes.length; i++) {
            if(temp < routes[i][0]) {
                temp = routes[i][1];
                count++;
            }
        }
        
        return count;
    }
}