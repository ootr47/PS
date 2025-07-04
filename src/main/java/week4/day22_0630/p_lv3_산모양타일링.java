package week4.day22_0630;
class Solution {
    int[] arr;
    public int solution(int n, int[] tops) {
        arr = new int[200002];
        return test(n*2+1, tops);
    }
    
    public int test(int n, int[] tops) {
        if(n<2) return 1;
        if(arr[n]!=0) return arr[n];
        
        arr[n] = test(n-1, tops) + test(n-2,tops);
        if (n%2 == 0 && tops[n/2-1] == 1) arr[n] += test(n-1, tops);   
        
        arr[n] %= 10007;
        
        return arr[n];
    }
}
