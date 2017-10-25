/**
 * DP Problem
 */
class Solution {
    public int numTrees(int n) {

        int[] T = new int[n + 1];
        T[0] = 1;
        T[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j=i-1;j>=0;j--){
                T[i] += (T[j]*T[i-1-j]);
            }
        }

        return T[n];
    }
}