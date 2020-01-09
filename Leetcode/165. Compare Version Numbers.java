class Solution {
    /*
     * 比较两个版本号 version1 和 version2。
     * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
     * 
     * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
     * 
     *  . 字符不代表小数点，而是用于分隔数字序列。
     * 
     * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
     * 
     * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和
     * 4。其第三级和第四级修订号均为 0。
     * 
     */
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");// 注意传入的是一个正则表达式
        String v2[] = version2.split("\\.");
        int i, j;
        for (i = 0, j = 0; i < v1.length && j < v2.length; i++, j++) {
            int t1 = Integer.parseInt(v1[i].trim());
            int t2 = Integer.parseInt(v2[j].trim());
            if (t1 > t2) {
                return 1;
            }
            if (t1 < t2) {
                return -1;
            }
        }
        while (i < v1.length) {
            if (Integer.parseInt(v1[i++].trim()) != 0) {
                return 1;
            }
        }
        while (j < v2.length) {
            if (Integer.parseInt(v2[j++].trim()) != 0) {
                return -1;
            }
        }
        return 0;
    }
}