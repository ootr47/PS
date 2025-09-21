class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int start = 1;
        int end = 100000;
        
        int level = 0;
        
        for(int i=0; i< 100; i++){
            level = (start+end) / 2;
            long time = checkLimit(0, diffs, times, level);
            
            if(time < limit) end = level;
            else if (time > limit) start = level+1;
            else return level;
        }
        
        return level;
    }
    
    public long checkLimit (long time, int[] diffs, int[] times, int level) {
        for(int i=0; i< diffs.length; i++) {
            int sub = Math.max(diffs[i] - level, 0);
            int prev = 0;
            if(i>0) prev= times[i-1];
            time += sub * (times[i] + prev) + times[i];
        }
        return time;
    }
}