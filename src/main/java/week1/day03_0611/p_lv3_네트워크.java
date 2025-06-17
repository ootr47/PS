package week1.day03_0611;

import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int result = 0;
        
        List<Integer>[] adjList = new ArrayList[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            adjList[i] = new ArrayList<>();
            
            for(int j=0; j<n; j++) {
                int computer = computers[i][j];
                if(i!=j && computer==1) adjList[i].add(j);
            }
        }
        
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            dfs(i, adjList);
            result++;
        }
        
        return result;
    }
    
    private void dfs(int current, List<Integer>[] adjList) {
        visited[current] = true;
        
        for(int next : adjList[current]) {
            if(!visited[next]) {
                dfs(next, adjList);
            }
        }
    }
}