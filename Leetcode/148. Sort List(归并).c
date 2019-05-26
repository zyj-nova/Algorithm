
struct ListNode
{
    int val;
    struct ListNode *next;
};
struct ListNode *mergeTwoLists(struct ListNode *l1, struct ListNode *l2)
{
    if (l1 == NULL || l2 == NULL)
        return l1 == NULL ? l2 : l1;
    struct ListNode *p;
    struct ListNode *dummy = (struct ListNode *)malloc(sizeof(struct ListNode));
    dummy->val = 0;
    p = dummy;
    while (l1 != NULL && l2 != NULL)
    {
        if (l1->val <= l2->val)
        {
            dummy->next = l1;
            l1 = l1->next;
        }
        else
        {
            dummy->next = l2;
            l2 = l2->next;
        }
        dummy = dummy->next;
    }
    if (l1 == NULL)
    {
        dummy->next = l2;
    }
    else
    {
        dummy->next = l1;
    }
    return p->next;
}

struct ListNode *sortList(struct ListNode *head)
{
    if (head == NULL || head->next == NULL)
        return head;
    struct ListNode *fast;
    struct ListNode *slow;
    struct ListNode *right;
    fast = head;
    slow = head;
    while (fast->next != NULL)
    {
        fast = fast->next->next;
        if (fast == NULL)
            break;
        slow = slow->next;
    }
    //slow 指针代表了链表的中间节点
    right = slow->next;
    //断开
    slow->next = NULL;

    head = sortList(head);
    right = sortList(right);
    return mergeTwoLists(head, right);
}
