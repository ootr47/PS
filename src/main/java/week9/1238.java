import java.io.*;
import java.util.*;

class Main {
   static class Node implements Comparable<Node> {
       int vertex, cost;
       
       Node(int vertex, int cost) {
           this.vertex = vertex;
           this.cost = cost;
       }
       
       public int compareTo(Node other) {
           return Integer.compare(this.cost, other.cost);
       }
   }
   
   static ArrayList<Node>[] graph, reverseGraph;
   static int n, m, x;
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       x = Integer.parseInt(st.nextToken());
       
       graph = new ArrayList[n + 1];
       reverseGraph = new ArrayList[n + 1];
       
       for (int i = 1; i <= n; i++) {
           graph[i] = new ArrayList<>();
           reverseGraph[i] = new ArrayList<>();
       }
       
       for (int i = 0; i < m; i++) {
           st = new StringTokenizer(br.readLine());
           int u = Integer.parseInt(st.nextToken());
           int v = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());
           graph[u].add(new Node(v, w));
           reverseGraph[v].add(new Node(u, w));
       }
       
       int[] distToX = dijkstra(reverseGraph, x);
       int[] distFromX = dijkstra(graph, x);
       
       int maxTime = 0;
       for (int i = 1; i <= n; i++) {
           maxTime = Math.max(maxTime, distToX[i] + distFromX[i]);
       }
       
       System.out.println(maxTime);
   }
   
   static int[] dijkstra(ArrayList<Node>[] adj, int start) {
       int[] dist = new int[n + 1];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[start] = 0;
       
       PriorityQueue<Node> pq = new PriorityQueue<>();
       pq.offer(new Node(start, 0));
       
       while (!pq.isEmpty()) {
           Node current = pq.poll();
           
           if (current.cost > dist[current.vertex]) continue;
           
           for (Node next : adj[current.vertex]) {
               int newCost = dist[current.vertex] + next.cost;
               if (newCost < dist[next.vertex]) {
                   dist[next.vertex] = newCost;
                   pq.offer(new Node(next.vertex, newCost));
               }
           }
       }
       
       return dist;
   }
}