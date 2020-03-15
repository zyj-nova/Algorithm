import java.util.*;

class Solution {
    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * 
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * A = [1,2,3,0,0,0] B = [3,4,5]
     * 
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        // int j = 0;
        // for (int i = m; i < A.length; i++) {
        // A[i] = B[j++];
        // }
        // Arrays.sort(A);
        // 双指针
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] > A[i]) {
                A[i + j + 1] = B[j--];
            } else {
                A[i + j + 1] = A[i--];
            }
        }
        // 因为A已经有足够的空间来存放A、B数组，因此不必担心A数组元素被覆盖。
        // 分为以下两种情况：
        // 当 j已经小于0了，而此时i还不为0，因为i之前的都是有序的，因此就不用管了。
        // 若当i已经小于0了（A原来的元素都已经放到后面了），可能j还不为0，就把B剩下的元素加到A元素中。

        while (j >= 0) {
            A[j] = B[j--];
        }

    }

    public static void main(String args[]) {
        int A[] = new int[] { 1, 2, 3, 9, 12, 0, 0, 0 };
        int B[] = new int[] { 3, 4, 11 };
        merge(A, 5, B, 3);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}