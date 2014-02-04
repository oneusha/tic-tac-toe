package pro.zhelnov.field;

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
            System.out.println("Exceeded the permissible limit");
            this.fieldSize = DEFAULT_FIELD_SIZE;
        }
        field = new char[fieldSize][fieldSize];
    }

    public int getFieldSize() {
        return fieldSize;
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

    public void putSymbol(char symbol, int i, int j) {
        field[i][j] = symbol;
    }

    public char getSymbol(int i, int j) {
        return field[i][j];
    }

    public boolean checkField(int row, int col, char symbol) {
        return checkCol(col) || checkRow(row) || checkMajorDiagonal() || checkMinorDiagonal();
    }

    private boolean checkRow(int row) {
        boolean result = false;
        for (int i = 1; i < fieldSize; i++) {
            if (field[row][i] == field[row][i - 1]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean checkCol(int col) {
        boolean result = false;
        for (int i = 1; i < fieldSize; i++) {
            if (field[i][col] == field[i - 1][col]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean checkMajorDiagonal() {
        boolean result = false;
        for (int i = 1; i < fieldSize; i++) {
            if (field[i - 1][i - 1] == field[i][i] && field[i - 1][i - 1] != EMPTY_CELL_SYMBOL) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean checkMinorDiagonal() {
        boolean result = false;
        for (int i = 1; i < fieldSize; i++) {
            if (field[fieldSize - i][i - 1] == field[fieldSize - 1 - i][i] && field[fieldSize - 1][i - 1] != EMPTY_CELL_SYMBOL) {
                result = true;
            } else {
                result = false;
                break;
            }
            //System.out.println((fieldSize - 1) + ":" + (i - 1) + "  " + field[fieldSize - 1][i - 1] + " = " + field[fieldSize - 1 - i][i] + "  " + (fieldSize - 1 - i) + (i - 1) + ":" + i);
        }
        return result;
    }
}
