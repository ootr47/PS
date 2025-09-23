class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sbn = new StringBuilder();
        
        int i = 0;
        while(sbn.length() < t*m) {
            sbn.append(convert(i++, n));
        }
        
        int cnt = p-1;
        while(answer.length() < t) {
            answer.append(sbn.charAt(cnt));
            cnt += m;
        }
        
        return answer.toString();
    }
    
    private String convert(int num, int x) {
        StringBuilder sb = new StringBuilder();
        int temp = num;
        while(temp >= x) {
            int mod = temp%x;
            temp /= x;
            
            if(mod>=10) sb.append((char)(mod- 10 + 'A' ));
            else sb.append(mod);
        }
        if(temp>=10) sb.append((char)(temp- 10 + 'A' ));
        else sb.append(temp);
        
        return sb.reverse().toString();
    }
}