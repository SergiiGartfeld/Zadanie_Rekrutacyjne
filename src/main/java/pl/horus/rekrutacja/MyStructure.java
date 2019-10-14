package pl.horus.rekrutacja;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure, ICompositeNode, INode {
    private String code;
    private String renderer;

    private List<INode> nodes;

    public MyStructure(String code, String renderer) {
        this(code, renderer, new ArrayList<>());
    }

    public MyStructure(String code, String renderer, List<INode> nodes) {
        this.code = code;
        this.renderer = renderer;
        this.nodes = nodes;
    }

    public INode findByCode(String code) {
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
        return getNodes().stream();
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

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }

    @Override
    public List<INode> getNodes() {
        List<INode>node = nodes.stream()
                .flatMap(iNode -> iNode.getNodes().stream())
                .collect(Collectors.toList());
        node.add(this);
        return node;
    }
}
