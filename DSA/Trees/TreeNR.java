package DSA.Trees;

public class TreeNR {
     class Node {
        int data;
        Node left , right ;
        Node(int data ){
            this.data = data ;
            this.left = this.right = null;
        }
    }

 
     public  Node addNode(Node root , int data ){
        if(root == null){
            return new Node(data);
        }
        if (root.data < data  ){
            root.right = addNode(root.right,data);
        }else{
            root.left = addNode(root.left, data);
        }
        return root ;
    }

     public void printTree(Node root){
        if(root != null){
            printTree(root.left);
            System.out.print(root.data + " -> ");
            printTree(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNR treeNR = new TreeNR();
        Node root = null;
        int values [] = {5,10,20,40 ,100,12};

        for(int val : values){
            root = treeNR.addNode(root, val);
        }
        treeNR.printTree(root);
    }
}
