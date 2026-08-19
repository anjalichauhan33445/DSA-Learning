
public class AddTwoNumbers{
    static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1,t2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int carry = 0;

        while(t1!=null || t2!=null){
            int sum = carry;
            if(t1!=null){
                sum+=t1.val;
            }
            if(t2!=null){
                sum+=t2.val;
            }
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            curr.next = newNode;
            curr = curr.next;

            if(t1!=null) t1 = t1.next;
            if(t2!=null) t2 = t2.next;
        }
        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
            curr = curr.next;
        }
        return dummyNode.next;
    }
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }

        System.out.println();
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        printList(result);
    }
}