import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] input = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = new int[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] actual = transposeMatrix(input);
        System.out.println("expected: " + Arrays.deepToString(expected));
        System.out.println("actual: " + Arrays.deepToString(actual));
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int origin_h = matrix.length;
        int origin_w = matrix[0].length;
        int transpose_h = origin_w;
        int transpose_w = origin_h;
        int[][] result = new int[transpose_h][transpose_w];
        for(int i = 0; i < transpose_h; i++) {
            for(int j = 0; j < transpose_w; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}
