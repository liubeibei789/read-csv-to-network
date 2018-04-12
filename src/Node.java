// class Node: data structure for each node in the network
package src;

import java.util.HashMap;

public class Node {
    private int id;     //sequence number
    private int nodeCost; //processing delay
    private int type;   //1:sdn,2:legacy
    private HashMap<Integer, Node> neighbors = new HashMap<Integer, Node>();

    Node(int id) {
        this.id = id;
        neighbors = new HashMap<Integer, Node>(){};
    }

    public int getId() {
        return id;
    }
    public int getNodeCost() {
        return nodeCost;
    }
    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNodeCost(int cost) {
        this.nodeCost = nodeCost;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer addNeighbor(Node newNode) {
        neighbors.put(newNode.id, newNode);
        return neighbors.size();
    }

    public HashMap<Integer, Node> getNeighbors() {
        return neighbors;
    }
}

