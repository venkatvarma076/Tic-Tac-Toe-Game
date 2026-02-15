import java.util.Scanner;

// Player Class
class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

// Board Class
class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    public void initializeBoard() {
        char cellNumber = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = cellNumber++;
            }
        }
    }

    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2)
                System.out.println("---|---|---");
        }
        System.out.println();
    }

    public boolean markCell(int row, int col, char playerSymbol) {
        if (isCellEmpty(row, col)) {
            board[row][col] = playerSymbol;
            return true;
        }
        return false;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] != 'X' && board[row][col] != 'O';
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }

        return false;
    }
}

// Game Class
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean playAgain;

        do {
            board = new Board();
            player1 = new Player('X');
            player2 = new Player('O');
            currentPlayer = player1;

            System.out.println("=== TIC TAC TOE GAME ===");

            while (true) {
                board.displayBoard();
                playTurn();

                if (checkGameStatus()) {
                    board.displayBoard();
                    break;
                }

                switchPlayer();
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    private void playTurn() {
        int choice;
        int row, col;

        while (true) {
            System.out.print("Player " + currentPlayer.getSymbol() + 
                             ", enter cell number (1-9): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); 
                continue;
            }

            choice = scanner.nextInt();

            if (choice < 1 || choice > 9) {
                System.out.println("Invalid cell number! Choose between 1-9.");
                continue;
            }

            row = (choice - 1) / 3;
            col = (choice - 1) % 3;

            if (!board.isCellEmpty(row, col)) {
                System.out.println("Cell already occupied! Try again.");
                continue;
            }

            board.markCell(row, col, currentPlayer.getSymbol());
            break;
        }
    }

    private boolean checkGameStatus() {
        if (board.checkWin(currentPlayer.getSymbol())) {
            System.out.println("🎉 Player " + currentPlayer.getSymbol() + " Wins!");
            return true;
        }

        if (board.isFull()) {
            System.out.println("It's a Draw!");
            return true;
        }

        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}