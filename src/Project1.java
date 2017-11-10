//
// Name : Liad Elidan, ID : 17316414
//
// Software Engineering Development Project 1
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

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

class Node2<T> {
    T data;
    Set<Node2<T>> adj;

    public Node2(T data) {
        this.data = data;
        this.adj = new HashSet<>();
    }

    public void addEdge(Node2<T> node) {
        adj.add(node);
    }
    public void addEdge (Node2[] nodes) {
        for (Node2 node : nodes) {
            adj.add(node);
        }
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
        if (n1<=0 || n2<=0)
        {
            return null;
        }
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

class DirectedAcyclicGraph<T> {
    Node2<T> root;

    public Node2<T> lowestCommonAncestor(Node2<T> one, Node2<T> two) {
        return lowestCommonAncestor(root, one, two);
    }

    public Node2<T> lowestCommonAncestor(Node2<T> node, Node2<T> one, Node2<T> two) {
        if (node == null || one == null || two == null) {
            return null;
        }
        List<Node2<T>> list1 = dfs(node, one, new ArrayList<>(), new Stack<>());
        List<Node2<T>> list2 = dfs(node, two, new ArrayList<>(), new Stack<>());
        if (list1 == null || list2 == null) {
            return null;
        }
        List<Node2<T>> minList;
        List<Node2<T>> maxList;
        if (list1.size() <= list2.size()) {
            minList = list1;
            maxList = list2;
        } else {
            minList = list2;
            maxList = list1;
        }
        Set<Node2<T>> set = new HashSet<>();
        for (Node2<T> n : minList) {
            set.add(n);
        }
        for (int i = maxList.size() - 1; i >= 0; i--) {
            if (set.contains(maxList.get(i))) {
                return maxList.get(i);
            }
        }
        return null;
    }

    private List<Node2<T>> dfs(Node2<T> node, Node2<T> target, List<Node2<T>> list, Stack<Node2<T>> stack) {
        stack.push(node);
        for (Node2<T> n : node.adj) {
            if (n.equals(target)) {
                list.addAll(stack);
                return list;
            }
            dfs(n, target, list, stack);
        }
        stack.pop();
        return list;
    }
}