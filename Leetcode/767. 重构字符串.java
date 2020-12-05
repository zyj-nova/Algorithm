class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        if(len == 0){
            return "";
        }
        int maps[] = new int[26], max_freq = 1;
        char ch[] = S.toCharArray();
        HashSet<Character> sets = new HashSet<>();
        for(int i = 0; i < len; i++){
            sets.add(ch[i]);
            maps[ch[i] - 'a']++;
            if (maps[ch[i] - 'a'] > max_freq){
                max_freq = maps[ch[i] - 'a'];
            }
        }
        if (len % 2 == 0 && max_freq > len / 2 || len % 2 == 1 && max_freq > len / 2 + 1){
            return "";
        }
        char res[] = new char[len];
        int evenIndex = 0, oddIndex = 1;
        // 按照每个字母的出现频率放置字母
        for (int i = 0; i < maps.length; i++){

            if (maps[i] > 0 && maps[i] <= len / 2 ){
                while (maps[i] > 0 && maps[i] <= len / 2 && oddIndex < len){
                    res[oddIndex] = (char)('a' + i);
                    maps[i]--;
                    oddIndex += 2;
                }

            }
            if (maps[i] > len / 2 || oddIndex >= len){
                while (maps[i] > 0 && evenIndex < len){
                    res[evenIndex] = (char)('a' + i);
                    maps[i]--;
                    evenIndex += 2;
                }
            }
        }
        return String.valueOf(res);
    }
}