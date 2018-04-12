package src;

import java.util.HashMap;
import java.util.Set;

public class TopoCreate {

    public TopoCreate() {

    }

    public HashMap<Integer, Node> connected = new HashMap<Integer, Node>();

    public Node create() {   // return the starting node

        System.out.println("Creating topology...");
        ReadCSV readCSVComp = new ReadCSV();

        int nodeTotal = readCSVComp.getNodeId().length;
        int linkTotal = readCSVComp.getLinkFrom().length;


        for(int i = 0; i < nodeTotal; i++) {
            Node curNode = new Node(readCSVComp.getNodeId()[i]);
            connected.put((i+1), curNode);

            Integer neighborCnt = 0;
            for (int j = 0; j < linkTotal; j++) {
                if (readCSVComp.getLinkFrom()[j] == curNode.getId()) {
                    if(connected.containsKey(readCSVComp.getLinkTo()[j])) {
                        Node myNeighbor = connected.get(readCSVComp.getLinkTo()[j]);
                        curNode.addNeighbor(myNeighbor);
                        neighborCnt++;
                    } else {
                        Node myNeighbor = new Node(readCSVComp.getLinkTo()[j]);
                        curNode.addNeighbor(myNeighbor);
                        connected.put(myNeighbor.getId(), myNeighbor);
                        neighborCnt++;
                    }


                }
            }
            for (int j = 0; j < linkTotal; j++) {
                if (readCSVComp.getLinkTo()[j] == curNode.getId()) {
                    if(connected.containsKey(readCSVComp.getLinkFrom()[j])) {
                        Node myNeighbor = connected.get(readCSVComp.getLinkFrom()[j]);
                        curNode.addNeighbor(myNeighbor);
                        neighborCnt++;
                    } else {
                        Node myNeighbor = new Node(readCSVComp.getLinkFrom()[j]);
                        curNode.addNeighbor(myNeighbor);
                        connected.put(myNeighbor.getId(), myNeighbor);
                        neighborCnt++;
                    }
                }
            }

            System.out.println("Node " + (i+1) + " has " + neighborCnt + " neighbors");
            System.out.println("Node " + (i+1) + " 's neighbor list is:");
            HashMap<Integer, Node> neighbors = curNode.getNeighbors();
            Set<Integer> keys = neighbors.keySet();
            for(Integer k: keys){
                System.out.printf(k + ",");
            }
            System.out.print("\n");
        }

        System.out.println("connected size:" + connected.size());
        Set<Integer> keys = connected.keySet();
        for(Integer k: keys) {
            System.out.printf("%d,", k);
        }
        System.out.print("\n");

        return connected.get(9);  // return starting node
    }


    //getConnected returns a hashmap
    //key:id; value:Node(the struct defined in class Node)
    public HashMap<Integer, Node> getConnected() {
        System.out.println("original connected size:"+connected.size());
        return connected;
    }

};


