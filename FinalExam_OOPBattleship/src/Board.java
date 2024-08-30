public class Board {
    private char[][] board;
    private Ship[] ships;
    private int shipCount;

    public Board(int size, int numberOfShips) {
        board = new char[size][size];
        ships = new Ship[numberOfShips];
        shipCount = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void addShip(Ship ship, int startX, int startY, boolean horizontal) {
        if (shipCount < ships.length) {
            int[] position = new int[ship.getSize()];
            for (int i = 0; i < ship.getSize(); i++) {
                if (horizontal) {
                    position[i] = startX * board.length + startY + i;
                    board[startX][startY + i] = 'S';
                } else {
                    position[i] = (startX + i) * board.length + startY;
                    board[startX + i][startY] = 'S';
                }
            }
            ship.setPosition(position);
            ships[shipCount++] = ship;
        }
    }

    public boolean hit(int x, int y) {
        if (board[x][y] == 'S') {
            board[x][y] = 'X';
            for (Ship ship : ships) {
                for (int pos : ship.getPosition()) {
                    if (pos == x * board.length + y) {
                        ship.isHit(pos - x * board.length);
                        return true;
                    }
                }
            }
        }
        board[x][y] = 'O';
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
