class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        int ans[] = new int[4];
        int dp[][] = new int[row + 1][col + 1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0){
                    dp[i+1][j+1] = matrix[i][j];
                }
            }
        }
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                dp[i+1][j+1] = dp[i- 1 + 1][j + 1] + matrix[i][j];
            }
        }
        int maxn = Integer.MIN_VALUE;
        int begin = 1;
        for(int i = 1; i <= row; i++){
            for(int j = i; j <= row; j++){
                int sum = 0;
                for(int cc = 1; cc <= col; cc++){
                    int tmp = dp[j][cc] - dp[i-1][cc];
                    //还需记录最大子段和的起止点
                    if(sum <= 0){//这个判断条件坑死我了....
                        sum = tmp;
                        begin = cc;
                    }else{
                        sum += tmp;
                    }
                    if(sum > maxn){
                        maxn = sum;
                        ans[0] = i - 1;//左上角行号
                        ans[1] = begin - 1;
                        ans[2] = j - 1;//右下角行号
                        ans[3] = cc - 1;//右下角列号
                    }
                }
                
            }
        }
        
        return ans;
    }
}