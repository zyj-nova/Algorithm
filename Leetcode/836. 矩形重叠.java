class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 不妨令rec1为A，rec2为B A不动，考虑A与B不重叠的情形 ，画个图更清晰
        // B在A的上面 B在A的右面 B在A的下面 B在A的左边
        // 其实rec1、rec2谁为A谁为B都无所谓，因为rec1在rec2的上面，换据说就是rec2在rec1的下面，其他同理
        return !(rec2[1] >= rec1[3] || rec2[0] >= rec1[2] || rec2[3] <= rec1[1] || rec2[2] <= rec1[0]);
    }
}