package cn.list;

/**
 * Created with IntelliJ IDEA.
 * Description: 链表
 * User: Think
 * Date: 2018-10-08
 * Time: 23:14
 */

public class Solition {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 链表解决是否回文串1
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = null;
        ListNode p4 = head;

        int length = 0;
        while (p4 != null) {
            p4 = p4.next;
            length++;
        }

        for (int i = 0; i < (length/2); i++) {
            p2 = p1.next;
            p1.next = p3;
            p3 = p1;
            p1 = p2;
        }

        if (length % 2 == 1) {
            p2 = p2.next;
        }

        while (p2 != null && p3 != null) {
            if (p2.val != p3.val) {
                return false;
            }
            p2 = p2.next;
            p3 = p3.next;
        }
        return true;
    }

    /**
     * 链表解决回文串（优化版 分步法）
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = null;
        ListNode p4 = head;

        while (p4 != null && p4.next != null) {
            p4 = p4.next.next;
            p2 = p1.next;
            p1.next = p3;
            p3 = p1;
            p1 = p2;
        }

        if (p4 != null && p4.next == null) {
            p2 = p2.next;
        }

        while (p2 != null && p3 != null) {
            if (p2.val != p3.val) {
                return false;
            }
            p2 = p2.next;
            p3 = p3.next;
        }
        return true;
    }

    /**
     * 链表反转
     */
    public ListNode reverseList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = null;
        ListNode p3 = null;

        while (p1 != null) {
            p2 = p1.next;
            p1.next = p3;
            p3 = p1;
            p1 = p2;
        }
        return p3;
    }

    /**
     * 移除链表指定元素
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(Integer.MAX_VALUE);
        node.next = head;

        ListNode p1 = node;
        while (p1 != null && p1.next != null) {
            if (p1.next.val == val) {
                p1.next = p1.next.next;
            } else {
                p1 = p1.next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode head = one;

        for (int i = 0 ; i < 20000; i++) {
            ListNode two = new ListNode(1);
            ListNode three = new ListNode(3);
            one.next = two;
            two.next = three;
            one = three;
        }

        long start1 = System.currentTimeMillis();
        System.out.println(isPalindrome(head));
        System.out.println(System.currentTimeMillis() - start1);


        long start = System.currentTimeMillis();
        System.out.println(isPalindrome2(head));
        System.out.println(System.currentTimeMillis() - start);

    }
}
