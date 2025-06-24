class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int mod = s%n;
        int div = s/n;
        
        if(div == 0) return new int[]{-1};
        
        for(int i=n-1; i>=0; i--) {
            if(mod>0) {
                answer[i] = div+1;   
                mod--;
            } else {
                answer[i] = div;
            }
        }
        return answer;
    }
}