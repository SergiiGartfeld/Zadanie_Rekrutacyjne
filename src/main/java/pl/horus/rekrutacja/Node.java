package pl.horus.rekrutacja;

public class Node implements INode{
    private String code;
    private String rendere;

    public Node(String code, String rendere) {
        this.code = code;
        this.rendere = rendere;
    }

    public String getCode() {
        return code;
    }

    public String getRenderer() {
        return rendere;
    }
}
