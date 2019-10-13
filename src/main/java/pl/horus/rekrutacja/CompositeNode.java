package pl.horus.rekrutacja;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeNode extends Node implements ICompositeNode {
    private List<INode> nodes;

    public CompositeNode(String code, String renderer) {
        this(code, renderer, new ArrayList<>());
    }

    public CompositeNode(String code, String renderer, List<INode> nodes) {
        super(code, renderer);
        this.nodes = nodes;
    }

    @Override
    public List<INode> getNodes() {
        List<INode> node = nodes.stream()
                .flatMap(iNode -> iNode.getNodes().stream())
                .collect(Collectors.toList());

        node.add(this);

        return node;
    }
}
