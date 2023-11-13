import java.util.Scanner;

public class Main {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean continueGame = true;
        String currentPlayer = "O";

        do {
            clearBoard();
            currentPlayer = "O";

            do {
                if (currentPlayer.equals("X"))
                {
                    currentPlayer = "O";
                }
                else
                {
                    currentPlayer = "X";
                }
                System.out.println("The current player is: " + currentPlayer);
                int rowMove = -1;
                int colMove = -1;

                boolean valid = false;

                do {
                    rowMove = SafeInput.getRangedInt(in, "Enter the row for your move [1 - 3]", 1, 3);
                    colMove = SafeInput.getRangedInt(in, "Enter the column for your move [1 - 3]", 1, 3);

                    rowMove--;
                    colMove--;

                    valid = isValidMove(rowMove, colMove);
                } while (!valid);
                board[rowMove][colMove] = currentPlayer;
                display();

            } while (!(isWin(currentPlayer) || isTie()));

            if (isWin(currentPlayer))
            {
                System.out.println("Congrats, player " + currentPlayer + " has won! :)");
            }
            else
            {
                System.out.println("It's a draw. :|");
            }
            continueGame = SafeInput.getYesNoInput(in, "Would you like to play again?");
        } while (continueGame);
    }

    private static void clearBoard()
    {
        for (int i = 0; i < COL; i++)
        {
            for (int j = 0; j < ROW; j++)
            {
                board[j][i] = " ";
            }
        }
    }

    private static void display() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j]);
                if (j < COL - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();

            if (i < ROW - 1) {
                System.out.println("----------");
            }
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        if (board[row][col].equals(" "))
        {
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean isWin(String player)
    {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        } else
        {
            return false;
        }
    }

    private static boolean isColWin(String player)
    {
        boolean win = true;
        for (int i = 0; i < COL; i++)
        {
            win = true;
            for (int j = 0; j < ROW; j++)
            {
                if (!board[j][i].equals(player))
                {
                    win = false;
                }
            }
            if (win)
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player)
    {

        boolean win = true;
        for (int i = 0; i < ROW; i++)
        {
            win = true;
            for (int j = 0; j < COL; j++)
            {
                if (!board[i][j].equals(player))
                {
                    win = false;
                }
            }
            if (win)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        boolean diagWin = true;
        for (int i = 0; i < COL; i++)
        {
            if (!board[i][i].equals(player))
            {
                diagWin = false;
            }
        }

        if (diagWin)
        {
            return true;
        }
        for (int i = 0; i < COL; i++)
        {
            if (!board[i][COL-1-i].equals(player))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean isTie()
    {
        boolean full = true;

        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                if (board[i][j].equals(" "))
                {
                    full = false;
                }
            }
        }

        if (!full)
        {
            boolean hasX = false;
            boolean hasO = false;

            for (int i = 0; i < ROW; i++)
            {
                for (int j = 0; j < COL; j++)
                {
                    if (board[i][j].equals("X"))
                    {
                        hasX = true;
                    }
                }
                if (!(hasX && hasO))
                {
                    return false;
                }
                hasX = false;
                hasO= false;
            }

            for (int i = 0; i < COL; i++)
            {
                for (int j = 0; j < ROW; j++)
                {
                    if (board[j][i].equals("X"))
                    {
                        hasX = true;
                    }
                    if (board[j][i].equals("O"))
                    {
                        hasO = true;
                    }
                }

                if (!(hasX && hasO))
                {
                    return false;
                }
                hasX = false;
                hasO = false;
            }

            for (int i = 0; i < COL; i++)
            {
                if (board[i][i].equals("X"))
                {
                    hasX = true;
                }
                if (board[i][i].equals("O"))
                {
                    hasO = true;
                }
            }

            if (!(hasX && hasO))
            {
                return false;
            }

            for (int i = 0; i < COL; i++)
            {
                if (board [i][COL-1-i].equals("X"))
                {
                    hasX = true;
                }
                if (board[i][COL-1-i].equals("O"))
                {
                    hasO = true;
                }
            }

        }
        return true;
    }

}