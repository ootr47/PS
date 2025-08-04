package week8.day54;
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
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       
       int n = Integer.parseInt(br.readLine());
       int m = Integer.parseInt(br.readLine());
       
       ArrayList<Node>[] graph = new ArrayList[n + 1];
       for (int i = 1; i <= n; i++) {
           graph[i] = new ArrayList<>();
       }
       
       for (int i = 0; i < m; i++) {
           st = new StringTokenizer(br.readLine());
           int u = Integer.parseInt(st.nextToken());
           int v = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());
           graph[u].add(new Node(v, w));
       }
       
       st = new StringTokenizer(br.readLine());
       int start = Integer.parseInt(st.nextToken());
       int end = Integer.parseInt(st.nextToken());
       
       int[] dist = new int[n + 1];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[start] = 0;
       
       PriorityQueue<Node> pq = new PriorityQueue<>();
       pq.offer(new Node(start, 0));
       
       while (!pq.isEmpty()) {
           Node current = pq.poll();
           
           if (current.cost > dist[current.vertex]) continue;
           
           for (Node next : graph[current.vertex]) {
               int newCost = dist[current.vertex] + next.cost;
               if (newCost < dist[next.vertex]) {
                   dist[next.vertex] = newCost;
                   pq.offer(new Node(next.vertex, newCost));
               }
           }
       }
       
       System.out.println(dist[end]);
   }
}