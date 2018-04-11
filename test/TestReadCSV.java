package test;

import src.ReadCSV;

public class TestReadCSV {

    public static void main(String[] args) {

        ReadCSV readCSVComp = new ReadCSV();

        String filePath1 = "/Users/beibei/Desktop/toy_node.csv";
        String filePath2 = "/Users/beibei/Desktop/toy_edge.csv";

        int[] num = readCSVComp.read(filePath1, filePath2);
        int[] nodeId = readCSVComp.getNodeId();
        int[] nodeType = readCSVComp.getNodeType();
        int[] nodeWeight = readCSVComp.getNodeWeight();

        int[] linkFrom = readCSVComp.getLinkFrom();
        int[] linkTo = readCSVComp.getLinkTo();
        int[] linkWeight = readCSVComp.getLinkWeight();
        int[] linkType = readCSVComp.getLinkType();

        for(int i = 0; i < num[0]; i++){
            System.out.printf("nodeId = %d  ", nodeId[i]);
            System.out.printf("nodeType = %d  ", nodeType[i]);
            System.out.printf("nodeWeight = %d\n", nodeWeight[i]);
        }
        System.out.print("\n");

        for(int j = 0; j < num[1]; j++) {
            System.out.printf("linkFrom = %d  ", linkFrom[j]);
            System.out.printf("linkTo = %d  ", linkTo[j]);
            System.out.printf("linkWeight = %d  ", linkWeight[j]);
            System.out.printf("linkType = %d\n", linkType[j]);
        }

    }

}
