import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        List<Integer>[] adjList = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<=n; i++) adjList[i] = new ArrayList<>();
        
        for(int[] e : edge) {
            int from = e[0];
            int to = e[1];
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        return bfs(1, adjList);
    }
    
    private int bfs(int start, List<Integer>[] adjList) {
        Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q_depth = new ArrayDeque<>();
        q.add(start);
        q_depth.add(0);
        visited[start] = true;
        
        int maxDepth = 0;
        int count = 0;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            int depth = q_depth.poll();
            
            if(maxDepth < depth) {
                maxDepth = depth;
                count=0;
            }
            count++;
            
            for(int next : adjList[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    q_depth.add(depth+1);
                }
            }
        }
        return count;
    }
}