package pl.horus.rekrutacja.test;

import org.junit.Before;
import org.junit.Test;
import pl.horus.rekrutacja.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestThreeLevelStructure {
    private MyStructure myStructure;
    private INode l2_c3;
    private INode l3_c7;
    private INode l2_c2;

    @Before
    public void setup() {
        INode l1_c7 = new Node("l1, c7", "l1, r7");

        INode l2_c1 = new Node("l2, c1", "l2, r1");
        ICompositeNode l1_c6 = new CompositeNode("l1, c6", "l1, r6", new ArrayList<>(Collections.singletonList(l2_c1)));

        INode l3_c6 = new Node("l3, c6", "l3, r6");
        l3_c7 = new Node("l3, c7", "l3, r7");

        l2_c2 = new CompositeNode("l2, c2", "l2, r2", new ArrayList<>(Arrays.asList(l3_c6, l3_c7)));
        l2_c3 = new Node("l2, c3", "l2, r3");

        INode l2_c4 = new Node("l2, c4", "l2, r4");
        ICompositeNode l1_c5 = new CompositeNode("l1, c5", "l1, r5", new ArrayList<>(Arrays.asList(l2_c2, l2_c3, l2_c4)));

        List<INode> nodes = new ArrayList<>(Arrays.asList(l1_c7, l1_c5, l1_c6));

        myStructure = new MyStructure(nodes);
    }

    @Test
    public void countTest() {
        assertEquals(9, myStructure.count());
    }

    @Test
    public void findLevel1Node() {
        assertEquals(l2_c3, myStructure.findByCode("l2, c3"));
    }

    @Test
    public void findLevel2Node() {
        assertEquals(l2_c3, myStructure.findByCode("l2, c3"));
    }

    @Test
    public void findLevel3Node() {
        assertEquals(l3_c7, myStructure.findByCode("l3, c7"));
    }
    @Test
    public void findCompositeAtLevel2Node() {
        assertEquals(l2_c2, myStructure.findByCode("l2, c2"));
    }

}
