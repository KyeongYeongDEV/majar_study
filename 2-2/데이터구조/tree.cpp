#include<iostream>
using namespace std;

struct TreeNode{
    int data;
    TreeNode *left, *right;
};

//             15
//     4               20
//   1                16 25
TreeNode t1 = {1, NULL,NULL};
TreeNode t2 = {4,&t1,NULL};
TreeNode t3 = {16,NULL,NULL};
TreeNode t4 = {25,NULL,NULL};
TreeNode t5 = {20,&t3,&t4};
TreeNode t6 = {15,&t2,&t5};
TreeNode *root = &t6;

void inorder(TreeNode *root){ //중위 순회
    if(root){
        inorder(root->left);
        printf("%d -> ", root->data);
        inorder(root->right);
    }
}

void preorder(TreeNode *root){//전위 순회
    if(root){
        printf("%d -> ",root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(TreeNode *root){ //후위 순회
    if(root){
        postorder(root->left);
        postorder(root->right);
        printf("%d -> ",root->data);
    }
}

int main(){
    postorder(root);
}