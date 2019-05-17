/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
       ListNode *head,*node,*p;
    int num = 0,temp = 0;
    head = new ListNode(0);
    p = head ;
    while(l1 != NULL && l2 != NULL)
    {
        temp = l1->val + l2->val + num;
        node = new ListNode(temp % 10);
        p->next = node;
        p = node;
        num = temp / 10;
        l1 = l1->next;
        l2 = l2->next;
    }
    if(l1 == NULL && l2 != NULL) //l2长度大于l1，将l2剩下的加到res里
    {
        if(num){
            while(l2!=NULL){
                temp = num + l2->val;
                node = new ListNode(temp%10);
                p->next = node;
                p = node;
                l2 = l2->next;
                num = temp / 10;
            }
             while(num){
                node = new ListNode(num);
                p->next = node;
                num /= 10;
            }
        }else{
            while(l2 != NULL){
                node = new ListNode(l2->val);
                p->next = node;
                p = node;
                l2 = l2 ->next;
            }
        }
    }
    else if(l2 == NULL && l1 != NULL)
    {
         if(num){
            while(l1!= NULL){
               temp = num + l1->val;
                node = new ListNode(temp%10);
                p->next = node;
                p = node;
                l1 = l1->next;
                num = temp / 10;
            }
              while(num){
                node = new ListNode(num);
                p->next = node;
                num /= 10;
            }
        }else{
            while(l1!=NULL){
                node = new ListNode(l1->val);
                p->next = node;
                p = node;
                l1 = l1->next;
            }
        }
    }
    else  //两个链表一样长
    {
        if(num)
        {
            while(num)
            {
                node = new ListNode(num % 10);
                p->next = node;
                p = node;
                num /= 10;
            }
        }
    }

    return head->next;
    }
};