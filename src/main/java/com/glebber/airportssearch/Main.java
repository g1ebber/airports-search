package com.glebber.airportssearch;

import com.glebber.airportssearch.airports.AirportsSearch;
import com.glebber.airportssearch.airports.CommandLineMaintainer;
import com.glebber.airportssearch.airports.FileHandler;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CommandLineMaintainer commandLineMaintainer = new CommandLineMaintainer();
        FileHandler fileHandler = new FileHandler("C:\\Users\\glebber\\Desktop\\Renue\\airports-search\\src\\main\\resources\\airports.csv");
        AirportsSearch airportsSearch = new AirportsSearch(fileHandler.getFile(), Main.getColumn(args));
        airportsSearch.search(commandLineMaintainer.getSubstring());
        commandLineMaintainer.outputInformation(airportsSearch.getUsedTime(), airportsSearch.getMatches());
        Main.main(args);
    }

    public static int getColumn(String[] args) {
        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

}