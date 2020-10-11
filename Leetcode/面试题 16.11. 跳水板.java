class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        // 不是dp
        if(k == 0){
            return new int[0];
        }
        if(shorter == longer){
            return new int[]{shorter * k};
        }
        int ans[] = new int[k+1];
        for(int i = 0; i <= k; i++){
            ans[i] = shorter * (k - i) + longer * i; 
        }
        return ans;
    }
}