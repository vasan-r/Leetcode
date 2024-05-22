package dp;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
//        System.out.println(Integer.MAX_VALUE+1);
//        System.out.println(1e9);
    }
    public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i][j] = -1;
            }
        }
//        return find(grid,r,c);
//        return findDp(grid,r,c,dp);
        return findDpTs(grid,r,c);
    }
    //solve using recursion
    public static int find(int[][] grid,int r, int c) {
        if(r==0 && c==0)
            return grid[0][0];
        if(r<0 || c<0)
            return Integer.MAX_VALUE;

        return grid[r][c]+Math.min(find(grid,r-1,c),find(grid,r,c-1));
    }
    // dp in recursion.
    public static int findDp(int[][] grid,int r, int c,int[][] dp) {
        if(r==0 && c==0)
            return grid[0][0];
        if(r<0 || c<0)
            return Integer.MAX_VALUE;
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        return dp[r][c]=grid[r][c]+Math.min(findDp(grid,r-1,c,dp),findDp(grid,r,c-1,dp));
    }
    // tabulated form.
    public static int findDpT(int[][] grid,int r, int c,int[][] dp) {

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i==0 && j==0)
                    dp[0][0]=grid[0][0];
                else {
                    int up = grid[i][j];
                    if(i>0){
                         up += dp[i-1][j];
                    }else{
                        up += 1e9;
                    }
                    int l = grid[i][j];
                    if(j>0){
                         l += dp[i][j-1];
                    }else{
                        l += 1e9;
                    }

                    dp[i][j]=Math.min(up,l);
                }
            }
        }
        return dp[r-1][c-1];

    }

    // Space optimization.

    public static int findDpTs(int[][] grid,int r, int c) {
        int[] curr = new int[r];
        int[] prev = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i==0 && j==0)
                    curr[j]=grid[0][0];
                else {
                    int up = grid[i][j];
                    if(i>0){
                        up += prev[j];
                    }else{
                        up += 1e9;
                    }
                    int l = grid[i][j];
                    if(j>0){
                        l += curr[j-1];
                    }else{
                        l += 1e9;
                    }

                    curr[j]=Math.min(up,l);
                }
                prev[j] = curr[j];
            }
        }
        return prev[c-1];

    }

}
