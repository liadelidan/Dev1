
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecondTest {

    static DirectedAcyclicGraph<Integer> tree1;
    static DirectedAcyclicGraph<Integer> tree2;
    static DirectedAcyclicGraph<Integer> tree3;
    static DirectedAcyclicGraph<Integer> tree4;
    static DirectedAcyclicGraph<Integer> tree5;
    static DirectedAcyclicGraph<Integer> tree6;
    static ArrayList<Node2<Integer>> a;
    static ArrayList<Node2<Integer>> b;
    static ArrayList<Node2<Integer>> c;
    static ArrayList<Node2<Integer>> d;
    static ArrayList<Node2<Integer>> e;
    static ArrayList<Node2<Integer>> f;

    @BeforeClass
    public static void reset() throws Exception {
        tree1 = new DirectedAcyclicGraph<>();
        a = new ArrayList<>();
        int AmountNodeDAG_A = 10;
        for (int i = 0; i <= AmountNodeDAG_A; i++) {
            a.add(new Node2<>(i));
        }

        tree1.root = a.get(1);
        a.get(1).addEdge(new Node2[] { a.get(2), a.get(3), a.get(4), a.get(5) });
        a.get(2).addEdge(new Node2[] { a.get(6), a.get(7), a.get(8) });
        a.get(3).addEdge(new Node2[] { a.get(6), a.get(8), a.get(9) });
        a.get(4).addEdge(new Node2[] { a.get(7), a.get(9), a.get(10) });
        a.get(5).addEdge(new Node2[] { a.get(8), a.get(10) });

        tree2 = new DirectedAcyclicGraph<>();
        b = new ArrayList<>();
        int AmountNodeDAG_B = 7;
        for (int i = 0; i <= AmountNodeDAG_B; i++) {
            b.add(new Node2<>(i));
        }

        tree2.root = b.get(1);
        b.get(1).addEdge(b.get(2));
        b.get(2).addEdge(new Node2[] { b.get(3), b.get(5) });
        b.get(3).addEdge(b.get(4));
        b.get(4).addEdge(b.get(7));
        b.get(5).addEdge(b.get(6));
        b.get(6).addEdge(b.get(7));

        tree2 = new DirectedAcyclicGraph<>();
        c = new ArrayList<>();
        int AmountNodeDAG_C = 18;
        for (int i = 0; i <= AmountNodeDAG_C; i++) {
            c.add(new Node2<>(i));
        }

        tree2.root = c.get(1);
        c.get(1).addEdge(new Node2[] { c.get(2), c.get(3), c.get(5), c.get(5) });
        c.get(2).addEdge(new Node2[] { c.get(6), c.get(7), c.get(8), c.get(9) });
        c.get(5).addEdge(new Node2[] { c.get(10), c.get(11), c.get(12), c.get(13) });
        c.get(6).addEdge(new Node2[] { c.get(14), c.get(15), c.get(16), c.get(17) });

        tree4 = new DirectedAcyclicGraph<>();
        d = new ArrayList<>();
        int AmountNodeDAG_D = 1;
        for (int i = 0; i <= AmountNodeDAG_D; i++) {
            d.add(new Node2<>(i));
        }
        tree4.root = d.get(1);

        tree5 = new DirectedAcyclicGraph<>();
        e = new ArrayList<>();
        int AmountNodeDAG_E = 3;
        for (int i = 0; i <= AmountNodeDAG_E; i++) {
            e.add(new Node2<>(i));
        }

        tree5.root = e.get(1);
        e.get(1).addEdge(new Node2[] { e.get(2), e.get(3) });

        tree6 = new DirectedAcyclicGraph<>();
        f = new ArrayList<>();
        int AmountNodeDAG_F = 4;
        for (int i = 0; i <= AmountNodeDAG_F; i++) {
            f.add(new Node2<>(i));
        }

        tree6.root = f.get(1);
        f.get(1).addEdge(f.get(2));
        f.get(2).addEdge(f.get(3));
        f.get(3).addEdge(f.get(4));
    }

    @Test
    public void testBuild() {
        assertNotNull("Tree 1", tree1);
        assertNotNull("Tree 2", tree2);
        assertNotNull("Tree 3", tree3);
        assertNotNull("Tree 4", tree4);
        assertNotNull("Tree 5", tree5);
        assertNotNull("Tree 6", tree6);
    }

    @Test
    public void test1() {
        // null returns null
        assertEquals("null,null => null", null, tree1.lowestCommonAncestor(null, null));
    }

    @Test
    public void test2() {
        // LCA of nodes of which one node is ancestor of the other node
        assertEquals("a3,a6 => a1", a.get(1), tree1.lowestCommonAncestor(a.get(3), a.get(6)));
    }

    @Test
    public void test3() {
        // LCA of nodes which are in different branches with different depth
        assertEquals("a6,a5 => a1", a.get(1), tree1.lowestCommonAncestor(a.get(6), a.get(5)));
    }

    @Test
    public void test4() {
        // LCA of nodes which are in different branches with same depth (highest depth)
        assertEquals("a6,a10 => a1", a.get(1), tree1.lowestCommonAncestor(a.get(6), a.get(10)));
    }

    @Test
    public void test5() {
        // LCA of nodes which have common ancestors on different levels of depths
        assertEquals("a6,a9 => a3", a.get(3), tree1.lowestCommonAncestor(a.get(6), a.get(9)));
    }

    @Test
    public void test6() {
        // LCA of two siblings
        assertEquals("a8,a9 => a3", a.get(3), tree1.lowestCommonAncestor(a.get(8), a.get(9)));
    }

    @Test
    public void test7() {
        // root node returns null
        assertEquals("a1,a1 => null", null, tree1.lowestCommonAncestor(a.get(1), a.get(1)));
    }

    @Test
    public void test8() {
        // LCA of root node and other node returns null
        assertEquals("a1,a6 => null", null, tree1.lowestCommonAncestor(a.get(1), a.get(6)));
    }

    @Test
    public void test9() {
        // null returns null
        assertEquals("null,null => null", null, tree2.lowestCommonAncestor(null, null));
    }

    @Test
    public void test10() {
        // LCA of nodes of which one node is ancestor of the other node
        assertEquals("b3,b4 => b2", b.get(2), tree2.lowestCommonAncestor(b.get(3), b.get(4)));
    }

    @Test
    public void test11() {
        // LCA of nodes which are in different branches with different depth
        assertEquals("b4,b6 => b2", b.get(2), tree2.lowestCommonAncestor(b.get(4), b.get(6)));
    }

    @Test
    public void test12() {
        // LCA of nodes which have common ancestors on different levels of depths
        assertEquals("b5,b7 => b2", b.get(2), tree2.lowestCommonAncestor(b.get(5), b.get(7)));
    }

    @Test
    public void test13() {
        // LCA of two siblings
        assertEquals("b3,b5 => b2", b.get(2), tree2.lowestCommonAncestor(b.get(3), b.get(5)));
    }

    @Test
    public void test14() {
        // root node returns null
        assertEquals("b1,b1 => null", null, tree2.lowestCommonAncestor(b.get(1), b.get(1)));
    }

    @Test
    public void test15() {
        // LCA of root node and other node returns null
        assertEquals("b1,b6 => null", null, tree2.lowestCommonAncestor(b.get(1), b.get(6)));
    }

    @Test
    public void test16() {
        // LCA of nodes of which one node is ancestor of the other node
        assertEquals("c14,c6 => c2", c.get(2), tree3.lowestCommonAncestor(c.get(14), c.get(6)));
    }

    @Test
    public void test17() {
        // LCA of nodes which are in different branches with different depth
        assertEquals("c16,c12 => c1", c.get(1), tree3.lowestCommonAncestor(c.get(16), c.get(12)));
    }

    @Test
    public void test18() {
        // LCA of nodes which have common ancestors on different levels of depths
        assertEquals("c17,c9 => c2", c.get(2), tree3.lowestCommonAncestor(c.get(17), c.get(9)));
    }

    @Test
    public void test19() {
        // LCA of two siblings
        assertEquals("c15,c16 => c6", c.get(6), tree3.lowestCommonAncestor(c.get(15), c.get(16)));
    }

    @Test
    public void test20() {
        // LCA of nodes of which one node is ancestor of the other node
        assertEquals("d1, d1 => null", null, tree4.lowestCommonAncestor(d.get(1), d.get(1)));
    }

    @Test
    public void test21() {
        // LCA of two siblings
        assertEquals("e2,e3 => e1", e.get(1), tree4.lowestCommonAncestor(e.get(2), e.get(3)));
    }

    @Test
    public void test22() {
        // LC doesn't exist
        assertEquals("e1,e2 => null", null, tree1.lowestCommonAncestor(e.get(1), e.get(2)));
    }

    @Test
    public void test23() {
        // LCA of two successors
        assertEquals("f3,f4 => f2", f.get(2), tree5.lowestCommonAncestor(f.get(3), f.get(4)));
    }

    @Test
    public void test24() {
        // LCA of two successors
        assertEquals("f2,f4 => f1", f.get(1), tree6.lowestCommonAncestor(f.get(2), f.get(4)));
    }

    @Test
    public void test25() {
        // LC doesn't exist
        assertEquals("f1,f4 => null", null, tree6.lowestCommonAncestor(f.get(1), f.get(4)));
    }

    @Test
    public void test26() {
        // LC doesn't exist
        assertEquals("f1,f1 => null", null, tree6.lowestCommonAncestor(f.get(1), f.get(1)));
    }
}