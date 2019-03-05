package com.wmh.code.linked;

import com.wmh.ListNode;

/**
 * 对链表进行归并排序
 */
class LeetCode148 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode less = head;
        ListNode fast = head;
        
        while(fast.next!=null&&fast.next.next!=null){
            less = less.next;
            fast = fast.next.next;
        }
        ListNode mid = less.next;
        less.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(mid);
        ListNode mergeNode = merge(l,r);
        return mergeNode;
        
    }
    public ListNode merge(ListNode node1,ListNode node2){
        
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while(node1!=null&&node2!=null){
            if(node1.val<node2.val){
                node.next = node1;
                node = node.next;
                node1 = node1.next;
            }else{
                node.next = node2;
                node = node.next;
                node2 = node2.next;
            }
        }
        if(node1!=null){
            node.next = node1;
        }
        if(node2!=null){
            node.next = node2;
        }
        return dummyHead.next;
        
        
    }
}