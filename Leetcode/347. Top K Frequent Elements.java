class Solution {
    /*
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * 
     * 利用map统计频率，再维护一个大小为k的堆
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k)
                heap.poll();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            int tmp = heap.poll();
            ans.add(tmp);
        }
        Collections.reverse(ans);
        return ans;
    }
}