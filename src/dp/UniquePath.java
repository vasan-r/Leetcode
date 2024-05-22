package dp;

public class UniquePath {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        System.out.println(find(arr,3-1,3-1));
    }

    private static int find(int[][] arr, int r, int c) {

        if(r==0 && c==0){
            return 1;
        }
        if(r<0 || c<0){
            return 0;
        }
        if(arr[r][c]==-1){
            return 0;
        }
        int l = find(arr,r-1,c);
        int ri = find(arr,r,c-1);
        return l+ri;
    }
}
