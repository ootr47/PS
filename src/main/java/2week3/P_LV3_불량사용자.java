import java.util.*;

class Solution {
    ArrayList<Integer> result;
    public int solution(String[] user_id, String[] banned_id) {
        int uLen = user_id.length;
        int bLen = banned_id.length;
        
        result = new ArrayList<>();
        ArrayList<Integer>[] b = new ArrayList[bLen];
        for(int i=0; i<bLen; i++) b[i] = new ArrayList<>();
        
        
        for(int i=0; i<uLen; i++) {
            String uid = user_id[i];
            
            for(int j=0; j<bLen; j++) {
                String bid = banned_id[j];
                if(uid.length() != bid.length()) continue;
                
                int k=0;
                while(uid.charAt(k) == bid.charAt(k) || bid.charAt(k) == '*') {
                    if(++k == uid.length()) break;
                }
                if(k == uid.length()) b[j].add(i);
            }
        }
        for(int i=0; i<bLen; i++) {
            System.out.println(b[i].toString());
        }
        
        search(b, new ArrayList<Integer>(), 0);
        return result.size();
    }
    
    private void search(ArrayList<Integer>[] b, ArrayList<Integer> al, int idx) {
        if(idx >= b.length) {
            int temp = 0;
            for(int k : al) {
                temp |= 1<<k;
            }
            if(!result.contains(temp)) result.add(temp);
            return;
        }
        for(int n : b[idx]) {
            if(al.contains(n)) continue;
            al.add(n);
            search(b, al, idx+1);
            al.remove(al.size()-1);
        }   
    }
}