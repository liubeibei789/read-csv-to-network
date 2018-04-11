


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

//    public ReadCSV(String filePath1, String filePath2) {
//        System.out.println("reading csv files...");
//        read(filePath1, filePath2);
//    }

    public ReadCSV() {
        System.out.println("reading default csv files...");
        String filePath1 = "/Users/beibei/Desktop/toy_node.csv";
        String filePath2 = "/Users/beibei/Desktop/toy_edge.csv";
        read(filePath1, filePath2);
    }

    public int[] read(String filePath1, String filePath2){

        int i = 0, j = 0;
        int[] num = new int[2];
        try {
            CsvReader csvReader = new CsvReader(filePath1);
            csvReader.readHeaders();
            System.out.println("node raw data:");

            while (csvReader.readRecord()){
                System.out.printf("i=%d,",i);
                System.out.println(csvReader.getRawRecord());
                nodeId[i] = Integer.parseInt(csvReader.get("id"));
                nodeType[i] = Integer.parseInt(csvReader.get("type"));
                nodeWeight[i] = Integer.parseInt(csvReader.get("weight"));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            CsvReader csvReader2 = new CsvReader(filePath2);
            csvReader2.readHeaders();
            System.out.println("link raw data:");

            while (csvReader2.readRecord()){
                System.out.println(csvReader2.getRawRecord());
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

    // nodes:
    public int [] getNodeId() {
        return nodeId;
    }
    public int [] getNodeType() {
        return nodeType;
    }
    public int [] getNodeWeight() {
        return nodeWeight;
    }

    // links:

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

