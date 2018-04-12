package src;

import java.util.HashMap;
import java.util.Set;

public class TopoCreate {

    public TopoCreate() {

    }

    // graph: hashmap of the nodes in network
    // key: node id; value: node with the corresponding id
    private HashMap<Integer, Node> graph = new HashMap<Integer, Node>();

    // create(): add neighbors to each node and return the starting node
    public Node create() {

        System.out.println("Creating topology...");
        ReadCSV readCSVComp = new ReadCSV();


        int nodeTotal = readCSVComp.getNodeId().length;
        int linkTotal = readCSVComp.getLinkFrom().length;

        for(int i = 0; i < nodeTotal; i++) {

            Node curNode = null;

            // if node not in connected graph, create a new node with unique id
            // if node exits, take it as curNode
            if (!graph.containsKey(i+1)) {
                curNode = new Node(readCSVComp.getNodeId()[i]);
                graph.put((i + 1), curNode);  //graph is the constructed part
            } else {
                curNode = graph.get(i+1);
            }

            // for a given node, add its neighbors
            Integer neighborCnt = 0;

            // if this given node is the starting node of a link:
            for (int j = 0; j < linkTotal; j++) {
                if (readCSVComp.getLinkFrom()[j] == curNode.getId()) {

                    // if the other end of link is in graph, put it to curNode's neighbor
                    // if not, create a new node and add to curNode's neighbor
                    if(graph.containsKey(readCSVComp.getLinkTo()[j])) {
                        Node myNeighbor = graph.get(readCSVComp.getLinkTo()[j]);
                        curNode.addNeighbor(myNeighbor);
                        neighborCnt++;
                    } else {
                        Node myNeighbor = new Node(readCSVComp.getLinkTo()[j]);
                        curNode.addNeighbor(myNeighbor);
                        graph.put(myNeighbor.getId(), myNeighbor);
                        neighborCnt++;
                    }

                }
            }
            // if this given node is the end node of a link:
            for (int j = 0; j < linkTotal; j++) {
                if (readCSVComp.getLinkTo()[j] == curNode.getId()) {

                    // same as the part above
                    if(graph.containsKey(readCSVComp.getLinkFrom()[j])) {
                        Node myNeighbor = graph.get(readCSVComp.getLinkFrom()[j]);
                        curNode.addNeighbor(myNeighbor);
                        neighborCnt++;
                    } else {
                        Node myNeighbor = new Node(readCSVComp.getLinkFrom()[j]);
                        curNode.addNeighbor(myNeighbor);
                        graph.put(myNeighbor.getId(), myNeighbor);
                        neighborCnt++;
                    }
                }
            }

            // print out the neighbors of each node
            System.out.printf("Node " + (i+1) + " has " + neighborCnt + " neighbors, list is:");
            HashMap<Integer, Node> neighbors = curNode.getNeighbors();
            Set<Integer> keys = neighbors.keySet();
            for(Integer k: keys){
                System.out.printf(k + ",");
            }
            System.out.print("\n");
        }

        // print out all node ids in graph (all items in hashmap)
        System.out.println("graph size:" + graph.size());
        Set<Integer> keys = graph.keySet();
        for(Integer k: keys) {
            System.out.printf("%d,", k);
        }
        System.out.print("\n");

        return graph.get(9);  // return starting node
    }


    //getgraph returns a hashmap
    //key:id; value:Node(the struct defined in class Node)
    public HashMap<Integer, Node> getgraph() {
        System.out.println("original graph size:"+graph.size());
        return graph;
    }

};


