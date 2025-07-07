package DSA.QueueAndStack;

public class Stack {
    public static int Fact(int n ){
        if(n==1 || n == 0){
            return 1;
        }
        return n * Fact(n-1);
    }

    public static void main(String[] args) {
        System.out.println(Fact(6));
    }
}
