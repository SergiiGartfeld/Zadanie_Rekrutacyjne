package pl.horus.rekrutacja;

import java.util.List;

public interface INode {
    String getCode();
    String getRenderer();

    List<INode> getNodes();
}
