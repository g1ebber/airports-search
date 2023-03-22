package airports;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CommandLineMaintainer commandLineMaintainer = new CommandLineMaintainer();
        FileHandler fileHandler = new FileHandler("airports.csv");
        AirportsSearch airportsSearch = new AirportsSearch(fileHandler.getFile(), Main.getColumn(args));
        airportsSearch.search(commandLineMaintainer.getSubstring());
        commandLineMaintainer.outputInformation(airportsSearch.getUsedTime(), airportsSearch.getMatches());
        Main.main(args);
    }

    public static int getColumn(String[] args) {
        try {
            return Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

}