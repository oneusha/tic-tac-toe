import java.util.Scanner;

public class Game {

    private final static int PLAYER_COUNTER = 2;

    private Scanner scan = new Scanner(System.in);

    public void startGame() {

        Field field = createField();

        Player[] players = createPlayers();

        do {
            for (int i = 0; i < PLAYER_COUNTER; i++) {
                doTurn(field,players[i]);
            }
        } while (false);
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
            players[i] = new Player(name,0,symbol);
        }
        return players;
    }

    private void doTurn(Field field,Player player) {
        System.out.println(player.getName() + "`s turn");
        System.out.println("Please, input a col: ");
        int col = scan.nextInt();
        System.out.println("Please, input a row: ");
        int row = scan.nextInt();
        field.putSymbol(player, row - 1, col - 1);
        field.showField();
    }

}
