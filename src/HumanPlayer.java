import java.util.Scanner;

public class HumanPlayer extends Player{
    private String symbol; // Wird bei initialisierung ausgewählt und anhanddessen werden Moves eingetragen
    private String name;
    private String opposingSymbol;

    public HumanPlayer(String name, String symbol){
        super(name, symbol);
        this.name = name;
        this.symbol = symbol;
    }

    public HumanPlayer(String name, String symbol, String opposingSymbol){
        super(name, symbol);
        this.name = name;
        this.symbol = symbol;
    }



    public HumanPlayer(Scanner scanner) {
        super("", "");
        System.out.println("Enter your name:");
        name = scanner.nextLine();
        System.out.println("Enter your symbol (X or O):");
        while(true){
            String input = scanner.nextLine().toLowerCase();
            if (!input.equals("x") && !input.equals("o")){
                System.out.println("Wrong symbol");
                continue;
            }
            symbol = input;
            break;
        }

    }



    private int getValidRow(Scanner scanner, int size) {
        while (true) {
            System.out.println("Which row");
            String input = scanner.nextLine();
            //Preventing empty input
            try {
                if (input.isEmpty()) {
                    System.out.println("Please enter your row");
                    continue;
                }
                int row = Integer.parseInt(input) - 1;
                if (row + 1 > size) {
                    System.out.println("Number too big");
                    continue;
                }
                return row;
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid input");
            }
        }
    }

    private int getValidColumn(Scanner scanner, int size) {
        while (true) {
            System.out.println("Which column");
            String input = scanner.nextLine();
            try {
                if (input.isEmpty()) {
                    System.out.println("Please enter your column");
                    continue;
                }
                int col = Integer.parseInt(input) - 1;
                if (col + 1 > size) {
                    System.out.println("Number too big");
                    continue;
                }
                return col;
            }
            catch(NumberFormatException e){
                System.out.println("Not a valid input");
            }
        }
    }


        public void makeMove(Board board, Scanner scanner){ //Takes Player by symbol and scanner and pastes players symbol into desired place
            int size = board.getSize();
            int row = getValidRow(scanner, size);
            int col = getValidColumn(scanner, size);
            board.setTile(row, col, symbol);
        }
    }

