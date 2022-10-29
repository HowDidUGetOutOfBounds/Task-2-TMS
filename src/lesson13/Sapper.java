package lesson13;
import java.util.Scanner;


//Publish to github
public class Sapper {

    static int gridW = 10; // grid width
    static int gridH = 10; // grid height
    static int numMines = 4; // number of mines on the board

    static int[][] mines; // entry is 1 for having a mine and 0 for not
    static boolean[][] revealed; // entry is true if that spot is revealed


    static boolean outBounds(int x, int y) {
        return x < 0 || y < 0 || x >= gridW || y >= gridH;
    }

    static int calcNear(int x, int y) {
        if (outBounds(x, y)) return 0;
        int i = 0;
        for (int offsetX = -1; offsetX <= 1; offsetX++) {
            for (int offsetY = -1; offsetY <= 1; offsetY++) {
                if (outBounds(offsetX +x , offsetY + y)) continue;
                i += mines[offsetX + x][offsetY + y];
            }
        }
        return i;
    }

    static void reveal(int x, int y) {
        if (outBounds(x, y)) return;
        if (revealed[x][y]) return;
        revealed[x][y] = true;
        if (calcNear(x, y) != 0) return;
        reveal(x - 1, y - 1);
        reveal(x - 1, y + 1);
        reveal(x + 1, y - 1);
        reveal(x + 1, y + 1);
        reveal(x - 1, y);
        reveal(x + 1, y);
        reveal(x, y - 1);
        reveal(x, y + 1);
    }

    static void setup() {
        //initialize and clear the arrays
        mines = new int[gridW][gridH];
        revealed = new boolean[gridW][gridH];
        for (int x = 0; x < gridW; x++) {
            for (int y = 0; y < gridH; y++) {
                mines[x][y] = 0;
                revealed[x][y] = false;
            }
        }
    }

    //Place numMines mines on the grid
    static void placeMines() {
        int i = 0;
        while (i < numMines) {//We don't want mines to overlap, so while loop
            int x = (int) (Math.random() * gridW);
            int y = (int) (Math.random() * gridH);
            if (mines[x][y] == 1) continue;
            mines[x][y] = 1;
            i++;
        }
    }

    //Clear the mines
    static void clearMines() {
        for (int x = 0; x < gridW; x++) {
            for (int y = 0; y < gridH; y++) {
                mines[x][y] = 0;
            }
        }
    }

    static boolean checkWinState() {
        int cn = 0;
        for (int x = 0; x < gridW; x++) {
            for (int y = 0; y < gridH; y++) {
                if (revealed[x][y] == false) {
                    cn++;
                }
            }
        }

        if (cn == numMines) {
            return true;
        }
        return false;
    }

    static void showField() {

        for (int i = 0; i < gridW; i++) {
            System.out.print("(" + i + ")" + " ");
        }

        System.out.println();

        for (int x = 0; x < gridW; x++) {
            for (int y = 0; y < gridH; y++) {
                if (revealed[x][y] == false) {
                    System.out.print("[?]\t");
                } else {
                    if (mines[x][y] == 0) {
                        System.out.print(" " +calcNear(x, y) + " \t");
                    } else {
                        System.out.print("[*]\t");
                    }
                }
            }
            System.out.println("(" + x + ")");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean gameOver = false;
        setup();
        placeMines();

        while (!gameOver) {
            int first = in.nextInt();
            int second = in.nextInt();
            if (!outBounds(first, second)) {
                System.out.println("------------");
                reveal(first, second);
                System.out.println("------------");
                showField();
                if (mines[first][second] == 1) {
                    System.out.println("Game over");
                    gameOver = true;
                }
                if (checkWinState()) {
                    System.out.println("You Win!");
                    gameOver = true;
                }
            }
        }


    }
}

