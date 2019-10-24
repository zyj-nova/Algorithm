/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        if (root == NULL)
        {
            return {};
        }
        vector<vector<int>> res;
        queue<TreeNode *> q;
        q.push(root);
        while (!q.empty())
        {
            vector<int> level;
            //注意：每次队列都要弹出元素，队列长度是变化的
            int len = q.size();
            for (int i = 0; i < len; i++)
            {
                TreeNode *t = q.front();
                q.pop();
                level.push_back(t->val);
                if (t->left)
                    q.push(t->left);
                if (t->right)
                    q.push(t->right);
            }
            res.push_back(level);
        }
        return res;
    }
};