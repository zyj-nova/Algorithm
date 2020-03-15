import java.util.*;

class Solution {
    public static int[][] findContinuousSequence(int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= target / 2 + 1; i++) {
            int sum = 0;
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = i; j <= target / 2 + 1; j++) {
                tmp.add(j);
                sum += j;
                if (sum == target) {
                    ans.add((ArrayList<Integer>) tmp.clone());
                    break;
                } else if (sum > target) {
                    break;
                }
            }

            tmp.clear();
        }
        System.out.println(ans);
        int res[][] = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = new int[ans.get(i).size()];
            for (int j = 0; j < ans.get(i).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findContinuousSequence(100);
    }
}