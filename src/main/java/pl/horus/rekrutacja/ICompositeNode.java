package pl.horus.rekrutacja;

import java.util.List;

interface ICompositeNode extends INode {
    List<INode> getNodes();
}
