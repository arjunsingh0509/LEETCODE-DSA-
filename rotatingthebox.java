public class RotatingBox {

    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Step 1: Apply gravity (stones fall to the right)
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // rightmost available position

            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    empty = j - 1; // reset after obstacle
                } else if (box[i][j] == '#') {
                    // move stone to the 'empty' position
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                }
            }
        }

        // Step 2: Rotate 90 degrees clockwise
        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = box[i][j];
            }
        }

        return rotated;
    }

    // Helper function to print the matrix
    public static void printBox(char[][] box) {
        for (char[] row : box) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] box = {
            {'#', '.', '#'},
            {'#', '*', '.'}
        };

        System.out.println("Original Box:");
        printBox(box);

        char[][] result = rotateTheBox(box);

        System.out.println("\nRotated Box:");
        printBox(result);
    }
}