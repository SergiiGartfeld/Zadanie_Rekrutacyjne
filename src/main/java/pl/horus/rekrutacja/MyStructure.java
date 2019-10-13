package pl.horus.rekrutacja;

import java.util.ArrayList;
import java.util.List;

public class MyStructure implements IMyStructure {
    private List<INode> nodes;

    public MyStructure(){
        nodes = new ArrayList<>();
    }

   

    public INode findByCode(final String code) {
        return nodes.stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new INodeNotFound("INode with code: " + code + " was not found."));
    }

    public INode findByRenderer(String renderer) {
        return nodes.stream()
                .filter(c -> c.getCode().equals(renderer))
                .findFirst()
                .orElseThrow(() -> new INodeNotFound("INode with code: " + renderer + " was not found."));
    }

    public int count() {
        return 0;
    }

    public void addNode(Node node){
        nodes.add(node);
    }
}
