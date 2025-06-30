class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long end = (long)times[times.length-1] * n;
        answer = bs(times, 1, end, n);
        
        return answer;
    }
    
    public long bs(int[] times, long start, long end, int n) {
        if(start>end) return start;
        
        long middle = (start + end) / 2;
        long count = 0;
        long max = 0;
        
        for(int time: times) {
            count += middle / time;
            max = Math.max(max,  middle / time * time);
        }
        if(count > n) return bs(times, start, middle-1, n);
        else if (count < n) return bs(times, middle+1, end, n);
        else return max;
    }
}