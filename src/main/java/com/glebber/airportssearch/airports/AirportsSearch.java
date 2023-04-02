package com.glebber.airportssearch.airports;

import com.glebber.airportssearch.prefixtree.Tree;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

public class AirportsSearch {

    private int matches;
    private long usedTime;
    private File file;
    private Tree valuesTree;


    public AirportsSearch(File file, int column) throws IOException {
        this.matches = 0;
        this.usedTime = 0;
        this.file = file;
        this.valuesTree = new Tree();

        BufferedReader csvReader = new BufferedReader(new FileReader(file));
        String row;
        Long bytesCount = (long) 0;
        column--;

        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            data[column] = data[column].replaceAll("\"", "").toLowerCase();

            valuesTree.add(data[column], bytesCount);
            row += "\n";
            bytesCount += row.getBytes("Cp1251").length;
        }
        csvReader.close();
    }

    public void search(String subString) throws IOException {
        matches = 0;
        usedTime = 0;

        Instant start = Instant.now();

        Map<Long,String> resultMap = valuesTree.findAll(subString);

        Instant finish = Instant.now();
        usedTime = Duration.between(start, finish).toMillis();

        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");

        for (long bytesCount:resultMap.keySet()) {
//            PrintWriter consoleOut = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"));
//            consoleOut.println(value + "[" + row + "]");
            String value = resultMap.get(bytesCount);
            randomAccessFile.seek(bytesCount);
            String row = randomAccessFile.readLine().replaceAll("\"\"", "\"");
            System.out.println(value + "[" + row + "]");
            matches++;
        }
        randomAccessFile.close();
    }


    public long getUsedTime() {
        return usedTime;
    }

    public int getMatches() {
        return matches;
    }
}