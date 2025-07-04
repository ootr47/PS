import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        int max = 0;
        int rn = 0; 
        
        for(String str : expressions) {
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if(Character.isDigit(c)) {
                    int n = (int)c - '0';
                    if(n>max) max = n;
                }
            }
        }
        
        if(max == 8) rn = 9;

         for(String str : expressions) {
            if(str.contains("X")) continue;
            
            String[] split = str.split(" ");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[2]);
            int ans = Integer.parseInt(split[4]);
             
            String op = split[1];
            
            if(str.contains("-")) {
                if(num1 - num2 == ans) continue;
            } else {
                if(num1 + num2 == ans) continue;
            }
             
            rn = checkBase(num1, num2, ans, max+1, op);
            System.out.println(rn);
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        for(String str : expressions) {
            if(!str.contains("X")) continue;
            
            String[] split = str.split(" ");
            System.out.println(rn);
            if(rn == 0) {
                if(calculate(str, max+1) == calculate(str, 10)) {
                    split[4] = "" + calculate(str, max+1);
                } else {
                    split[4] = "?";
                }
            } else {
                split[4] = "" + calculate(str, rn);
            }
            
            result.add(String.join(" ", split));
        }
        
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public int calculate(String expression, int n) {
        
        
        String[] split = expression.split(" ");
        int num1 = Integer.parseInt(split[0]);
        int num2 = Integer.parseInt(split[2]);
        
        int ans = 0;
        
        if(split[1].equals("+")) {
            ans = numToDec(num1, n) + numToDec(num2, n);
        } else {
            ans = numToDec(num1, n) - numToDec(num2, n);
        }
        System.out.println(expression + " / " + n + " / " + ans);
        return decToNum(ans, n);
    }
    
    public int numToDec(int num, int n) {
        String str = "" + num;
        int len = str.length();
        
        int sum = 0;
        
        for(int i=0; i<len; i++){
            int k = (int)str.charAt(i) - '0';
            sum += k*Math.pow(n,len-i - 1);
        }
        
        return sum;
    }
    
    public int checkBase(int num1, int num2, int ans, int n, String op) {
        for(int i=n; i<=9; i++) {
            int dn1 = numToDec(num1, i);
            int dn2 = numToDec(num2, i);
            int dans = numToDec(ans, i);
            
            System.out.println(dn1 + " / " + dn2 + " / " + dans + " / " + i);
            if(op.equals("+")) {
                if(dn1+dn2==dans) return i;
            } else {
                if(dn1-dn2==dans) return i;
            }
        }
        return 0;
    }
    
    public int decToNum(int decNum, int n) {
        StringBuilder sb = new StringBuilder();
        
        while(decNum >= n) {
            sb.append(decNum % n);
            decNum/=n;
        }
        sb.append(decNum);
        
        return Integer.parseInt(sb.reverse().toString());
    }
}