package Unit8;

// Have to get rid of package statement

public class Board {

    private String[][] squares;

    public Board() {
        squares = new String[10][10];
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {
                squares[r][c] = "-";
            }
        }
    }

    public String toString() {
        String boardString = "";

        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {
                boardString += squares[r][c] + " ";
            }
            boardString += "\n";
        }

        return boardString;
    }

    public boolean addShip(int row, int col, int len, boolean horizontal) {

        if (!isCoordinatesValid(row, col, len, horizontal))
            return false;

        if (isShipInWay(row, col, len, horizontal))
            return false;

        placeShip(row, col, len, horizontal);

        return true;
    }

    private boolean isCoordinatesValid(int row, int col, int len, boolean horizontal) {
        boolean validCoordinates = (row >= 0 && row < squares.length) &&
                (col >= 0 && col < squares[row].length);

        if (horizontal) {
            validCoordinates = validCoordinates && col + len <= squares[row].length;
        } else {
            validCoordinates = validCoordinates && row + len <= squares.length;
        }

        return validCoordinates;

    }

    private boolean isShipInWay(int row, int col, int len, boolean horizontal) {
        if (horizontal) {
            for (int c = col; c < col + len; c++) {
                if (squares[row][c].equals("b")) {
                    return true;
                }
            }
        } else {
            for (int r = row; r < row + len; r++) {
                if (squares[r][col].equals("b")) {
                    return true;
                }
            }
        }

        return false;
    }

    private void placeShip(int row, int col, int len, boolean horizontal) {
        if (horizontal) {
            for (int c = col; c < col + len; c++) {
                squares[row][c] = "b";
            }
        } else {
            for (int r = row; r < row + len; r++) {
                squares[r][col] = "b";
            }
        }
    }

    public boolean foundShip(int len) {
        // Searching row-by-row
        for (int r = 0; r < squares.length; r++) {
            int count = 0;
            for (int c = 0; c < squares[r].length; c++) {
                if (squares[r][c].equals("b")) {
                    count++;
                } else {
                    if (count == len) {
                        return true;
                    }
                    count = 0;
                }
            }
            if (count == len) {
                return true;
            }
        }

        // Searching column by column
        for (int c = 0; c < squares[0].length; c++) {
            int count = 0;
            for (int r = 0; r < squares.length; r++) {
                if (squares[r][c].equals("b")) {
                    count++;
                } else {
                    if (count == len) {
                        return true;
                    }
                    count = 0;
                }
            }
            if (count == len) {
                return true;
            }
        }

        return false;
    }

    public int shoot(int row, int col) {

        if (!isCoordinatesValid(row, col, 0, false))
            return -1;

        if (squares[row][col].equals("-")) {
            squares[row][col] = "m";
            return 0;
        } else if (squares[row][col].equals("b")) {
            squares[row][col] = "x";
            return 1;
        }

        return 2;
    }

    public boolean gameOver() {
        if (foundShip(1)) {
            return false;
        }

        return true;
    }

}
