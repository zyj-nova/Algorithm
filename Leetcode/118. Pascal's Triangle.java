import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        int arr[][] = new int[numRows + 1][numRows + 1];
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == 0) {
                    arr[i][j] = 1;
                    tmp.add(arr[i][j]);
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                    tmp.add(arr[i][j]);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}