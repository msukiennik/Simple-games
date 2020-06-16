import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game_ComputerGuessNumber {

    public int numberFromUser;
    public int computerRandNumber;
    public int[] tableWithRandoms = new int[0];
    public int countOfChance = 10;
    public int max = 1000;
    public int mini = 0;


    //download number from user
    public void downloadUserNumberAndPlay() {
        System.out.println("Podaj jedną liczbę z zakresu 1-1000:");
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                numberFromUser = scan.nextInt();
                System.out.println("Podana przez Ciebie liczba to: " + numberFromUser + ". Podpowiadaj komputerowi tak aby zgadł. Ma 10 szans." + '\n');
                computerDrawNumberAndGuess();
            } catch (Exception e) {
                System.out.println("To nie jest liczba, proszę wpisać ponownie: ");
            }
        }
    }


    //show all draw numbers by computer
    public void showAllDrawnNumbers() {
        System.out.print("Wylosowane do tej pory liczby to: ");
        for (int k = 0; k <= tableWithRandoms.length - 1; k++) {
            System.out.print(tableWithRandoms[k] + "   ");
        }
        System.out.println("\n");
    }


    //method save drawn by computer numbers
    public void saveNumberToTable(int computerRandNumber) {
        int table[] = Arrays.copyOf(tableWithRandoms, tableWithRandoms.length + 1);
        table[table.length - 1] = computerRandNumber;
        tableWithRandoms = Arrays.copyOf(table, table.length);
    }


    //checking that number drawn by the computer isn't contain in table with all draw by computer numbers, if yes - drawn new, if no - take this number
    public int checkTheNumber(int computerRandNumber) {
        Random rand = new Random();
        for (int j = 0; j <= tableWithRandoms.length - 1; j++) {
            if (tableWithRandoms[j] == computerRandNumber) {
                computerRandNumber = rand.nextInt(max - mini) + mini;
            } else {
                saveNumberToTable(computerRandNumber);
                break;
            }
        }

        return computerRandNumber;
    }


    //computer is drawing the random number in scale 0-1000 and guess
    public void computerDrawNumberAndGuess() {
        Random random = new Random();
        for (int i = 0; i <= countOfChance; i++) {

            //drawing the number which locate in scale
            computerRandNumber = random.nextInt(max - mini) + mini;

            //check the number in table
            checkTheNumber(computerRandNumber);

            //show all drawn numbers by computer
            showAllDrawnNumbers();

            if (computerRandNumber == numberFromUser) {
                System.out.println("Komputer trafił! Koniec gry :)");
                break;

            } else {
                //save draw number
                saveNumberToTable(computerRandNumber);
                // give an information
                System.out.println("Komputer wylosował liczbę: " + computerRandNumber + " - nie trafił. Podpowiedz mu: (mniej / więcej)");
                Scanner scanInformations = new Scanner(System.in);
                String scanInfo = scanInformations.nextLine();

                //zmienia zakres losowania liczb dla komputera
                if (scanInfo.equals("mniej")) {
                    max = computerRandNumber;

                } else if (scanInfo.equals("więcej")) {
                    mini = computerRandNumber;
                }
            }

        }

        System.out.println("Komputer wykorzystał wszystkie szanse. Koniec gry! :(");

    }


   public void lotteryMachine () {
       System.out.println("Gra polega na tym, że podajesz dowolną liczbę z zakresu 1-1000. Komputer ma za zadanie zgadnąć jaką liczbę podałeś, jednak ma tylko 10 szans."
               + '\n' + "Po wylosowaniu liczby, podpowiadaj mu, czy następną liczbę powinien losować mniejszączy większą, aby mógł trafić." + '\n'
               + "(Komputer praktycznie zawsze trafia :D) Grajmy!" + '\n' + '\n');

       downloadUserNumberAndPlay();
   }


    public static void main(String[] args) {
        new Game_ComputerGuessNumber().lotteryMachine();
    }
}
