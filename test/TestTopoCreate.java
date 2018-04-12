package test;

import src.Node;
import src.TopoCreate;

public class TestTopoCreate {

    public static void main(String[] args) {

        TopoCreate nodeAssignComp = new TopoCreate();
        Node startNode = nodeAssignComp.create();
        System.out.println("start node is:" + startNode.getId());
    }
}