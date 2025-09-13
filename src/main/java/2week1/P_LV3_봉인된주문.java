import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        long[] banNums = new long[bans.length];
        int index = 0;
        for(String ban : bans) {
            int k = ban.length() - 1;
            long sum = 0;
            for(int i=0; i<ban.length(); i++){
                char c = ban.charAt(i);
                int code = c - 'a' + 1;
                sum += code * (long)(Math.pow(26, k));
                k--;
            }
            banNums[index++] = sum;
        }
        
        Arrays.sort(banNums);
        
        int count = 0;
        for(int i=0; i<banNums.length; i++) {
            if(count+n >= banNums[i]) {
                count++;
            }
            else break;
        }
        
        long tn = n + count;
        StringBuilder sb = new StringBuilder();
        
        while(tn >= 26) {
            long mod = tn % 26;
            tn /= 26;
            if(mod == 0){
              mod = 26;
                tn--;
            } 
            sb.append((char)('z' - (26 - mod)));
        }
        sb.append((char)('z' - (26 - tn)));
        
        return sb.reverse().toString();
    }
}