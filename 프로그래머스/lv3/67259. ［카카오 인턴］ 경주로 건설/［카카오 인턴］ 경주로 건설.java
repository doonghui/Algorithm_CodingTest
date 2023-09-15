import java.util.*;

class Point {
    int x;
    int y;
    int cost;
    int dir;
    public Point(int x, int y,int cost,int dir) {
        this.x = x;
        this.y =y;
        this.cost = cost;
        this.dir = dir;
    }
}

class Solution {
    static int[] dx = {0,1,0,-1};         // 우 하 좌 상
    static int[] dy = {1,0,-1,0};
    static int ans = Integer.MAX_VALUE;
    
    
    public int solution(int[][] board) {
        int boardSize = board.length;
        boolean[][][] visited = new boolean[boardSize][boardSize][4];
     
        
        bfs(board,visited,boardSize);
        
        return ans;
    }
    // 0 2 ,, 1 3 우하좌상
    static void bfs(int[][] board,boolean[][][] visited,int n) {
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(0,0,0,-1));    
        
            while(!q.isEmpty()) {
                Point po = q.poll();
                
                if(po.x == n-1 && po.y == n-1){
                    ans = Math.min(ans,po.cost);
                }
                
                for(int i=0;i<4;i++) {
                    int nx = po.x + dx[i];
                    int ny = po.y + dy[i];
                    int nCost = po.cost;
                    
                    if(nx < 0 || nx >=n || ny <0 || ny >=n) continue;
                    if(board[nx][ny] == 1) continue;
                    
                    if(po.dir == -1)
                        nCost += 100;
                    else if(po.dir ==i) {
                        nCost += 100; 
                    } else {
                        nCost += 600;
                    }
                    
                    
                    if(!visited[nx][ny][i] || nCost <= board[nx][ny]) {
                        visited[nx][ny][i] = true;
                        board[nx][ny] = nCost;
                        q.add(new Point(nx,ny,nCost,i));
                    }
                    
                    
                }
                
                
                
                
            }  
        
    }
}