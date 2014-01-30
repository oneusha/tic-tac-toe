public class Player {

    private String name;

    private final int id;

    private char symbol;

    public Player(String name, int id, char symbol) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
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

}
