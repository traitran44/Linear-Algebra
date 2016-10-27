public class multMatrix {
    public static void main(String[] args) {
        
    }

    public static int[] Multiply(int[][] a, int[][] b) {
        int[][] res = new int[b.length][1];

        //give a matrix and a column
        //each col index of mat a correspond to row index of mat b
        for (int colA = 0; colA < a[0].length; colA++) {
            //for each col traverse the row and multiply to the corresponding mat b index
            for (int rowA = 0; rowA < a.length; rowA++) {
                a[rowA][colA] *= b[colA][0];
            }
        }

        //sum each col of A into the res matrix
        for (int colA = 0; colA < a[0].length; colA++) {
            for (int rowA = 0; rowA < a.length; rowA++) {
                res[rowA][0] += a[rowA][colA];
            }
        }

        return res;
    }
}
