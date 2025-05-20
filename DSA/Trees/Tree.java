package DSA.Trees;

public class Tree {

    static class Node {
        int data;
        Node right, left;

        Node(int data) {
            this.right = this.left = null;
            this.data = data;
        }
    }

    static Node InsertNode(Node root , int data ){
        if(root == null ){
            return new Node(data);
        }
        if(data < root.data){
            root.left = InsertNode(root.left, data);
        }
        else{
            root.right = InsertNode(root.right, data);
        }
        return root ;
    }

    static void PrintTree(Node root){
        if(root != null){
            PrintTree(root.left);
            System.out.print(root.data + " -> ");
            PrintTree(root.right);
        }
    }

    public static void main (String [] args) {
        Node root = null;
        int values [] = {5,10,20,40 ,100,12};

        for(int val : values){
            root = InsertNode(root, val);
        }
        PrintTree(root);
    }



}
