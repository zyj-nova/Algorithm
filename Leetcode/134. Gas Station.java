class Solution {
    /**
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * 
     * 
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 暴力
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int oil = gas[i] - cost[i];
            int j = i;
            j = (j + 1) % len;
            while (oil >= 0 && j != i) {
                oil = oil + gas[j] - cost[j];
                if (oil < 0)
                    break;
                j = (j + 1) % len;
            }
            if (j == i && oil >= 0)
                return i;

        }
        return -1;
    }
}