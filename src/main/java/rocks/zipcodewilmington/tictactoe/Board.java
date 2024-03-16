package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] matrix;

    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    private char gameSpaces(char first, char second, char third) {
        if (first == 'X' && first == second && second == third) {
            return 'X';
        } else if (first == 'O' && first == second && second == third) {
            return 'O';
        } else {
            return '.';
        }
    }

    private char rowSpace(int row) {
        return gameSpaces(matrix[0][row], matrix[1][row], matrix[2][row]);
    }

    private char columnSpace(int col) {
        return gameSpaces(matrix[col][0], matrix[col][1], matrix[col][2]);
    }

    private char diagonalSpace1() {
        return gameSpaces(matrix[0][0], matrix[1][1], matrix[2][2]);
    }

    private char diagonalSpace2() {
        return gameSpaces(matrix[2][0], matrix[1][1], matrix[0][2]);
    }


    public Boolean isInFavorOfO() {
        for (int i = 0; i < 3; i++) {
            if (columnSpace(i) == 'O' || rowSpace(i) == 'O') {
                return true;
            } else if (columnSpace(i) == 'X' || rowSpace(i) == 'X') {
                return false;
            }
        }
        return diagonalSpace1() == 'O' || diagonalSpace2() == 'O'; //All above conditions where 'O' wins
    }

    public Boolean isInFavorOfX() {
        for (int i = 0; i < 3; i++) {
            if (columnSpace(i) == 'X' || rowSpace(i) == 'X') {
                return true;
            } else if (columnSpace(i) == 'O' || rowSpace(i) == 'O') {
                return false;
            }
        }
        return diagonalSpace1() == 'X' || diagonalSpace2() == 'X'; //Above conditions where 'X' wins
    }

    public Boolean isTie() {
        for (int i = 0; i < 3; i++){
            if(columnSpace(i) == 'O' || rowSpace(i) == 'O') {
                return false;
            } else if (columnSpace(i) == 'X' || rowSpace(i) == 'X') {
                return false;
            }
        }
        return diagonalSpace1() == '.' && diagonalSpace2() == '.';
    }

    public String getWinner() {
        if (isInFavorOfX()) {
            return "X";
        } else if(isInFavorOfO()) {
            return "O";
        } else
            return "";
    }
}

