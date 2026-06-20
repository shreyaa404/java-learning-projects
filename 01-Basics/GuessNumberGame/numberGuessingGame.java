import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {

        int num = (int) (Math.random() * 100) + 1;
        Scanner sc = new Scanner(System.in);

        boolean won = false;

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nAttempt " + i + "/5");
            System.out.print("Guess a number between 1 and 100: ");

            int g_num = sc.nextInt();

            if (g_num < 1 || g_num > 100) {
                System.out.println("Invalid number! It must be between 1 and 100.");
            }
            else if (g_num < num) {
                System.out.println("Your guessed number is smaller than the actual number.");
            }
            else if (g_num > num) {
                System.out.println("Your guessed number is greater than the actual number.");
            }
            else {
                System.out.println("🎉 Congratulations! You won the game.");
                won = true;
                break;
            }
        }

        if (!won) {
            System.out.println("\nSorry! You lost the game.");
            System.out.println("The actual number was: " + num);
        }

        sc.close();
    }
}