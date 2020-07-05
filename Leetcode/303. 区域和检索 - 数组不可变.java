class NumArray {

    int catches[];

    public NumArray(int[] nums) {
        // catche[i]代表[0,i]元素和
        int len = nums.length;
        if(len == 0){
            return ;
        }
        catches = new int[len];
        catches[0] = nums[0];
        for(int i = 1; i < len; i++){
            catches[i] = catches[i-1] + nums[i];
        }

    }
    
    public int sumRange(int i, int j) {
        if(i == 0){
            return catches[j];
        }
        return catches[j] - catches[i-1];
    }
    // nums [1,2,3,4,5] 2,4 15 - 6 
    // catches [1,3,6,10,15]
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
