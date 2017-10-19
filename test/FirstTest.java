import org.junit.Assert;
import org.junit.Test;

public class FirstTest {
    @Test
    public void firstTest() {
        System.out.println("First Test: ");
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    }
    @Test
    public void secondTest() {
        System.out.println("Second Test: ");
        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        int n1 = 1, n2 = 1;
        Node t = tree2.lca(tree2.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }
    @Test
    public void thirdTest() {
        System.out.println("Third Test: ");
        BinaryTree tree3 = new BinaryTree();
        tree3.root = new Node(1);
        int n1 = 1, n2 = 1;
        Node t = tree3.lca(tree3.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }
}