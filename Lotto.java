import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {
        System.out.println("Proszę podać 6 liczb z zakresu 1-49, oddzielając je odstępami:");
        Scanner scanner = new Scanner(System.in);
        String scanUser = scanner.nextLine();
        String[] tableUser = scanUser.split(" ");


        int[] randomNumbers = new int[6];
        Random random = new Random();


        int equals;
        for(equals = 0; equals < randomNumbers.length; equals++) {
            randomNumbers[equals] = random.nextInt(49);
        }

        System.out.println(Arrays.toString(randomNumbers));
        equals = 0;

        for(int k = 0; k < tableUser.length; ++k) {
            for(int l = 0; l < randomNumbers.length; ++l) {
                if (tableUser[k].equals(randomNumbers[l])) {
                    ++equals;
                }
            }
        }

        switch(equals) {
            case 0:
                System.out.println("Nic nie trafiłeś!");
                break;
            case 1:
                System.out.println("Brak wygranej");
                break;
            case 2:
                System.out.println("Brak wygranej");
                break;
            case 3:
                System.out.println("Trafiłeś 3!");
                break;
            case 4:
                System.out.println("Trafiłeś 4!");
                break;
            case 5:
                System.out.println("Trafiłeś 5!");
                break;
            case 6:
                System.out.println("Trafiłeś 6!");
        }

    }
}
