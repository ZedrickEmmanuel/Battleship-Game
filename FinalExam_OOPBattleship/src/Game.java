import java.util.Scanner;

public class Game {
    private Board board;
    private Scanner scanner;

    public Game() {
        board = new Board(5, 3); // 5x5 board with 3 ships
        scanner = new Scanner(System.in);
        setupShips();
    }

    private void setupShips() {
        board.addShip(new Ship(3), 0, 0, true);
        board.addShip(new Ship(2), 2, 2, false);
        board.addShip(new Ship(1), 4, 4, true);
    }

    public void play() {
        System.out.println("Welcome to Battleship!");
        while (!board.allShipsSunk()) {
            board.printBoard();
            System.out.print("Enter coordinates to hit (row and column): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (board.hit(x, y)) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }
        }
        System.out.println("Congratulations! You sunk all the ships!");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
