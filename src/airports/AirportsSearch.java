package airports;

import PrefixTree.Tree;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class AirportsSearch {

    private int matches;
    private long usedTime;
    private File file;
    private Tree valuesTree;


    public AirportsSearch(File file, int column) throws IOException {
        this.matches = 0;
        this.usedTime = 0;
        this.file = file;

        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        String row;
        Long bytesCount = (long) 0;

        while ((row = csvReader.readLine()) != null) {
            bytesCount += row.getBytes(StandardCharsets.UTF_8).length;
            String[] data = row.split(",");
            valuesTree.add(data[2], bytesCount);
        }
        csvReader.close();
    }

    public void search(String subString) throws IOException {
        long start = System.currentTimeMillis();

        Map<Long,String> result = valuesTree.findAll(subString);

        long finish = System.currentTimeMillis();
        usedTime = start - finish;

        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        //RandomAccessFile raf = new RandomAccessFile(file, "r");

        for (long currentByte:result.keySet()) {
            String value = result.get(currentByte);
            csvReader.skip(currentByte);
            String row = csvReader.readLine();
            System.out.println("\"" + value + "\"[" + row + "]");
        }
        csvReader.close();
    }


    public long getUsedTime() {
        return usedTime;
    }

    public int getMatches() {
        return matches;
    }
}