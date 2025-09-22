import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, (o1, o2) -> {
            String head1 = parseHead(o1).toUpperCase();
            String head2 = parseHead(o2).toUpperCase();
            if(head1.equals(head2)) {
                return parseNum(o1) - parseNum(o2);
            }
            return head1.compareTo(head2);
        });
        return files;
    }
    
    private String parseHead(String str) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') break;
            sb.append(c);
        }
        // System.out.println(sb);
        return sb.toString();
    }
    
    private int parseNum(String str) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c < '0' || c > '9') {
                if(flag) break;
                continue;
            }
            flag = true;
            sb.append(c);
        }
        // System.out.println(Integer.parseInt(sb.toString()));
        return Integer.parseInt(sb.toString());
    }
}