class Solution {
    
    static char[] dc = {'d', 'l', 'r', 'u'};
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String result = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x-r) + Math.abs(y-c);
        if(dist > k) return "impossible";
        if((k - dist)%2==1) return "impossible";
        
        search(n,m,x,y,r,c,k,0, new StringBuilder());
        
        if(result.length() == 0) return "impossible";
        return result;
    }
    
    private void search(int n, int m, int x, int y, int r, int c, int k, int cnt, StringBuilder sb) {
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int dist = Math.abs(nx-r) + Math.abs(ny-c);
            
            if(result.length() > 0) return;
            if(nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
            if(dist + cnt + 1> k) continue;
            if((k - dist - cnt - 1) %2 != 0) continue;   
            
            if(nx == r && ny ==c && cnt+1==k) {
                sb.append(dc[i]);
                result = sb.toString();
                return;
            }
            sb.append(dc[i]);
            search(n,m,nx,ny,r,c,k,cnt+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}