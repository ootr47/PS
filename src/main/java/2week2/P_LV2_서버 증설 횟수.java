class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[players.length];
        
        for(int i=0; i<players.length; i++){
            int player = players[i];
            int need = (player / m);
            
            if(need > server[i]) {
                answer += need - server[i];
                System.out.println(need + " / " + i);
                int temp = server[i];
                for(int j=i; j<i+k; j++) {
                    if(j >= players.length) break;
                    server[j] += need - temp;
                }
            }
            
        }
        return answer;
    }
}