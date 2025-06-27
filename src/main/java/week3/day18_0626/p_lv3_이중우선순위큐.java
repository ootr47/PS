import java.util.*;

class Solution {
    public static int[] solution(String[] operations) {
        ArrayList<Integer> al = new ArrayList<>();

        for(String str : operations) {
            String[] splitStr = str.split(" ");
            switch(splitStr[0]) {
                case "I" : {
                    int n = Integer.parseInt(splitStr[1]);
                    
                    int i;
                    for(i = al.size()-1; i>=0; i--) {
                        if(al.get(i) < n) break;
                    }
                    i++;
                    al.add(i, n);
        
                    break;
                }
                case  "D" : {
                    if(al.isEmpty()) break;
                    if(Integer.parseInt(splitStr[1]) > 0) {
                        al.remove(al.size()-1);
                    } else {
                        al.remove(0);
                    }
                    break;
                }
            }
            for(int k : al) {
                System.out.print(k + ",");
            }
            System.out.println();
        }
        if(al.isEmpty()) {
            return new int[]{0,0};
        } else {
            return new int[]{al.get(al.size()-1),al.get(0)};
        }
    }
}