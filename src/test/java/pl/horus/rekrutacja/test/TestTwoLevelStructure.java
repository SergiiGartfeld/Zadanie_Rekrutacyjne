package pl.horus.rekrutacja.test;

import org.junit.Before;
import org.junit.Test;
import pl.horus.rekrutacja.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestTwoLevelStructure {
    private MyStructure myStructure;
    private INode n3;
    private ICompositeNode cn2;

    @Before
    public void setup() {
        INode n5 = new Node("l1, c7", "l1, r7");

        INode n1 = new Node("l2, c1", "l2, r1");
        cn2 = new CompositeNode("l1, c6", "l1, r6", new ArrayList<>(Collections.singletonList(n1)));

        INode n2 = new Node("l2, c2", "l2, r2");
        n3 = new Node("l2, c3", "l2, r3");
        INode n4 = new Node("l2, c4", "l2, r4");
        ICompositeNode cn1 = new CompositeNode("l1, c5", "l1, r5", new ArrayList<>(Arrays.asList(n2, n3, n4)));

        List<INode> nodes = new ArrayList<>(Arrays.asList(n5, cn1, cn2));

        myStructure = new MyStructure(nodes);
    }

    @Test
    public void countTest() {
        assertEquals(7, myStructure.count());
    }

    @Test
    public void findLevel2Node() {
        assertEquals(n3, myStructure.findByCode("l2, c3"));
    }

    @Test
    public void findLevel1Node() {
        assertEquals(cn2, myStructure.findByRenderer("l1, r6"));
    }
}

