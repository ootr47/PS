import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int len = works.length;
        Arrays.sort(works);
        
        if(len==1) return (works[0]-n)*(works[0]-n);
        
        for(int i = 0; i<n; i++){
            works[len-1]-=1;
            int t=len-1;
            
            while(t>0&&works[t]<works[t-1]){
                swap(works,t,t-1);
                t--;
            }
            if(works[len-1]<=0) return 0;
        }
        for(int i:works) answer+=i*i;
        
        return answer;
    }
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] =temp;
    }
}