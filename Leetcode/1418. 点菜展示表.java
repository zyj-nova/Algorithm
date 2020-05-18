class Solution {
    /*
     * 如果想到用map容易敲出大致代码，但还有些细节需要注意 如果正式比赛限时恐怕写完调试得花好长时间，我太菜....
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<List<String>>();
        TreeMap<Integer, TreeMap<String, Integer>> map = new TreeMap<>();
        for (List<String> tmp : orders) {
            if (map.containsKey(Integer.valueOf(tmp.get(1)))) {
                // 取出存放菜品的map
                TreeMap<String, Integer> item = map.get(Integer.valueOf(tmp.get(1)));
                // 是否包含这个菜，不包含就默认为0；
                int count = item.getOrDefault(tmp.get(2), 0);
                // 更新数量
                item.put(tmp.get(2), count + 1);
            } else {
                // 存放菜品数量的map
                TreeMap<String, Integer> item = new TreeMap<String, Integer>();
                item.put(tmp.get(2), 1);
                map.put(Integer.valueOf(tmp.get(1)), item);
            }
        }

        List<String> head = new ArrayList<String>();
        ans.add(head);
        for (Map.Entry<Integer, TreeMap<String, Integer>> entry : map.entrySet()) {
            for (Map.Entry<String, Integer> e : entry.getValue().entrySet()) {
                if (head.contains(e.getKey())) {
                    continue;
                }
                head.add(e.getKey().toString());
            }
        }
        Collections.sort(head);

        // 再次遍历，计算各个菜品数量
        for (Map.Entry<Integer, TreeMap<String, Integer>> entry : map.entrySet()) {
            List<String> cnList = new ArrayList<>();
            cnList.add(entry.getKey().toString());
            // 将桌号放入
            for (String name : head) {

                if (entry.getValue().containsKey(name)) {
                    cnList.add(entry.getValue().get(name).toString());
                } else {
                    cnList.add("0");
                }
            }
            ans.add(cnList);

        }
        head.add(0, "Table");
        return ans;
    }
}