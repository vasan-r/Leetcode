package Backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},

        };
        System.out.println(exist(board, "ABCED"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] find = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(search(board, i, j, word, 0, find)){
                    return true;
                }
            }
        }return false;
    }

    public static boolean search(char[][] board, int row, int col, String word, int i, boolean[][] visited) {
        if (word.length() == i ) {
           return true;
        }
        if (col >= board[0].length || row >= board.length || col < 0 || row < 0 || visited[row][col]) {
            return false;
        }
            if (board[row][col] == word.charAt(i)) {
                visited[row][col] = true;
                if(
                search(board, row, col+1, word, i + 1, visited) ||
                search(board, row+1, col, word, i + 1, visited) ||
                search(board, row, col-1, word, i + 1, visited) ||
                search(board, row-1, col, word, i + 1, visited)){
                    return true;
                }
            }
            visited[row][col] = false;
            return false;
    }
}
