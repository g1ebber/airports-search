package Airports;

import java.io.File;

class Main {

    public static void main(String[] args) {

        //new AirportSearch(new FileHandler("airports.csv").getFile()).search(InputDataChecker.getColumn(args),new CommandLineMaintainer().getSubstring());

        FileHandler fileHandler = new FileHandler("airports.csv");
        AirportSearch airportSearch = new AirportSearch(fileHandler.getFile());
        airportSearch.search(Main.getColumn(args),new CommandLineMaintainer().getSubstring());
    }

    public static int getColumn(String[] args) {
        try {
            return Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

}