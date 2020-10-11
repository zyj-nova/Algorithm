class NumMatrix {

    int catches[][];

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return ;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        catches = new int[row][col];
        // catches[i] 表示第i行 [0,i]的和
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(j == 0){
                    catches[i][j] = matrix[i][j];
                }else
                    catches[i][j] = catches[i][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i = row1; i <= row2; i++){
            if(col1 == 0){
                ans += catches[i][col2];
            }else
                ans += catches[i][col2] - catches[i][col1-1];
        }
        return ans;
    }
}
