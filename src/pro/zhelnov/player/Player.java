package pro.zhelnov.player;

public class Player implements IPlayer {

    private String name;

    private char symbol;

    private int[] lastTurn = new int[2];

    public Player(String name, char symbol) {
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
