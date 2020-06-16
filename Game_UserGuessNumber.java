import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game_UserGuessNumber {

    public int userNumber;
    public int computerNumber;


    //computer draw a number
    public int computerDrawNumber () {
        Random random = new Random();
        computerNumber = random.nextInt(100);
        return computerNumber;
    }


    //user guess the number
    public void userGuessTheNumber () {
        System.out.println("Gra polega na tym, że komputer losuje liczbę, a Ty masz za zadanie zgadnąć co to za liczba!" + '\n' +
                "Po każdym podaniu liczby, komputer będzie podpowiadał czy podana przez Ciebie liczba jest za mała czy za duża. " +
                "Masz nieograniczoną liczbę szans :) Zagrajmy!" + '\n' + '\n' + "Komputer wylosował liczbę między 1 a 100. Podaj liczbę:");

        while(true) {
            Scanner scanNumber = new Scanner(System.in);

            try {
                userNumber = scanNumber.nextInt();

                if (userNumber == computerNumber) {
                    System.out.println("Gratulacje, zgadłeś! Komputer wylosował: " + computerNumber);
                } else {
                    if (userNumber < computerNumber) {
                        System.out.println("Za mało!");
                    } else if (userNumber > computerNumber) {
                        System.out.println("Za dużo!");
                    }
                }
            } catch (InputMismatchException var5) {
                System.out.println("To nie jest liczbą! Podaj jeszcze raz: ");
            }
        }

    }

    //play method
    public void play () {
        computerDrawNumber();
        userGuessTheNumber();
    }

    public static void main(String[] args) {
        new Game_UserGuessNumber().play();
    }
}