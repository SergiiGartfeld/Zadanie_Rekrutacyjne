package pl.horus.rekrutacja.test;

import org.junit.Before;
import org.junit.Test;
import pl.horus.rekrutacja.INode;
import pl.horus.rekrutacja.INodeNotFound;
import pl.horus.rekrutacja.MyStructure;
import pl.horus.rekrutacja.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestFlatStructure {
    private static Node N1;
    private static Node N2;
    private static Node N3;

    private MyStructure myStructure;

    @Before
    public void setup() {
        N1 = new Node("c1", "r1");
        N2 = new Node("c2", "r2");
        N3 = new Node("c3", "r3");
        List<INode> nodes = new ArrayList<>(Arrays.asList(
                N1,
                N2,
                N3
        ));

        myStructure = new MyStructure(nodes);
    }

    @Test
    public void countTest() {
        assertThat(myStructure.count(), is(equalTo(3)));
    }

    @Test
    public void findByCodeTest() {
        assertThat(myStructure.findByCode("c1"), is(N1));
    }

    @Test
    public void findByRendererTest() {
        assertThat(myStructure.findByRenderer("r1"), is(N1));
    }

    @Test
    public void findByCodeTest_2() {
        assertThat(myStructure.findByCode("c2"), is(N2));
    }

    @Test
    public void findByRenderer2Test() {
        assertThat(myStructure.findByRenderer("r3"), is(N3));
    }

    @Test(expected = INodeNotFound.class)
    public void findNotExistCode() {
        myStructure.findByCode("c8").getCode();
    }

    @Test(expected = INodeNotFound.class)
    public void findNotExistRenderer() {
        myStructure.findByCode("r8").getRenderer();
    }

}

