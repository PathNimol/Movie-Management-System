package JavaClass;
import java.util.Random;
import java.util.Scanner;

public class MazeGameRPG2 {
    static char[][] maze = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', '.', '.', '#', '.', '.', '.', '.', '#'},
            {'#', '.', '#', '.', '#', '.', '#', '#', '.', '#'},
            {'#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '.', '#', '#', '#', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '#', '.', '#', '.', '#'},
            {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '#', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '#', '#', '#', '#', '#', '#', 'E', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    static int playerRow, playerCol, health;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            startGame(scanner);

            if (!handlePostGame(scanner)) {
                break;
            }
        }
        scanner.close();
    }

    static void startGame(Scanner scanner) {
        initializeGame();

        Random random = new Random();
        System.out.println("\nWelcome to the RPG Maze Game!");
        System.out.println("Choose Mode:");
        System.out.println("1. Player Mode (You control)");
        System.out.println("2. Computer Mode (Random moves)");
        System.out.print("Enter 1 or 2: ");
        int mode = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.println("Find the exit (E) while avoiding walls (#). Good luck!");

        while (true) {
            printMaze();
            printHealthBar();

            if (mode == 1) {
                handlePlayerMove(scanner);
            } else if (mode == 2) {
                handleComputerMove(random);
            }

            if (maze[playerRow][playerCol] == 'E') {
                System.out.println("🎉 Congratulations! You've escaped the maze!");
                break;
            }

            if (health <= 0) {
                System.out.println("💀 You died! Game over!");
                break;
            }
        }
    }

    static void initializeGame() {
        playerRow = 1;
        playerCol = 1;
        health = 100;
    }

    static boolean handlePostGame(Scanner scanner) {
        System.out.println("\nGame Over!");
        System.out.println("1. Try Again");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (choice == 2) {
            System.out.print("Are you sure you want to exit? (Y/N): ");
            String confirm = scanner.nextLine().toUpperCase();
            if (confirm.equals("Y")) {
                System.out.println("Thanks for playing! Goodbye! 👋");
                return false;
            }
        }
        return true;
    }

    static void handlePlayerMove(Scanner scanner) {
        System.out.print("Move (W/A/S/D): ");
        String input = scanner.nextLine().toUpperCase();

        if (input.isEmpty()) {
            System.out.println("Invalid input! Please enter W, A, S, or D.");
            return;
        }

        char move = input.charAt(0);
        movePlayer(move);
    }

    static void handleComputerMove(Random random) {
        char[] moves = {'W', 'A', 'S', 'D'};
        char move = moves[random.nextInt(4)];
        System.out.println("Computer moves: " + move);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        movePlayer(move);
    }

    static void movePlayer(char direction) {
        int newRow = playerRow, newCol = playerCol;

        switch (direction) {
            case 'W':
                newRow--;
                break;
            case 'A':
                newCol--;
                break;
            case 'S':
                newRow++;
                break;
            case 'D':
                newCol++;
                break;
            default:
                System.out.println("Invalid input! Use W, A, S, or D.");
                return;
        }

        if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length) {
            if (maze[newRow][newCol] != '#') {
                playerRow = newRow;
                playerCol = newCol;
            } else {
                health -= 20;
                System.out.println("Ouch! You hit a wall. Health -20.");
            }
        } else {
            System.out.println("You can't move outside the maze!");
        }
    }

    static void printMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (row == playerRow && col == playerCol) {
                    System.out.print("P ");
                } else {
                    System.out.print(maze[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    static void printHealthBar() {
        int barLength = 20;
        int filledLength = (int) ((health / 100.0) * barLength);
        System.out.print("Health: [");
        for (int i = 0; i < barLength; i++) {
            if (i < filledLength) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("] (" + health + "% health)");
    }
}