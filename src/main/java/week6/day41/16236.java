package week6.day41;
import java.io.*;
import java.util.*;

class Main { 

    static class Fish {
        int x;
        int y;
        int size;

        Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    static int n;
    static int[][] arr;
    static Fish shark;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j] == 9) {
                    shark = new Fish(j, i, 2);
                    arr[i][j] = 0;
                }
            }
        }

        int answer = 0;
        int result = bfs();
        
        while(result != 0) {
            answer += result;
            result = bfs();
        }

        System.out.println(answer);
    }

    static int count = 0;

    private static int bfs() {
        visited = new boolean[n][n];

        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{shark.x, shark.y, 0});

        List<int[]> minDistFishList = new ArrayList<>();

        int min = -1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];
            
            if(arr[y][x] > 0 && arr[y][x] < shark.size) {
                if(min == -1) min = depth;
                else if(min < depth) break;
                minDistFishList.add(new int[]{x, y, depth});
            }
            else {
                for(int i=0; i<4; i++) {
                    int xx = x+dx[i];
                    int yy = y+dy[i];
    
                    if(!isPossible(xx,yy)) continue;
    
                    visited[yy][xx] = true;
                    q.offer(new int[]{xx, yy, depth + 1});
                }
            }
        }

        if(minDistFishList.size() == 0) return 0;

        Collections.sort(minDistFishList, (o1, o2) -> {
            if(o1[1]==o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int[] pos = minDistFishList.get(0);
        shark.x = pos[0];
        shark.y = pos[1];

        arr[pos[1]][pos[0]] = 0;

        count++;
        if(count == shark.size) {
            shark.size++;
            count = 0;
        }

        return pos[2];
    }

    private static boolean isPossible(int x, int y) {
        if(x<0 || y<0 || x>=n || y>=n) return false;
        if(visited[y][x]) return false;
        if(arr[y][x] > shark.size) return false;
        return true;
    }
}