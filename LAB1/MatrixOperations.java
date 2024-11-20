public class MatrixOperations {

    public static void main(String[] args) {
        // Задання значень для матриць A та B
        long[][] A = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        long[][] B = {
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}
        };

        // Операція A ^ B (побітове виключне "або")
        long[][] C = matrixXOR(A, B);
        printMatrix(C, "Результат побітового виключного 'або' (A ^ B)");

        // Обчислення суми найбільших та найменших елементів в стовпцях
        long sum = computeColumnSums(C);
        System.out.println("Сума найбільших та найменших елементів: " + sum);
    }

    // Метод для побітового виключного "або" між двома матрицями
    public static long[][] matrixXOR(long[][] A, long[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        long[][] result = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] ^ B[i][j]; // Побітове виключне "або"
            }
        }
        return result;
    }

    // Метод для обчислення суми найбільших та найменших елементів в стовпцях
    public static long computeColumnSums(long[][] C) {
        int rows = C.length;
        int cols = C[0].length;
        long sum = 0;

        for (int j = 0; j < cols; j++) {
            long maxInOddColumn = Long.MIN_VALUE;
            long minInEvenColumn = Long.MAX_VALUE;

            // Якщо стовпець непарний (індексація з 0, тому перевірка на парність стовпця)
            if (j % 2 != 0) {
                for (int i = 0; i < rows; i++) {
                    maxInOddColumn = Math.max(maxInOddColumn, C[i][j]);
                }
                sum += maxInOddColumn;
            }
            // Якщо стовпець парний
            else {
                for (int i = 0; i < rows; i++) {
                    minInEvenColumn = Math.min(minInEvenColumn, C[i][j]);
                }
                sum += minInEvenColumn;
            }
        }
        return sum;
    }

    // Метод для виведення матриці на екран
    public static void printMatrix(long[][] matrix, String message) {
        System.out.println(message);
        for (long[] row : matrix) {
            for (long element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}