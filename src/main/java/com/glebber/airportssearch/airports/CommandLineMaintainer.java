package com.glebber.airportssearch.airports;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

public class CommandLineMaintainer {

    public String getSubstring() {
        System.out.println("Enter the line:");
        Scanner console = new Scanner(System.in);
        String inputData = console.nextLine();
        if ("!quit".equals(inputData)) {
            System.exit(0);
        }
        return inputData.toLowerCase();
    }

    public File getFile() {
        boolean fileExisting = false;
        File file = null;

        while (!fileExisting) {
            System.out.println("Enter the path to the file:");
            Scanner console = new Scanner(System.in);
            String inputData = console.nextLine();
            try {
                file = new File(inputData);
            } catch (InvalidPathException | NullPointerException ex) {
                System.out.println("The path to the file is uncorrected");
                this.getFile();
            }
            fileExisting = file.exists();
        }

        return file;
    }

    public void outputInformation(long time, int countMatches) {
        this.getMatches(countMatches);
        this.getTime(time);
    }

    public void getTime(long time) {
        System.out.println("Time spent searching: " + time );
    }

    public void getMatches(int countMatches) {
        System.out.println("Number of rows found: " + countMatches );
    }



}