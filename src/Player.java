import java.util.Scanner;

public abstract class Player {
    private String symbol;
    private String name;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
    public abstract void makeMove(Board board , Scanner scanner);
}
