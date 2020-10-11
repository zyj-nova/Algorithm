class Solution {
    int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    boolean vis[][] = new boolean[205][205];
    boolean ok = false;
    int n,m;
    String target;
    char maps[][];

    public boolean in(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        target = word;
        maps = board;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == word.charAt(0)){
                    vis[i][j] = true;
                    dfs(i,j,"" + board[i][j],1);
                    vis[i][j] = false;
                }
            }
        }
        return ok;
    }

    public void dfs(int x,int y, String s, int len){
        if (ok){
            return;
        }
        if (len > target.length())
            return;
        if (len == target.length()){
            if (s.equals(target))
                ok = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if (in(dx,dy) && !vis[dx][dy] && maps[dx][dy] == target.charAt(len)){
                vis[dx][dy] = true;
                dfs(dx,dy, s + maps[dx][dy], len + 1);
                vis[dx][dy] = false;
            }
        }

    }
}