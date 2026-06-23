 
import java.util.Scanner;

public class TicTacToe {

    String[][] board = new String[3][3];

    void initializeBoard() {
        int cnt = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = String.valueOf(cnt);
                cnt++;
            }
        }
    }

    void printBoard() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }

            System.out.println();
            System.out.println("--------------");
        }
    }

    boolean Winner() {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) &&
                board[i][1].equals(board[i][2])) {
                return true;
            }
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals(board[1][j]) &&
                board[1][j].equals(board[2][j])) {
                return true;
            }
        }

        // Diagonal 1
        if (board[0][0].equals(board[1][1]) &&
            board[1][1].equals(board[2][2])) {
            return true;
        }

        // Diagonal 2
        if (board[0][2].equals(board[1][1]) &&
            board[1][1].equals(board[2][0])) {
            return true;
        }

        return false;
    }

    void Chance() {

        String turn = "X";
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {

            System.out.println("Enter the position to place " + turn + " : ");
            int position = sc.nextInt();

            if (position < 1 || position > 9) {
                System.out.println("Invalid Position !");
                i--;
                continue;
            }

            int row = (position - 1) / 3;
            int col = (position - 1) % 3;

            if (board[row][col].equals("X") ||
                board[row][col].equals("O")) {

                System.out.println("Position already used !!");
                i--;
                continue;
            }

            board[row][col] = turn;

            printBoard();

            if (Winner()) {
                System.out.println(turn + " Wins !");
                return;
            }

            if (turn.equals("X")) {
                turn = "O";
            } else {
                turn = "X";
            }
        }

        System.out.println("Match Draw !");
    }

    public static void main(String[] args) {

        System.out.println("Both players choose their symbol X or O");
        System.out.println("The Player choosing X will start the game");

        TicTacToe t1 = new TicTacToe();

        t1.initializeBoard();
        t1.printBoard();
        t1.Chance();
    }
}

