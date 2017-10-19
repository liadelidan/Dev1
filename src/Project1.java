//
// Name : Liad Elidan, ID : 17316414
//
// Software Engineering Development project 1
//
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;

    /* Function to find LCA of n1 and n2. The function assumes that both
       n1 and n2 are present in BST */
    Node lca(Node node, int n1, int n2)
    {
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2)
            return lca(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2)
            return lca(node.right, n1, n2);

        return node;
    }

    public static void main(String args[])
    {
    }
}