public class Player {

    private String name;

    private char symbol;

    private int[] lastTurn = new int[2];

    public Player(String name, int id, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void setLastTurn(int[] lastTurn) {
        this.lastTurn = lastTurn;
    }

    public int[] getLastTurn() {
        return lastTurn;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

}
