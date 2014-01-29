public class Player {

    private String name;

    private final int id;

    private char symbol;

    private boolean turn;

    public Player(String name, int id, char symbol, boolean turn) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.turn = turn;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean toggleTurn(boolean turn) {
        return !turn;
    }
}
