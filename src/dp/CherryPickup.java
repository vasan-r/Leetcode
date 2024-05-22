package dp;

import java.util.Arrays;

public class CherryPickup {
    public static void main(String[] args) {
        int[][] arr = {
                    {2,3,1,2},
                    {3,4,2,2},
                    {5,6,3,5}
            };
            System.out.println(cherryPickup(arr));
        }
        public static int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
            int[][][] memo = new int[r][c][c];

            for (int[][] row : memo) {
                for (int[] col : row) {
                    Arrays.fill(col, -1);
                }
            }
            return find(0,0,grid[0].length-1,grid,memo);

        }

    private static int find(int i, int j1, int j2, int[][] grid,int[][][] memo) {
        int r = grid.length;
        int c = grid[0].length;
        if(j1>=c || j2>=c || j2<0 || j1<0){
            return (int)-1e9;
        }
        if(i==r-1){
            if(j1==j2){
                return grid[i][j1];
            }else {
                return grid[i][j1]+grid[i][j2];
            }

        }
        if(memo[i][j1][j2] !=-1){
            return memo[i][j1][j2];
        }
        int max = 0;
        for(int k=-1;k<=1;k++){
            for(int l=-1;l<=1;l++){
                if(j1==j2){
                    max = Math.max(max, grid[i][j1]+find(i+1,j1+k,j2+l,grid,memo));
                }else {
                    max = Math.max(max,grid[i][j1]+grid[i][j2]+find(i+1,j1+k,j2+l,grid,memo));
                }
            }
        }
        return memo[i][j1][j2] = max;
    }


}
