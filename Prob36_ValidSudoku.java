public class Prob36_ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        //Duyet row
        for (int i = 0; i < 9; i++) {
            int[] fre = new int[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    fre[board[i][j] - '0']++;
                    if (fre[board[i][j] - '0'] > 1) {
                        return false;
                    }
                }
                
            }
        }

        //Duyet column
        for (int i = 0; i < 9; i++) {
            int[] fre = new int[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    fre[board[j][i] - '0']++;
                    if (fre[board[j][i] - '0'] > 1) {
                        return false;
                    }
                }
                
            }
        }

        //Duyet 3x3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!traverse3by3(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean traverse3by3(char[][] board, int i_idx, int j_idx) {
        int[] fre = new int[10];
        for (int i = i_idx; i < i_idx + 3; i++) {
            for (int j = j_idx; j < j_idx + 3; j++) {
                if (board[i][j] != '.') {
                    fre[board[i][j] - '0']++;
                    if (fre[board[i][j] - '0'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{}}));
    }
}
