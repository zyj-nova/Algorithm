class Solution {
    /**
     * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。
     * 
     * 拿掉最后一块石头的人就是获胜者。你作为先手。
     * 
     * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
     * 
     * 真操蛋....
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    // 递归会爆栈
    boolean helper(int num, boolean flag) {
        if (num <= 3 && flag) {
            return true;
        }
        if (num <= 3 && !flag)
            return false;
        return helper(num - 1, !flag) || helper(num - 2, !flag) || helper(num - 3, !flag);
    }
}
