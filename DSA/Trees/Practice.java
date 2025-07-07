package DSA.Trees;

public class Practice {
    class Node {
        int data ;
        Node left ;
        Node right ;
        Node(int data){
            this.data = data ;
        }
    }
    Node root ;

    public void insertRec(int data ){
        root = insert(root, data);
    }

    public Node insert(Node root , int data ){
        if(root == null){
             root =  new Node(data);
        }
        else if (data < root.data){
              root.left = insert(root.left , data);
        }
        else{
            root.right = insert(root.right , data );
        }
        return root;
       
    }

    public void printTREE(){
        printTree(root);
    }

    public void printTree(Node root){
        if(root != null){
            printTree(root.left);
            System.out.print(root.data + " -> ");
            printTree(root.right);
        }
    }
    public static void main(String[] args) {
        Practice p = new Practice();
        p.insertRec(10);
        p.insertRec(20);
        p.insertRec(10);
        p.printTREE();
    }
}
