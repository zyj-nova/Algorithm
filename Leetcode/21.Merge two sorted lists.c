/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if(l1 == NULL || l2 == NULL)
       return l1 == NULL? l2:l1;
    struct ListNode* p;
     struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    dummy->val = 0;
    p = dummy;
    while(l1 != NULL && l2 != NULL){
        if(l1->val <= l2->val){
            dummy->next = l1;
            l1 = l1->next;
        }else{
            dummy->next = l2;
            l2 = l2->next;
        }
        dummy = dummy->next;
    }
    if(l1 == NULL){
        dummy->next = l2;
    }else{
        dummy->next = l1;
    }
    return p->next;
}

