import java.util.TreeMap;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
class Solution {
    //注意优先队列的使用
    public String frequencySort(String s) {
        TreeMap<Character,Integer> map = new TreeMap<>();
        char ch[] = s.toCharArray();
        for(char c:ch){
           map.put(c,map.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>((o1,o2)->{
           if (o1.getValue() == o2.getValue()){
               return o1.getKey().compareTo(o2.getKey());
           }
           return o2.getValue() - o1.getValue();
        });

        for (Map.Entry<Character,Integer> set:map.entrySet()){
            q.offer(set);
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()){
            Map.Entry<Character,Integer> entry = q.poll();
            int times = entry.getValue();
            for(int i = 0; i < times; i++)
                res.append(entry.getKey());
        }
        return res.toString();
        
    }
}