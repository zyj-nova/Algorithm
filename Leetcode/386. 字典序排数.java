import java.utils.*;
class Solution {
    /**
        本质上是一颗10叉树的先序遍历结果
        分别以1、2、3、4、5、6、7
        8、9为根节点，构成了9棵10叉树
                                        1
                                / / / / / \ \ \ \ \
                                0 1 2 3 4  5  6 7 8 9
                       / / / / / \ \ \ \      
                      0 1 2 3 4 5 6 7 8 9
     */
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        
        for(int i = 1; i <= 9; i++){
            dfs(i,n);
        }
        return res;
    }

    public void dfs(int cur, int n){
        if(cur > n)
            return ;
        res.add(cur);
        for(int i = 0; i <= 9; i++){
            dfs(cur * 10 + i, n);
        }
    }
}