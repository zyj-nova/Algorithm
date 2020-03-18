/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
       if(root == NULL){
        return {};
    }
    vector<vector<int> > res;

    queue<TreeNode* > q;
    q.push(root);
    bool toleft = true;
    bool toright = false;
    vector<int> a;
    a.push_back(root->val);
    res.push_back(a);
    while(!q.empty()){
        //先向左，再向右，第一次向左
        int len = q.size();
        vector<int > level;
        stack<int> stac;
        for(int i = 0; i < len; i++){
            TreeNode *t = q.front();
            q.pop();
            if(toleft){
                if(t->left)
                    stac.push(t->left->val);
                if(t->right)
                    stac.push(t->right->val);
            }else if(toright){
                if(t->left)
                    level.push_back(t->left->val);
                if(t->right)
                    level.push_back(t->right->val);
            }
            if(t->left)
                q.push(t->left);
            if(t->right)
                q.push(t->right);
        }
        if(!stac.empty()){
            while(!stac.empty()){
                level.push_back(stac.top());
                stac.pop();
            }
                        }
        res.push_back(level);
        toleft = !toleft;
        toright = !toright;
    }
    res.pop_back();
    return res;
    }
};