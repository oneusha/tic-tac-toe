public class Field {

    private static final int MIN_FIELD_SIZE = 1;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int DEFAULT_FIELD_SIZE = 3;
    private static final char EMPTY_CELL_SYMBOL = ' ';

    private final int fieldSize;
    private final char[][] field;

    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int fieldSize) {
        if ((fieldSize > MIN_FIELD_SIZE) && (fieldSize < MAX_FIELD_SIZE)) {
            this.fieldSize = fieldSize;
        } else {
            this.fieldSize = DEFAULT_FIELD_SIZE;
        }
        field = new char[fieldSize][fieldSize];
    }

    public void clearField() {
        for (int i = 0; i < fieldSize; i++) {
            clearLine(i);
        }
    }

    private void clearLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            field[lineNumber][i] = EMPTY_CELL_SYMBOL;
        }
    }

    public void showField() {
        for (int i = 0; i < fieldSize; i++) {
            showLine(i);
            System.out.println();
        }
        System.out.println();
    }

    private void showLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            showCell(lineNumber, i);
        }
    }

    private void showCell(int i, int j) {
        System.out.print("[" + field[i][j] + "]");
    }

    public void drowSymbol(Player player, int i, int j) {
        System.out.println(player.getName() + ":");
        field[i][j] = player.getSymbol();
        showField();
    }
}
