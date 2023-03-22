package airports;

import java.util.Scanner;

public class CommandLineMaintainer {

    public String getSubstring() {
        System.out.println("Введите строку:");
        Scanner console = new Scanner(System.in);
        String inputData = console.nextLine();
        if (inputData == "!quit") {
            System.exit(0);
        }
        return inputData;
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