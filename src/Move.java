import java.util.Scanner;

public class Move {
    static void move(int[][] board) {
        Scanner sr = new Scanner(System.in);
        String s;
        do {
            System.out.print("Please enter only w,a,s,d:");
            s = sr.nextLine().toLowerCase();
        } while (!s.equals("w") && !s.equals("s") && !s.equals("a") && !s.equals("d"));
        switch (s) {
            case "w" -> {
                for (int i = 0; i < 3; i++) {
                    for (int k = 0; k < 4; k++) {
                        for (int j = 3; j > 0; j--) {
                            if (board[j][k] == board[j - 1][k]) {
                                board[j - 1][k] *= 2;
                                board[j][k] = 0;
                            }
                            if (board[j - 1][k] == 0) {
                                board[j - 1][k] = board[j][k];
                                board[j][k] = 0;
                            }
                        }
                    }
                }
            }
            case "a" -> {
                for (int i = 0; i < 3; i++) {
                    for (int k = 0; k < 4; k++) {
                        for (int j = 3; j > 0; j--) {
                            if (board[k][j] == board[k][j - 1]) {
                                board[k][j - 1] *= 2;
                                board[k][j] = 0;
                            }
                            if (board[k][j - 1] == 0) {
                                board[k][j - 1] = board[k][j];
                                board[k][j] = 0;
                            }
                        }
                    }
                }
            }
            case "s" -> {
                for (int i = 0; i < 3; i++) {
                    for (int k = 0; k < 4; k++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[j][k] == board[j + 1][k]) {
                                board[j + 1][k] *= 2;
                                board[j][k] = 0;
                            }
                            if (board[j + 1][k] == 0) {
                                board[j + 1][k] = board[j][k];
                                board[j][k] = 0;
                            }
                        }
                    }
                }
            }
            case "d" -> {
                for (int i = 0; i < 3; i++) {
                    for (int k = 0; k < 4; k++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[k][j] == board[k][j + 1]) {
                                board[k][j + 1] *= 2;
                                board[k][j] = 0;
                            }
                            if (board[k][j + 1] == 0) {
                                board[k][j + 1] = board[k][j];
                                board[k][j] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
}
