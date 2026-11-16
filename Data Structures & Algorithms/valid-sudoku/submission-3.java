class Solution {
private static final int SIZE = 9;
private static final int BOX_SIZE = 3;
private static final char EMPTY = '.';
private static final int NO_DIGIT = 0;


public boolean isValidSudoku(char[][] board) {
    int[][] digits = new int[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                char cell = board[row][column];
                digits[row][column] = (cell == EMPTY) ? NO_DIGIT : Character.getNumericValue(cell);
            }
        }
    int[] line = new int[SIZE];
    for (int row = 0; row < SIZE; row++) {
        for (int column = 0; column < SIZE; column++) {
            line[column] = digits[row][column];
        }
        if (hasDuplicate(line)) {
            return false;
        }
    }
    for (int column = 0; column < SIZE; column++) {
        for (int row = 0; row < SIZE; row++) {
            line[row] = digits[row][column];
        }
        if (hasDuplicate(line)) {
            return false;
        }
    }
    for (int boxRow = 0; boxRow < SIZE; boxRow += BOX_SIZE) {
        for (int boxColumn = 0; boxColumn < SIZE; boxColumn += BOX_SIZE) {
            int index = 0;
            for (int row = boxRow; row < boxRow + BOX_SIZE; row++) {
                for (int column = boxColumn; column < boxColumn + BOX_SIZE; column++) {
                    line[index++] = digits[row][column];
                }
            }
            if (hasDuplicate(line)) {
            return false;
            }
        }
    }
    return true;
}
    static boolean hasDuplicate(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == NO_DIGIT) {
                continue;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
        
    
