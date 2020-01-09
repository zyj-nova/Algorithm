import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        // 第一种 空间复杂度 O(k2);
        // int nums[][] = new int[rowIndex + 1][rowIndex + 1];
        // nums[0][0] = 1;
        // for(int i = 1; i <= rowIndex; i++){
        // for(int j = 0; j <= i; j++){
        // if(j == 0){
        // nums[i][j] = 1;
        // }else{
        // nums[i][j] = nums[i-1][j] + nums[i-1][j-1];
        // }
        // }
        // }
        // List<Integer> res = new ArrayList<>();
        // for (int i = 0; i < nums[rowIndex].length; i++){
        // res.add(nums[rowIndex][i]);
        // }
        // return res;
        // 优化空间复杂度到O(k)
        int nums[] = new int[rowIndex + 1];
        nums[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i)
                    nums[j] = 1;
                else
                    nums[j] = nums[j] + nums[j - 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(nums[i]);
        }
        return res;

    }
}