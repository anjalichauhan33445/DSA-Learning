class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

public class DeleteLC237 {
    public static void main(String[] args) {
        Solution obj = new Solution();

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode node = head.next;

        System.out.print("Original list: ");
        display(head);

        obj.deleteNode(node);

        System.out.print("After deleting node 5: ");
        display(head);
    }

    static void display(ListNode head) {
        ListNode p = head;

        while(p != null) {
            System.out.print(p.val);

            if(p.next != null) {
                System.out.print(" -> ");
            }

            p = p.next;
        }

        System.out.println();
    }
}