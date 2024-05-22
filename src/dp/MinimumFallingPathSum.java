package dp;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] arr = {
                {2,1,3},
                {6,5,4},
                {7,8,9}
        };
//        System.out.println(1e9);
        System.out.println(minFallingPathSum(arr));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int r = matrix.length-1;
        int c = matrix[0].length-1;
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[r+1][c+1];
        for(int i = c; i >=0; i--) {
            int min =  find(matrix,r,i,dp);
            result = Math.min(result,min);

        }
        return result;

    }

    private static int find(int[][] matrix, int r, int c,int[][] dp) {
        if(r<0 || c<0 || c>matrix[0].length-1){
            return (int)1e9;
        }
        if(r==0 ){
            return matrix[r][c];
        }
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        int d = matrix[r][c] + find(matrix,r-1,c,dp);
        int dl = matrix[r][c] + find(matrix,r-1,c-1,dp);
        int dr = matrix[r][c] + find(matrix,r-1,c+1,dp);

        int min = Math.min(d,dl);
        return dp[r][c] =  Math.min(min,dr);
    }

}
