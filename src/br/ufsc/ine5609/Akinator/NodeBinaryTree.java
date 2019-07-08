package br.ufsc.ine5609.Akinator;

import java.io.Serializable;

public class NodeBinaryTree implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private boolean leaf;
    private String info;
    private NodeBinaryTree nodeYes;
    private NodeBinaryTree nodeNo;

    public NodeBinaryTree() {
        this.leaf = true;
        this.info = "";
        this.id = 1;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public NodeBinaryTree getNodeYes() {
        return nodeYes;
    }

    public void setNodeYes(NodeBinaryTree nodeYes) {
        this.nodeYes = nodeYes;
    }

    public NodeBinaryTree getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(NodeBinaryTree nodeNo) {
        this.nodeNo = nodeNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
