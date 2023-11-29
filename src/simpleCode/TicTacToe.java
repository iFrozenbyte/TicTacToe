package simpleCode;

import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private static final char EMPTY = '*';
    private static Scanner scanner = new Scanner(System.in);
    private static final char CROSS = 'X';
    private static final char ZERO = 'O';
    private static boolean isCross = true;

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = EMPTY;
            }
        }
        System.out.println("Введите координаты через пробел (номер строки, затем номер столбца) \n");
        while (true) {
            System.out.println("Ход: " + (isCross ? "крестики" : "нолики"));
            printField(field);
            try {
                String coordinates = scanner.nextLine();
                String[] parts = coordinates.split(" ");
                int x = Integer.parseInt(parts[0]) - 1; // -1 для координат
                int y = Integer.parseInt(parts[1]) - 1;

                if (field[x][y] != EMPTY) {
                    System.out.println("Ячейка уже занята, повторите ход.");
                    continue;
                } else {
                    field[x][y] = isCross ? CROSS : ZERO;
                }
                if (isWin(field, isCross ? CROSS : ZERO)) {
                    System.out.println("Выиграли " + (isCross ? "крестики" : "нолики"));
                    printField(field);
                    break;
                } else {
                    if (isCross){
                        isCross = false;
                    } else {
                        isCross = true;
                    }
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Координаты заданы неверно, повторите попытку.");
            }
        }
        scanner.close();
    }

    // ONLY 3x3
    private static boolean isWin(char[][] field, char player) {
                // строки
        return  (field[0][0] == player && field[0][1] == player && field[0][2] == player) ||
                (field[1][0] == player && field[1][1] == player && field[1][2] == player) ||
                (field[2][0] == player && field[2][1] == player && field[2][2] == player) ||
                // столбцы
                (field[0][0] == player && field[1][0] == player && field[2][0] == player) ||
                (field[0][1] == player && field[1][1] == player && field[2][1] == player) ||
                (field[0][2] == player && field[1][2] == player && field[2][2] == player) ||
                // диагонали
                (field[0][0] == player && field[1][1] == player && field[2][2] == player) ||
                (field[0][2] == player && field[1][1] == player && field[2][0] == player);
    }

    private static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}