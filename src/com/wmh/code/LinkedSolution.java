package com.wmh.code;

import java.util.*;

/**
 * Created by 周大侠
 * 2019-01-30 16:43
 */
public class LinkedSolution {



    /**
     * leetcode 237 删除链表中的节点 只给出 该节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    /**
     * leetcode 206 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newNode;
            newNode = head;
            head = next;
        }
        return newNode;
    }

    /**
     * leetcode 92  反转链表中第m到n个结点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preNode = null;
        ListNode result = head;
        int length = n - m + 1;
        while (head != null && --m > 0) {
            preNode = head;
            head = head.next;
        }
        ListNode postNode = head;
        ListNode newNode = null;
        while (head != null && length-- > 0) {
            ListNode next = head.next;
            head.next = newNode;
            newNode = head;
            head = next;
        }
        if (preNode == null) {
            result = newNode;
        } else {
            preNode.next = newNode;
        }
        postNode.next = head;


        return result;
    }

    /**
     * leetcode 19 删除链表中的第n个结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode head1 = dummy;
        int size = 0;
        while (head1.next != null) {
            size++;
            head1 = head1.next;
        }
        ListNode head2 = dummy;
        for (int i = 0; i < size - n; i++) {
            head2 = head2.next;
        }
        head2.next = head2.next.next;
        return dummy.next;
    }

    /**
     * leetcode 160 求两个链表的交点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new LinkedHashSet();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }


        return null;
    }

    /**
     * leetcode 160 求两个链表的交点 高效
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int sizeA = getListNodeSize(headA);
        int sizeB = getListNodeSize(headB);

        int length = sizeA - sizeB;

        if (length < 0) {
            headA = moveNode(headB, 0 - length);

        } else {
            headB = moveNode(headA, length);

        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;

        }

        return null;

    }

    /**
     * 移动指定个数的节点
     *
     * @param head
     * @param length
     * @return
     */
    private ListNode moveNode(ListNode head, int length) {
        while (length-- > 0) {
            head = head.next;
        }
        return head;
    }

    /**
     * 计算该链表长度
     *
     * @param head
     * @return
     */
    private int getListNodeSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    /**
     * leetcode 86 分割链表
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        ListNode minDummyHead = new ListNode(0);
        ListNode maxDummyHead = new ListNode(0);
        ListNode minNext = minDummyHead;
        ListNode maxNext = maxDummyHead;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                minNext.next = head;
                minNext = head;
            } else {
                maxNext.next = head;
                maxNext = head;
            }
            head = next;
        }
        minNext.next = maxDummyHead.next;

        return minDummyHead.next;
    }

    /**
     * leetcode 141 判断链表是否存在环 解法一 list集合 效率太低 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            }

            list.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * leetcode 141 判断链表是否存在环 解法二 快慢指针求解
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }

    /**
     * leetcode 142 判断链表是否存在环  返回该环的起点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {


        ListNode slowNode = head;
        ListNode fastNode = head;
        ListNode meetNode = null;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (fastNode == slowNode) {
                meetNode = fastNode;
                break;
            }
        }
        while (head != null && meetNode != null) {
            if (head == meetNode) {
                return meetNode;
            }
            head = head.next;
            meetNode = meetNode.next;
        }
        return null;
    }

    /**
     * leetcode 138 复制带随机指针的链表
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, Integer> map = new HashMap<>();
        RandomListNode newDummyNode = new RandomListNode(0);
        RandomListNode node = newDummyNode;
        int size = 0;
        RandomListNode head1 = head;
        while (head1 != null) {
            size++;
            node.next = new RandomListNode(head1.label);
            node = node.next;
            map.put(head1, size);
            head1 = head1.next;
        }
        RandomListNode newHead = newDummyNode.next;
        RandomListNode newHead1 = newHead;
        while (head != null) {
            if (head.random != null) {
                Integer integer = map.get(head.random);
                newHead1.random = findNode(newHead1, integer);
            }
            newHead1 = newHead1.next;
            head = head.next;
        }


        return newDummyNode.next;
    }

    /**
     * leetcode 21 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                node = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            node.next = l1;
            node = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            node.next = l2;
            node = l2;
            l2 = l2.next;
        }
        return dummyHead.next;

    }

    /**
     * leetcode 234 判断是否为回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode head1 = null;
        while(slow!=null){

            ListNode next = slow.next;
            slow.next = head1;
            head1 = slow;
            slow = next;
        }

        while(head!=null&&head1!=null){
            if(head.val!=head1.val){
                return false;
            }
            head =head.next;
            head1=head1.next;
        }
        return true;
    }





    /**
     * 查找指定位置所在的节点
     *
     * @return
     */
    private RandomListNode findNode(RandomListNode head, int site) {
        while (head != null && --site > 0) {

            head = head.next;
        }
        return head;


    }


}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

