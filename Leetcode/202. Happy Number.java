import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        return helper(n, set);
    }

    private boolean helper(int n, Set<Integer> set) {
        if (n == 1) {
            return true;
        }
        if (set.contains(n))
            return false;
        set.add(n);
        int sum = 0;
        while (n != 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return helper(sum, set);
    }
}