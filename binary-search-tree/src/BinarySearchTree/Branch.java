package BinarySearchTree;

public class Branch implements BinarySearchTree{

    private BinarySearchTree left;
    private int v;
    private BinarySearchTree right;

    public Branch(BinarySearchTree left, int v, BinarySearchTree right){
        this.left = left;
        this.v = v;
        this.right = right;
    }

    @Override
    public boolean find(int n) {
        if(n == v){return true;}
        else if (n < v){return left.find(n);}
        else {return right.find(n);}
    }
}
