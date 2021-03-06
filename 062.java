/**
 * DP problem
 */
class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3,3));
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;

        int[][] path = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            path[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            path[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }

        return path[m][n];
    }
}