package DSA.Lists;

class Node1 {
    Node1 next, prev;
    int data;

    Node1(int val) {
        this.data = val;
        this.next = this.prev = null;
    }
}

public class DoublyLinkedList {

    Node1 head;

    public void addNodeAtStart(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addNodeAtEnd(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node1 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void PrintDBLL() {
        if (head == null) {
            return;
        }
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    public void printReverse() {
        Node1 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " <- ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void deleteNode(int data) {
        if (head == null)
            return;

        Node1 temp = head;
        if (temp.data == data) {
            head = temp.next;
            if (head != null)
                head.prev = null;
            return;
        }

        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null)
            return;
        if (temp.next != null)
            temp.next.prev = temp.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
    }


    public static void main(String[] args) {
        DoublyLinkedList db = new DoublyLinkedList();
        db.addNodeAtStart(10);
        db.addNodeAtStart(20);
        db.addNodeAtStart(40);
        db.addNodeAtEnd(50);
        db.addNodeAtEnd(60);
        db.deleteNode(50);
        db.PrintDBLL();
        System.out.println(" ");
        db.printReverse();
    }
}
