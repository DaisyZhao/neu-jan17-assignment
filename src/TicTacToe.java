import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Xueying Zhao
 */
public class TicTacToe {

    private int size;
    private int currentPlayer;
    private int[][] grid;

    public TicTacToe(int size, int currentPlayer) {
        this.size = size;
        this.currentPlayer = currentPlayer;
        grid = new int[size][size];
        initializeBoard();
    }

    // set or reset the board back to all empty values
    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 0;
            }
        }
        printBoard();
    }

    // print the current board
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                System.out.print("----");
            }
            System.out.println("-");

            for (int j = 0; j < size; j++) {
                System.out.print("|");
                switch (grid[i][j]) {
                    case 0:
                        System.out.print("   ");
                        break;
                    case 1:
                        System.out.print(" X ");
                        break;
                    case 2:
                        System.out.print(" O ");
                        break;
                }
            }
            System.out.println("|");
        }
        for (int k = 0; k < size; k++) {
            System.out.print("----");
        }
        System.out.println("-");

    }

    // check if the board is full or not
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // check if there's a winner or not
    public boolean checkForWin(int currentPlayer) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (grid[i][j] == currentPlayer) {
                    int a = 0;
                    int b = 0;
                    int k = 0;
                    // check if currentPlayer places marks in a horizal row
                    while (b < size) {
                        if (grid[i][b] != currentPlayer) {
                            break;
                        } else {
                            b++;
                        }
                    }
                    if (b == size) {
                        return true;
                    }

                    // check if currentPlayer places marks in a vertical row
                    while (a < size) {
                        if (grid[a][j] != currentPlayer) {
                            break;
                        } else {
                            a++;
                        }
                    }
                    if (a == size) {
                        return true;
                    }

                    // check if currentPlayer places marks in a diagonal row
                    if (i == 0 && j == 0) {
                        while (k < size) {
                            if (grid[k][k] != currentPlayer) {
                                break;
                            } else {
                                k++;
                            }
                        }
                        if (k == size) {
                            return true;
                        }
                    }

                    if (i == 0 && j == size - 1) {
                        while (k < size) {
                            if (grid[k][size - 1 - k] != currentPlayer) {
                                break;
                            } else {
                                k++;
                            }
                        }
                        if (k == size) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // change player marks back and forth
    public void changePlayer(int currentPlayer) {
        this.currentPlayer = 3 - currentPlayer;
    }

    // place the mark of the current player at the cell specified by row and col
    public boolean placeMark(int currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + ", please input the coordinate:  (for example: 1 2)");

        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            while (x < 1 || x > size || y < 1 || y > size || grid[x - 1][y - 1] != 0) {
                System.out.println("Invalid move! Please input valid coordinate again: ");
                x = scanner.nextInt();
                y = scanner.nextInt();
            }
            if (x >= 1 && x <= size && y >= 1 && y <= size && grid[x - 1][y - 1] == 0) {
                grid[x - 1][y - 1] = currentPlayer;
                printBoard();
            }
            return true;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            return false;
        }
    }

    public void playGame() {

        while (!placeMark(currentPlayer));

        while (!checkForWin(currentPlayer) && !isBoardFull()) {
            changePlayer(currentPlayer);
            while (!placeMark(currentPlayer));
        }
        if (checkForWin(currentPlayer)) {
            System.out.println("Player " + currentPlayer + " wins the game!");
        } else {
            System.out.println("The board is full and result is tie.");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(5, 1);
        game.playGame();

        System.out.println("Please input 'y' to restart a new game: ");
        Scanner scanner1 = new Scanner(System.in);
        String x = scanner1.nextLine().trim();
        while ("y".equals(x)) {
            game.initializeBoard();
            game.playGame();
            System.out.println("Please input 'y' to restart a new game: ");
            x = scanner1.nextLine();
        }
    }
}
