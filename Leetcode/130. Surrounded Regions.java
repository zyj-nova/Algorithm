class Solution {
   int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return ;
        }
        int m = board.length, n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    if(board[i][j] == 'O') 
                        dfs(i,j,board, vis);
                }
                    
            }
        }
        for (int i = 1; i < m - 1; i++){
            for(int j = 1 ; j < n - 1; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
                
            }
        }
    }
    //排除法，先把边界上相通的全部标记为访问过
    private void dfs(int x,int y, char [][]map, boolean [][]vis){
        for(int i = 0; i < dir.length; i++){
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if(in(dx,dy,map.length,map[0].length) && map[dx][dy] == 'O' && !vis[dx][dy]){
                vis[dx][dy] = true;
                dfs(dx,dy,map,vis);
            }
        }
    }

    private boolean in(int x, int y, int m,int n){
        return x >= 0 &&  y >= 0 && x <= m - 1 && y <= n - 1;
    }
}