interface MountainArray {
    public int get(int index);

    public int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 最小的index
        // [1,2,3,4,5,3,1]
        int len = mountainArr.length();
        int peak = findPeak(0, len - 1, mountainArr);
        int l = searchLeft(0, peak, target, mountainArr);
        return l == -1 ? searchRight(peak, len - 1, target, mountainArr) : l;
    }

    // 找到山峰值
    private int findPeak(int left, int right, MountainArray mountainArray) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int v = mountainArray.get(mid);
            // 由于题中定义peak后面会有一个元素，因此不会越界
            if (v < mountainArray.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 左边找 [0, peak]严格升序数组
    int searchLeft(int left, int right, int target, MountainArray mountainArray) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int v = mountainArray.get(mid);
            if (v == target) {
                return mid;
            }
            if (v > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // [peak,len-1]右边是严格降序数组
    private int searchRight(int left, int right, int target, MountainArray mountainArray) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int v = mountainArray.get(mid);
            if (v == target) {
                return mid;
            }
            if (v > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}