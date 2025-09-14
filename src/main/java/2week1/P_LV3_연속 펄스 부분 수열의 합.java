import java.util.*;
import java.math.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
        
        int flag1 = 1;
        int flag2 = -1;
        
        long max = sequence[0];
        
        for(int i=0; i< sequence.length; i++) {
            flag1 *= -1;
            flag2 *= -1;
            
            sum1+= sequence[i] * flag1;
            sum2+= sequence[i] * flag2;
            
            if(sum1 < 0) sum1 = 0;
            if(sum2 < 0) sum2 = 0;
            
            max = Math.max(max, Math.max(sum1, sum2));
        }
        return max;
    }
}