class Solution {
    public static int[] distributeCandies(int candies, int num_people) {
        int ans[] = new int[num_people];
        int i = 0, round = 0;
        while (candies > 0) {
            if (i % num_people == 0 && i >= num_people)
                round++;
            int tmp = round * num_people + i % num_people + 1;

            if (candies < tmp) {
                ans[i % num_people] += candies;
                break;
            }
            ans[i % num_people] += tmp;
            candies -= tmp;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans[] = distributeCandies(60, 4);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    /**
     * 1 2 3 4
     * 
     * 
     */
}