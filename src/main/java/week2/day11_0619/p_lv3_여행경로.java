package week2.day11_0619;

import java.util.*;

class Solution {

    boolean[] visited;
    String[] answer;
    boolean found = false; 

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) { 
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]); 
        });

        ArrayList<String> route = new ArrayList<>();
        route.add("ICN"); 
        
        dfs(tickets, route, "ICN");
        
        return answer;
    }

    private void dfs(String[][] tickets, ArrayList<String> route, String current) {
        if (route.size() == tickets.length + 1) {
            answer = route.toArray(new String[0]); 
            found = true; 
            return; 
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && current.equals(tickets[i][0])) {
                visited[i] = true; 
                route.add(tickets[i][1]); 
                
                dfs(tickets, route, tickets[i][1]);

                if (found) return;

                route.remove(route.size() - 1); 
                visited[i] = false; 
            }
        }
    }
}