import java.util.PriorityQueue;

class Solution {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k < 1)
            return new int[] {};
        PriorityQueue<Integer> q = new PriorityQueue<>(k, (a, b) -> {
            return a - b;
        });
        for (int n : arr) {
            q.add(n);

        }
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        getLeastNumbers(new int[] { 0, 3, 2, 1 }, 2);
    }
}