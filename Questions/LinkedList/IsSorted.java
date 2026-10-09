class Node {
    public int data;
    public Node next;

    public Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    public boolean isSorted(Node head) {
        Node p = head;

        if(head == null || head.next == null) return true;

        boolean asc = true;
        boolean dec = true;

        while(p.next != null) {
            if(p.data > p.next.data) asc = false;
            if(p.data < p.next.data) dec = false;

            if(!asc && !dec) return false;

            p = p.next;
        }

        return true;
    }
}

public class IsSorted {
    public static void main(String[] args) {
        Solution obj = new Solution();

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        System.out.println("List 1: 1 -> 2 -> 3");
        System.out.println("Is sorted: " + obj.isSorted(head1));

        Node head2 = new Node(5);
        head2.next = new Node(3);
        head2.next.next = new Node(1);

        System.out.println("\nList 2: 5 -> 3 -> 1");
        System.out.println("Is sorted: " + obj.isSorted(head2));

        Node head3 = new Node(1);
        head3.next = new Node(3);
        head3.next.next = new Node(2);

        System.out.println("\nList 3: 1 -> 3 -> 2");
        System.out.println("Is sorted: " + obj.isSorted(head3));

        Node head4 = new Node(4);
        head4.next = new Node(4);
        head4.next.next = new Node(4);

        System.out.println("\nList 4: 4 -> 4 -> 4");
        System.out.println("Is sorted: " + obj.isSorted(head4));

        System.out.println("\nList 5: Empty list");
        System.out.println("Is sorted: " + obj.isSorted(null));
    }
}