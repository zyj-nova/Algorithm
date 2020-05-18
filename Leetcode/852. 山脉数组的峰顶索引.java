class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int v = A[mid];
            // 按照定义，peak元素后至少有一个比他小的元素，因此不必担心越界
            if (v < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}