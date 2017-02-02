import java.util.Scanner;
import java.util.Random;

/*
 * Created by Jeff Choi 2/1/2017
 * Lab 5 
*/


public class main {
    public static void printHeader() {
        System.out.println("Welcome to the Grand Circus Casino!");
        System.out.println("");
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int theRoll = 1;
        char rollAgain;
        boolean isSnake = false;
        boolean isBox = false;

        printHeader();

        while (true) {
            System.out.print("How many sides should each die have? ");
            int numSides = sc.nextInt();
            sc.nextLine();

            isSnake = false;
            isBox = false;

            System.out.println("Roll " + theRoll + ":");
            for (int i = 0; i < 2; i++) {
                int randNum = rn.nextInt(numSides) + 1;
                System.out.println(randNum);
                if (i == 0 && randNum == 1) {
                    isSnake = true;
                }
                else if (i == 1 && isSnake == true && randNum == 1) {
                    isSnake = true;
                }
                else if (i == 0 && randNum == 6) {
                    isBox = true;
                }
                else if (i == 1 && isBox == true && randNum == 6) {
                    isBox = true;
                }
                else {
                    isSnake = false;
                    isBox = false;
                }
            }

            if (isSnake) {
                System.out.println("Snake eyes!");
            }
            
            if (isBox) {
                System.out.println("Box car!");
            }

            while (true) {
                System.out.print("Roll again?(y/n): ");
                rollAgain = sc.next().charAt(0);

                if (rollAgain == 'y' || rollAgain == 'Y' || rollAgain == 'n' || rollAgain == 'N') {
                    break;
                }
                else {
                    System.out.println("Please enter y or n!"); 
                }
            }

            if (rollAgain == 'n' || rollAgain == 'N') {
                break; 
            }
        }
    }
}
