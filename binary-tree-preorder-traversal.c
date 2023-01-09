/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */


int outputSize = 0;
int* arr = NULL;

void preorder(struct TreeNode* root) {
    if (root == NULL) return;
    outputSize++;
    int *tmp = realloc(arr, sizeof(int)*outputSize);
    tmp[outputSize-1] = root->val;
    arr = tmp;
    preorder(root->left);
    preorder(root->right);
}
int* preorderTraversal(struct TreeNode* root, int* returnSize){
    // clear arr and outputSize init 
    free(arr);
    outputSize = 0;
    arr = NULL;

    preorder(root);
    *returnSize = outputSize;
    return arr;
}
