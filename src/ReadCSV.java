// this class reads the directories of CSV files,
// which contains node information and link information,
// to create a network

// node type: 1:sdn switch; 2:legacy switch
// link type: 1:sdn-sdn link; 2:legacy-legacy link; 3:sdn-legacy link
// linkFrom:start node; linkTo:end node
// -1:start host,-2:end host

package src;

import com.csvreader.CsvReader;

import java.io.IOException;

public class ReadCSV {

    private int[] nodeId = new int[22];
    private int[] nodeType = new int[22];
    private int[] nodeWeight = new int[22];

    private int[] linkFrom = new int[30];
    private int[] linkTo = new int[30];
    private int[] linkWeight = new int[30];
    private int[] linkType = new int[30];

    public ReadCSV(String filePath1, String filePath2) {
        System.out.println("reading csv files...");
        read(filePath1, filePath2);
    }

    public ReadCSV() {
        System.out.println("reading default csv files...");
        String filePath1 = "./toy_node.csv";
        String filePath2 = "./toy_edge.csv";
        read(filePath1, filePath2);
    }

    public int[] read(String filePath1, String filePath2){

        int i = 0, j = 0;  //i:index for nodes;j:index for links
        int[] num = new int[2];//total number of nodes and links

        //================= take node info ===================
        try {
            CsvReader csvReader = new CsvReader(filePath1);
            csvReader.readHeaders();
            //uncomment the following 3 lines with *, if you want to see raw csv records
            //System.out.println("node raw data:");   //*

            while (csvReader.readRecord()){
                //System.out.printf("i=%d,",i);  //*
                //System.out.println(csvReader.getRawRecord());  //*
                nodeId[i] = Integer.parseInt(csvReader.get("id"));
                nodeType[i] = Integer.parseInt(csvReader.get("type"));
                nodeWeight[i] = Integer.parseInt(csvReader.get("weight"));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //================= take link info ===================
        try {
            CsvReader csvReader2 = new CsvReader(filePath2);
            csvReader2.readHeaders();
            //uncomment the following 2 lines with *, if you want to see raw csv records
            //System.out.println("link raw data:");    //*

            while (csvReader2.readRecord()){
                //System.out.println(csvReader2.getRawRecord());   //*
                linkFrom[j] = Integer.parseInt(csvReader2.get("from"));
                linkTo[j] = Integer.parseInt(csvReader2.get("to"));
                linkWeight[j] = Integer.parseInt(csvReader2.get("weight"));
                linkType[j] = Integer.parseInt(csvReader2.get("type"));
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        num[0] = i;
        num[1] = j;

        return num;
    }

    //------------- output node info -------------
    public int [] getNodeId() {
        return nodeId;
    }
    public int [] getNodeType() {
        return nodeType;
    }
    public int [] getNodeWeight() {
        return nodeWeight;
    }

    //------------- output link info -------------
    public int [] getLinkFrom() {
        return linkFrom;
    }
    public int [] getLinkTo() {
        return linkTo;
    }
    public int [] getLinkWeight() {
        return linkWeight;
    }
    public int [] getLinkType() {
        return linkType;
    }
}

