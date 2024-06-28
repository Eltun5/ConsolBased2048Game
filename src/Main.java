public class Main {
    public static void main(String[] args) {
        int[][] board = new int[4][4];
        int score = 0;
        System.out.println("""
                                                         Welcome 2048 Game
                                                         
                """);
        start(board, score);
    }

    public static void start(int[][] board, int score) {
        boolean isFinish = false;
        while (!isFinish) {
            randomizer(board);
            displayBoard(board);
            Move.move(board);
            isFinish=isFinish(board, score);
        }
    }

    public static void displayBoard(int[][] intBoard) {
        StringBuilder[][] board = new StringBuilder[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (intBoard[i][j] == 0) {
                    board[i][j] = new StringBuilder("     ");
                } else if (intBoard[i][j] < 10) {
                    board[i][j] = new StringBuilder("  " + intBoard[i][j] + "  ");
                } else if (intBoard[i][j] < 100) {
                    board[i][j] = new StringBuilder("  " + intBoard[i][j] + " ");
                } else if (intBoard[i][j] < 1000) {
                    board[i][j] = new StringBuilder(" " + intBoard[i][j] + " ");
                } else {
                    board[i][j] = new StringBuilder(" " + intBoard[i][j]);
                }
            }
        }
        System.out.printf("""
                        _________________________
                        |     |     |     |     |
                        |%s|%s|%s|%s|
                        |_____|_____|_____|_____|
                        |     |     |     |     |
                        |%s|%s|%s|%s|
                        |_____|_____|_____|_____|
                        |     |     |     |     |
                        |%s|%s|%s|%s|
                        |_____|_____|_____|_____|
                        |     |     |     |     |
                        |%s|%s|%s|%s|
                        |_____|_____|_____|_____|
                        """
                , board[0][0], board[0][1], board[0][2], board[0][3]
                , board[1][0], board[1][1], board[1][2], board[1][3]
                , board[2][0], board[2][1], board[2][2], board[2][3]
                , board[3][0], board[3][1], board[3][2], board[3][3]);
    }
    private static void randomizer(int[][] board) {
        int emptyCounter = 0;
        for (int[] i : board) {
            for (int e : i) {
                if (e == 0) {
                    emptyCounter++;
                    if (emptyCounter > 1)
                        break;
                }
            }
            if (emptyCounter > 1)
                break;
        }
        if (emptyCounter == 1) {
            int i, j;
            do {
                i = (int) (Math.random() * 4);
                j = (int) (Math.random() * 4);
            } while (board[i][j] != 0);
            board[i][j] = (int) (Math.random() * 2 + 1) * 2;
        } else if (emptyCounter == 2) {
            int randomCount = (int) (Math.random() * 2 + 1);
            for (int i = 0; i < randomCount; i++) {
                int a, j;
                do {
                    a = (int) (Math.random() * 4);
                    j = (int) (Math.random() * 4);
                } while (board[a][j] != 0);
                board[a][j] = (int) (Math.random() * 2 + 1) * 2;
            }
        }
    }

    private static boolean isFinish(int[][] board, int score) {
        for (int[] i : board)
            for (int e : i)
                if (e == 2048) {
                    System.out.println("You win your score is " + score + ".");
                    return true;
                }
        boolean b1 = false;
        boolean b2 = false;
        for (int[] i : board)
            for (int e : i)
                if (e == 0) {
                    b2=true;
                }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j]==board[i][j+1])
                    b1=true;
            }
        }
        if (!b1){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[j][i]==board[j+1][i])
                        b1=true;
                }
            }
        }
        if (!(b1||b2)) {
            System.out.println("You lose. Game is over.");
            return true;
        }
        return false;
    }
}