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


    public void makeMove(Board board, Scanner scanner){ //Takes Player by symbol and scanner and pastes players symbol into desired place
        while (true) {
            System.out.println("Which row");
            int row = Integer.parseInt(scanner.nextLine()) - 1;
            System.out.println("Which column");
            int col = Integer.parseInt(scanner.nextLine()) - 1;
            if (board.getTile(row,col).equals("o") || board.getTile(row,col).equals("x")){
                System.out.println("Already occupied");
                continue;
            }

            board.setTile(row,col,symbol); // ads players symbol to desired place



            break;
        }
    }
}
