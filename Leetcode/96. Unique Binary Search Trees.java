class Solution {
    // 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
    public int numTrees(int n) {
        // 动态规划：以i节点为根的二叉树种类等于以 1 to i-1 为结点 和 i+1 to n为结点的笛卡尔积
        // 因此可以利用memo的形式记录前结点的种数，再求和。
        int G[] = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                G[i] += G[j] * G[i - j - 1];
            }
        }
        return G[n];
    }
}