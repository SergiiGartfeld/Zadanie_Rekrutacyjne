package pl.horus.rekrutacja;

import java.util.Collections;
import java.util.List;

public class Node implements INode{
    private String code;
    private String renderer;

    public Node(String code, String rendere) {
        this.code = code;
        this.renderer = rendere;
    }

    public String getCode() {
        return code;
    }

    public String getRenderer() {
        return renderer;
    }

    @Override
    public List<INode> getNodes() {
        return Collections.singletonList(this);
    }
}
