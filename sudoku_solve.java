import java.util.HashSet;
import java.util.Scanner;

public class sudoku_solve {
    char[][] board;
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        this.board = board;
        solve();
    }

    public boolean solve() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char t = '1'; t <= '9'; t++) {
                        if (valid(r, c, t)) {
                            board[r][c] = t;
                            if (solve())
                                return true;
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(int r, int c, char tab) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] != '.' && board[i][c] == tab) return false; //check row
            if (board[r][i] != '.' && board[r][i] == tab) return false; //check column
            if (board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] != '.' &&
                    board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == tab) return false; //check 3*3 block
        }
        return true;
    }
}
class ans {
    public static void main(String[] args) {
        sudoku_solve ans = new sudoku_solve();
        char[][] board= new char[9][9];
        System.out.println("enter the number in this ceil and . when its empty:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                board[i][j] = s.charAt(0);
            }
        }
        ans.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        };
    }
}
