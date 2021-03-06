package pro.zhelnov.game;

import pro.zhelnov.player.Player;
import pro.zhelnov.field.Field;
import java.util.Scanner;

public class Game {

    private final static int PLAYER_COUNTER = 2;

    private Scanner scan = new Scanner(System.in);

    private boolean gameOver = false;

    private Field field = createField();

    private Player[] players = createPlayers();

    public void startGame() {
        do {
            for (int i = 0; i < PLAYER_COUNTER; i++) {
                doTurn(players[i]);
                gameOver = checkGame(players[i]);
                if (gameOver) {
                    congratulate(players[i].getName());
                    break;
                }
            }
        } while (!gameOver);
    }

    private void congratulate(String name) {
        System.out.println("Congratulation, " + name + ". You win!");
    }

    private Field createField() {
        Field field = new Field(3);
        field.clearField();
        field.showField();
        return field;
    }

    private Player[] createPlayers() {
        Player[] players = new Player[PLAYER_COUNTER];
        for (int i = 0; i < PLAYER_COUNTER; i++) {
            System.out.println("Please, input a name for the " + (i + 1) + " player: ");
            String name = scan.next();
            System.out.println("Choose your symbol (only one character) : ");
            char symbol = scan.next().charAt(0);
            players[i] = new Player(name,symbol);
        }
        return players;
    }

    private void doTurn(Player player) {
        char symbol = player.getSymbol();
        System.out.println(player.getName() + "`s turn");
        System.out.println("Please, input a col: ");
        int col = scan.nextInt();
        System.out.println("Please, input a row: ");
        int row = scan.nextInt();
        field.putSymbol(symbol, row - 1, col - 1);
        field.showField();
        int[] lastTurn = {row - 1,col - 1};
        player.setLastTurn(lastTurn);
    }

    private boolean checkGame(Player player) {
        char symbol = player.getSymbol();
        int row = player.getLastTurn()[0];
        int col = player.getLastTurn()[1];
        boolean result = field.checkField(row,col,symbol);
        return result;
    }

}
