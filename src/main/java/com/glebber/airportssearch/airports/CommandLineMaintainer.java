package com.glebber.airportssearch.airports;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

public class CommandLineMaintainer {

    public String getSubstring() {
        System.out.println("Введите строку:");
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
            System.out.println("Введите путь к файлу:");
            Scanner console = new Scanner(System.in);
            String inputData = console.nextLine();
            try {
                file = new File(inputData);
            } catch (InvalidPathException | NullPointerException ex) {
                System.out.println("Путь к файлу неккоректен");
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
        System.out.println("Время затраченное на поиск: " + time );
    }

    public void getMatches(int countMatches) {
        System.out.println("Количество найденных строк: " + countMatches );
    }



}