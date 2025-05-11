import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private int n;
    private List<List<String>> solutions;

    public NQueens(int n) {
        this.n = n;
        this.solutions = new ArrayList<>();
    }

    public List<List<String>> solve() {
        int[] board = new int[n];
        backtrack(board, 0);
        return solutions;
    }

    private void backtrack(int[] board, int row) {
        if (row == n) {
            solutions.add(constructSolution(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                backtrack(board, row + 1);
            }
        }
    }

    private boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || 
                board[i] - i == col - row || 
                board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private List<String> constructSolution(int[] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            solution.add(row.toString());
        }
        return solution;
    }

    public static void main(String[] args) {
        int n = 4;
        NQueens nQueens = new NQueens(n);
        List<List<String>> solutions = nQueens.solve();

        System.out.println("Total solutions for " + n + "-Queens: " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
