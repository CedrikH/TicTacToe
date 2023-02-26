import java.util.Scanner;

public class Board {
    private String [][] board;
    private int size;
    public Board() {
        this.board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }
    public void displayBoard() { // default board with size 3
        this.size=3;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("_");
                }
                else if(board[i][j].isEmpty() ) {
                    System.out.print("_");
                }
                else{
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }

    }
    public void displayBoard(int size) {
        this.size = size;
        initializeBoard(size);

        }


    private void initializeBoard(int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("_");
                }
                else if(board[i][j].isEmpty() ) {
                    System.out.print("_");
                }
                else{
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    public String getWinner(Board board) {
        //horizontal
        for (int i = 0; i < 3; i++) {
            if (board.getTile(i, 0).equals(board.getTile(i, 1)) && board.getTile(i, 1).equals(board.getTile(i, 2)) && !board.getTile(i, 0).equals("")) {
                return getTile(i, 0);
            }
        }
        //vertikal
        for (int i = 0; i < 3; i++) {
            if (board.getTile(0,i).equals(board.getTile(1,i)) && board.getTile(1,i).equals(board.getTile(2,i)) && !board.getTile(0,i).equals("")) {
                return getTile(0,i);
            }
        }
        if (board.getTile(0,0).equals(board.getTile(1,1)) && board.getTile(1,1).equals(board.getTile(2,2)) && !board.getTile(0,0).equals("")) {
                return getTile(0,0);
        }
        if (board.getTile(2,2).equals(board.getTile(1,1)) && board.getTile(1,1).equals(board.getTile(0,0)) && !board.getTile(2,2).equals("")) {
            return getTile(2,2);
        }
    return null;
    }

     public void setTile(int row, int col, String symbol){
        board[row][col] = symbol;
    }
    public String getTile(int row, int col){
        return board[row][col];
    }

    private Player createPlayer(Scanner scanner, int playerNumber) { // creates player regardless of other factors. Free choice of name and symbol.
        System.out.println("Enter player " + playerNumber + " name:");
        String name = scanner.nextLine();
        System.out.println("Enter player " + playerNumber + " symbol (X or O):");
        String symbol = scanner.nextLine().toLowerCase();
        while (!symbol.equals("x") && !symbol.equals("o")) {
            System.out.println("Invalid symbol. Enter X or O:");
            symbol = scanner.nextLine().toLowerCase();
        }
        return new HumanPlayer(name, symbol);
    }

    private Player createPlayer(Scanner scanner, int playerNumber, String otherPlayerSymbol) { //creates player when another player has already been created. Automatically assigns other symbol. Free choice of name.
        System.out.println("Enter player " + playerNumber + " name:");
        String name = scanner.nextLine();
        String symbol = otherPlayerSymbol.equals("x") ? "o" : "x";
        return new HumanPlayer(name, symbol);
    }

    private void playGameLoop(Board board, Player player1, Player player2, Scanner scanner) { //Loops display and moves of players and checks for wins. Win check can be further modulized
        while (true) {
            board.displayBoard();
            player1.makeMove(board, scanner);
            board.displayBoard();
            if (board.getWinner(board) != null) {
                System.out.print(player1.getName() + " has won");
                break;
            }
            player2.makeMove(board, scanner);
            if (board.getWinner(board) != null) {
                System.out.print(player2.getName() + " has won");
                break;
            }
        }
    }
    public void playGame(Board board) {
        Scanner scanner = new Scanner(System.in);
        //player1
        Player player1 = createPlayer(scanner, 1);
        Player player2 = createPlayer(scanner, 2, player1.getSymbol());
        playGameLoop(board, player1,player2, scanner);
    }


    public String[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.playGame(board);

    }


}

