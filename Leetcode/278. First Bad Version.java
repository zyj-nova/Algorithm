public class Solution extends VersionControl {
    /*
     * The isBadVersion API is defined in the parent class VersionControl.
     * 
     * boolean isBadVersion(int version);
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {// 已经是错误版本，看看之前的版本有没有错
                right = mid - 1;
            } else {// 正确版本，看往后的版本有没有错
                left = mid + 1;
            }
        }
        return left;
    }
}