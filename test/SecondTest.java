
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
    static ArrayList<Node2<Integer>> a;
    static ArrayList<Node2<Integer>> b;
    static ArrayList<Node2<Integer>> c;
    static ArrayList<Node2<Integer>> d;
    static ArrayList<Node2<Integer>> e;

    @BeforeClass
    public static void reset() throws Exception {
        tree1 = new DirectedAcyclicGraph<>();
        a = new ArrayList<>();
        int dagSize = 7;
        for (int i = 0; i <= dagSize; i++) {
            a.add(new Node2<>(i));
        }

        tree1.root = a.get(1);
        a.get(1).addEdge(new Node2[] { a.get(2), a.get(3) });
        a.get(2).addEdge(new Node2[] { a.get(4), a.get(5) });
        a.get(3).addEdge(new Node2[] { a.get(6), a.get(7)});

        tree2 = new DirectedAcyclicGraph<>();
        b = new ArrayList<>();
        int dagSize2 = 3;
        for (int i = 0; i <= dagSize2; i++) {
            b.add(new Node2<>(i));
        }

        tree2.root = b.get(1);
        b.get(1).addEdge(b.get(2));
        b.get(1).addEdge(b.get(3));

        tree3 = new DirectedAcyclicGraph<>();
        c = new ArrayList<>();
        int dagSize3 = 15;
        for (int i = 0; i <= dagSize3; i++) {
            c.add(new Node2<>(i));
        }

        tree3.root = c.get(1);
        c.get(1).addEdge(new Node2[] { c.get(2), c.get(3), c.get(5), c.get(5) });
        c.get(2).addEdge(new Node2[] { c.get(6), c.get(7), c.get(8), c.get(9) });
        c.get(5).addEdge(new Node2[] { c.get(10), c.get(11), c.get(12), c.get(13) });
        c.get(6).addEdge(new Node2[] { c.get(14), c.get(15)});

        tree4 = new DirectedAcyclicGraph<>();
        d = new ArrayList<>();
        int dagSize4 = 1;
        for (int i = 0; i <= dagSize4; i++) {
            d.add(new Node2<>(i));
        }
        tree4.root = d.get(1);

        tree5 = new DirectedAcyclicGraph<>();
        e = new ArrayList<>();
        int dagSize5 = 3;
        for (int i = 0; i <= dagSize5; i++) {
            e.add(new Node2<>(i));
        }

        tree5.root = e.get(1);
        e.get(1).addEdge(new Node2[] { e.get(2), e.get(3) });

    }

    @Test
    public void testBuild() {
        assertNotNull("Tree 1", tree1);
        assertNotNull("Tree 2", tree2);
        assertNotNull("Tree 3", tree3);
        assertNotNull("Tree 4", tree4);
        assertNotNull("Tree 5", tree5);
    }

    @Test
    //TREE 1
    public void test1() {
        assertEquals("null,null => null", null, tree1.lowestCommonAncestor(null, null));
    }

    @Test
    //TREE 1
    public void test2() {
        assertEquals("a5,a6 => a1", a.get(1), tree1.lowestCommonAncestor(a.get(5), a.get(6)));
    }

    @Test
    //TREE 1
    public void test3() {
        assertEquals("a6,a5 => a1", a.get(1), tree1.lowestCommonAncestor(a.get(6), a.get(5)));
    }

    @Test
    //TREE 1
    public void test4() {
        assertEquals("a4,a5 => a2", a.get(2), tree1.lowestCommonAncestor(a.get(4), a.get(5)));
    }

    @Test
    //TREE 1
    public void test5() {
        assertEquals("a6,a6 => a3", a.get(3), tree1.lowestCommonAncestor(a.get(6), a.get(6)));
    }

    @Test
    //TREE 1
    public void test6() {
        assertEquals("a2,a3 => a1", a.get(1), tree1.lowestCommonAncestor(a.get(2), a.get(3)));
    }

    @Test
    //TREE 1
    public void test7() {
        assertEquals("a1,a1 => null", null, tree1.lowestCommonAncestor(a.get(1), a.get(1)));
    }

    @Test
    //TREE 1
    public void test8() {
        assertEquals("a1,a6 => null", null, tree1.lowestCommonAncestor(a.get(1), a.get(6)));
    }

    @Test
    //TREE 2
    public void test9() {
        assertEquals("null,null => null", null, tree2.lowestCommonAncestor(null, null));
    }

    @Test
    //TREE 2
    public void test10() {
        assertEquals("b3,b3 => b2", b.get(1), tree2.lowestCommonAncestor(b.get(3), b.get(3)));
    }

    @Test
    //TREE 2
    public void test11() {
        assertEquals("b2,b2 => b2", b.get(1), tree2.lowestCommonAncestor(b.get(2), b.get(2)));
    }

    @Test
    //TREE 2
    public void test12() {
        assertEquals("b2,b3 => b1", b.get(1), tree2.lowestCommonAncestor(b.get(2), b.get(3)));
    }

    @Test
    //TREE 2
    public void test13() {
        assertEquals("b3,b2 => b1", b.get(1), tree2.lowestCommonAncestor(b.get(3), b.get(2)));
    }

    @Test
    //TREE 2
    public void test14() {
        assertEquals("b1,b2 => null", null, tree2.lowestCommonAncestor(b.get(1), b.get(2)));
    }

    @Test
    //TREE 2
    public void test15() {
        assertEquals("b1,b3 => null", null, tree2.lowestCommonAncestor(b.get(1), b.get(3)));
    }

    @Test
    //TREE 3
    public void test16() {
        assertEquals("c3,c5 => c1", c.get(1), tree3.lowestCommonAncestor(c.get(3), c.get(5)));
    }

    @Test
    //TREE 3
    public void test17() {
        assertEquals("c2,c6 => c1", c.get(1), tree3.lowestCommonAncestor(c.get(2), c.get(6)));
    }

    @Test
    //TREE 3
    public void test18() {
        assertEquals("c15,c9 => c2", c.get(2), tree3.lowestCommonAncestor(c.get(15), c.get(9)));
    }

    @Test
    //TREE 3
    public void test19() {
        assertEquals("c14,c15 => c6", c.get(6), tree3.lowestCommonAncestor(c.get(14), c.get(15)));
    }

    @Test
    //TREE 4
    public void test20() {
        assertEquals("d1, d1 => null", null, tree4.lowestCommonAncestor(d.get(1), d.get(1)));
    }

    @Test
    //TREE 5
    public void test21() {
        assertEquals("e3,e2 => e1", e.get(1), tree5.lowestCommonAncestor(e.get(3), e.get(2)));
    }

}