// Node structure
class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

// Linked List class
class LinkedList {
  constructor() {
    this.head = null;
  }

  // Add node at the end
  append(data) {
    const newNode = new Node(data);
    if (!this.head) {
      this.head = newNode;
      return;
    }
    let current = this.head;
    while (current.next) {
      current = current.next;
    }
    current.next = newNode;
  }

  // Display the list
  print() {
    let current = this.head;
    while (current) {
      console.log(current.data);
      current = current.next;
    }
  }

  // Delete a node with a specific value
  delete(data) {
    if (!this.head) return;

    if (this.head.data === data) {
      this.head = this.head.next;
      return;
    }

    let current = this.head;
    while (current.next && current.next.data !== data) {
      current = current.next; 
    }

    if (current.next) {
      current.next = current.next.next;
    }
  }
}

// Example usage
const list = new LinkedList();
list.append('Node 1');
list.append('Node 2');
list.append('Node 3');

list.print(); // Node 1, Node 2, Node 3

list.delete('Node 2');
list.print(); // Node 1, Node 3
