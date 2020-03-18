/*
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
*/
int minDepth(TreeNode *root)
{
    if (!root)
        return 0;
    if (!root->left && !root->right)
    {
        return 1;
    }

    int leftmin = 0, rightmin = 0;
    leftmin = minDepth(root->left);
    rightmin = minDepth(root->right);

    if (leftmin == 0 && rightmin == 0)
    {
        return 1;
    }
    else if (leftmin == 0 && rightmin != 0)
    {
        return rightmin + 1;
    }
    else if (leftmin != 0 && rightmin == 0)
        return leftmin + 1;
    else
        return min(leftmin, rightmin) + 1;
}