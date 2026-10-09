class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    public Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        Node q = head;
        if(index < 0 || index >= count(q)) return -1;

        int ct = 0;
        while(ct < index) {
            ct++;
            q = q.next;
        }

        return q.data;
    }

    int count(Node p) {
        int ct = 0;
        while(p != null) {
            ct++;
            p = p.next;
        }
        return ct;
    }

    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
    }

    public void addAtTail(int val) {
        Node temp = new Node(val);

        if(head == null) {
            head = temp;
            return;
        }

        Node p = head;
        while(p.next != null) {
            p = p.next;
        }

        p.next = temp;
    }

    public void addAtIndex(int index, int val) {
        if(index <= 0) {
            addAtHead(val);
            return;
        }

        if(index > count(head)) return;

        Node p = head;
        int ct = 0;

        while(p != null && ct < index - 1) {
            ct++;
            p = p.next;
        }

        Node temp = new Node(val);
        temp.next = p.next;
        p.next = temp;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= count(head)) return;

        if(index == 0) {
            head = head.next;
            return;
        }

        Node p = head;
        for(int i = 0; i < index - 1; i++) {
            p = p.next;
        }

        p.next = p.next.next;
    }

    public void display() {
        Node p = head;
        while(p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();

        obj.addAtHead(10);
        obj.addAtTail(20);
        obj.addAtTail(30);
        obj.addAtIndex(1, 15);

        System.out.println("Linked list:");
        obj.display();

        System.out.println("Element at index 2: " + obj.get(2));

        obj.deleteAtIndex(1);

        System.out.println("After deleting index 1:");
        obj.display();

        obj.addAtIndex(1, 25);

        System.out.println("After inserting 25 at index 1:");
        obj.display();

        System.out.println("Element at index 5: " + obj.get(5));
    }
}