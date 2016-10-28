import java.util.*;

public class multMatrix {
    public static int stepCount = 0;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter row and column for first Matrix: ");
        int[][] a = new int[input.nextInt()][input.nextInt()];

        System.out.println("Enter row and column for second Matrix: ");
        int[][] b = new int[input.nextInt()][input.nextInt()];
        System.out.println();

        //initialize a
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = rand.nextInt(6) + 2;
            }
        }

        //initialize b
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = rand.nextInt(6) + 2;
            }
        }

        //print a
        System.out.println("This is first Matrix: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        //print b
        System.out.println("This is second Matrix: ");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        //Multiply matrices
        int[][] result = MultiplyMatrix(a, b);

        //print result
        System.out.println("This is the result: ");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        //stepCount
        System.out.println("Step count is: " + stepCount);

    }

    public static int[][] MultiplyMatrix(int[][] firstMat, int[][] secondMat) {
        int[][] result = new int[firstMat.length][secondMat[0].length];
        int[][] tempColumn = new int[secondMat.length][1];

        //traverse each column of b
        for (int i = 0; i < secondMat[0].length; i++) {
            //copy each column to tempColumn
            for (int j = 0; j < secondMat.length; j++) {
                tempColumn[j][0] = secondMat[j][i];
            }
            // multiply matrix to each column and store
            tempColumn = MultiplyColumn(firstMat, tempColumn);
            //copy to result Matrix column
            for (int k = 0; k < result.length; k++) {
                result[k][i] = tempColumn[k][0];
            }
        }

        return result;
    }

    public static int[][] MultiplyColumn(int[][] firstMat, int[][] secondMat) {
        //get big O
        int count = 0;

        int[][] a = new int[firstMat.length][firstMat[0].length];
        int[][] b = new int[secondMat.length][secondMat[0].length];

        //assume b is a vector column 
        int[][] res = new int[b.length][1];

        // copy firstMat to a
        for (int i = 0; i < firstMat.length; i++) {
            for (int j = 0; j < firstMat[0].length; j++) {
                a[i][j] = firstMat[i][j];
            }
        }

        //copy secondMat to b
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = secondMat[i][j];
            }
        }

        //each col index of mat "a" correspond to row index of mat "b"
        for (int colA = 0; colA < a[0].length; colA++) {
            //for each col traverse the row and multiply to the corresponding mat "b" index
            for (int rowA = 0; rowA < a.length; rowA++) {
                a[rowA][colA] *= b[colA][0];
                count++;
            }
        }

        //sum each col of A into the res matrix
        for (int colA = 0; colA < a[0].length; colA++) {
            for (int rowA = 0; rowA < a.length; rowA++) {
                res[rowA][0] += a[rowA][colA];
                count++;
            }
        }
        stepCount = count;

        return res;
    }

}
