package pl.horus.rekrutacja;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {
    private List<INode> nodes;

    public MyStructure() {
        nodes = new ArrayList<>();
    }

    public MyStructure(List<INode> nodes) {
        this.nodes = nodes;
    }

    public INode findByCode(final String code) {
        return getNodesStream()
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new INodeNotFound("INode with code: " + code + " was not found."));
    }

    /**
     * Dla każdego z węzłów potomków każemy zwrócić jego i każdy z podwęzłów.
     * @return stream węzłów i podwęzłów.
     */
    private Stream<INode> getNodesStream() {
        return nodes.stream()
                .flatMap(node -> node.getNodes().stream());
    }

    public INode findByRenderer(String renderer) {
        return getNodesStream()
                .filter(r -> r.getRenderer().equals(renderer))
                .findFirst()
                .orElseThrow(() -> new INodeNotFound("INode with code: " + renderer + " was not found."));
    }

    public int count() {
        return Math.toIntExact(getNodesStream().count());
    }

    public void addNode(Node node) {
        nodes.add(node);
    }
}
