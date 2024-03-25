import java.util.Scanner;

public class Main {

    final static int gridRows = 8;
    final static int gridColumns = 16;
    static char[][] grid = new char[gridRows][gridColumns];

    static Player player = new Player(0, 0);

    static void clearConsole() {
        for (int i = 0; i < gridColumns; i++) {
            System.out.print("\n");
        }
    }

    static void updateGrid(char[][] grid) {
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridColumns; j++) {
                grid[i][j] = '.';
            }
        }
        grid[player.getX()][player.getY()] = 'p';

        clearConsole();
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridColumns; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("X: " + player.getX() + "\n" + "Y: " + player.getY());
    }


    public static void main(String[] args) {

        updateGrid(grid);
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        while (on) {
            String input = scanner.nextLine();
            if (input.length() != 0) {
                char inputChar = input.charAt(0);

                switch (inputChar) {
                    case 'd':
                        if (player.getY() < gridColumns - 1) {
                            player.setY(player.getY() + 1);
                        }
                        break;
                    case 'a':
                        if (player.getY() > 0) {
                            player.setY(player.getY() - 1);
                        }
                        break;
                    case 'w':
                        if (player.getX() > 0) {
                            player.setX(player.getX() - 1);
                        }
                        break;
                    case 's':
                        if (player.getX() < gridRows - 1) {
                            player.setX(player.getX() + 1);
                        }
                        break;
                    case 'q':
                        on = false;
                        break;
                    default:
                        break;
                }
            }
            updateGrid(grid);
        }

    }
}