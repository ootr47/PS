package week1.day04_0612;

import java.util.*;

class Solution {
    
    ArrayList<String> al = new ArrayList<>();
    int min = 50;
    
    public int solution(String begin, String target, String[] words) {
        
        for(String str : words) {
            if (check(begin, str)) {
                al.add(str);
                dfs(str, target, words, 1);
                al.remove(str);
            }
        }
        
        if(min == 50) return 0;
        return min;
    }
    
    public int dfs(String next, String target, String[] words, int depth) {        
        
        
        
        if(next.equals(target)) {
            if(depth != 0 && depth < min) min = depth;
            return depth;
        }
        
        for(String str : words) {
            
            if (!al.contains(str) && check(next, str)) {
                System.out.println(next + ", " + str);
                al.add(str);
                dfs(str, target, words, depth + 1);
                al.remove(str);
            }
        }
        System.out.println("0");
        return 0;
    }
    
    public boolean check(String str1, String str2) {
        if(str1.equals(str2)) return false;
        int len = str1.length();
        
        int count = 0;
        for(int i =0; i<len; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if(count>1) return false;
        }
        return true;
    }
}