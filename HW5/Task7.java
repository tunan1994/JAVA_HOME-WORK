package HW5;

public class Task7 {
    public static void main(String[] args) {
        Node root = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n20 = new Node(20);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n3.left = n5;
        n3.right = n6;

        n4.left = n7;
        n4.mid = n8;
        n4.right = n9;

        n6.left = n11;
        n6.right = n20;
        // 1 2 4 7 9 3 5 6 11 20
        preOrder(root);
    }

    static void preOrder(Node tree) {
        if (tree != null)
            System.out.print(tree.value + "  ");
        else
            return;
        preOrder(tree.left);
        preOrder(tree.mid);
        preOrder(tree.right);
        }
    }
// nil
class Node {
    int value;

    public Node(int value) {
        this.value = value;
    }

    Node left;
    Node right;
    Node mid;
}