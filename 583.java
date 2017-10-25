/**
 * 本題解即為計算兩字串扣掉最長共同子字串後的值加總。
 */
class Solution {
    public int minDistance(String word1, String word2) {

        int[][] lcs = new int[word1.length() + 1][word2.length() + 1];
        int max = 0;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }

                if (max < lcs[i][j])
                    max = lcs[i][j];
            }
        }

        return ((word1.length() - max) + (word2.length() - max));
    }
}