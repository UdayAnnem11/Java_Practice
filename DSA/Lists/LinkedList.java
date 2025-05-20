package DSA.Lists;


class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}
public class LinkedList {
    Node head;

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next ;
        }
        current.next = newNode;

    }

    public void addAtStart(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


    public void deleteNodeAtStart() {
        if(head == null || head.next == null){
            return;
        }
        head = head.next;
    }

    public void deleteNodeAtEnd() {
        if(head == null || head.next == null){
            return ;
        }
        Node current = head ;
        while (current.next.next != null) {
            current = current.next ;
        }
        current.next = null;
        
    }

    public void printList() {
        Node current = head;
        

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.addAtStart(5);
        // list.deleteNodeAtStart();
        // list.deleteNodeAtStart();
        //list.deleteNodeAtEnd();

        list.printList();
        Node head = list.reverse();
        list.printList(head);
    }
}
