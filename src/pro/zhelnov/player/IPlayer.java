package pro.zhelnov.player;

public interface IPlayer {

    public void setLastTurn(int[] lastTurn);
    public int[] getLastTurn();
    public String getName();
    public char getSymbol();

}
