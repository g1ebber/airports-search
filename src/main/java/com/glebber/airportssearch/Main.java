package com.glebber.airportssearch;

import com.glebber.airportssearch.airports.AirportsSearch;
import com.glebber.airportssearch.airports.CommandLineMaintainer;
import com.glebber.airportssearch.airports.FileHandler;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "Cp1251"));

        CommandLineMaintainer commandLineMaintainer = new CommandLineMaintainer();

        //C:\\Users\\glebber\\Desktop\\Renue\\airports-search\\src\\main\\resources\\airports.csv
        FileHandler fileHandler = new FileHandler(commandLineMaintainer.getFile());
        AirportsSearch airportsSearch = new AirportsSearch(fileHandler.getFile(), Main.getColumn(args));

        //OutputStreamWriter osw = new OutputStreamWriter(System.out);
        //System.out.println(osw.getEncoding());

        Main.searchSubstring(airportsSearch, commandLineMaintainer);

    }

    public static int getColumn(String[] args) {
        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public static void searchSubstring(AirportsSearch airportsSearch, CommandLineMaintainer commandLineMaintainer) throws IOException {
        airportsSearch.search(commandLineMaintainer.getSubstring());
        commandLineMaintainer.outputInformation(airportsSearch.getUsedTime(), airportsSearch.getMatches());
        Main.searchSubstring(airportsSearch, commandLineMaintainer);
    }

}