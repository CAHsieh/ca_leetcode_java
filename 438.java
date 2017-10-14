import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (null == s || 0 == s.length() || null == p || 0 == p.length())
            return ans;
        int[] table = new int[123]; //26個小寫英文字母(ASCII)的出現次數
        for (char c : p.toCharArray()) {
            table[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (table[s.charAt(right++)]-- > 0)
                count--; // >0表示說p裡面還有這個字元，比對到了就將總次數-1
            if (0 == count)
                ans.add(left); // 當count歸零表示出現次數完全吻合
            if (p.length() == right - left && table[s.charAt(left++)]++ >= 0)
                count++; //當比對的長度相同時，將最左方字元的次數加回去，並且增加count。 >=0絕對會對上，只是用來++用。
        }
        return ans;
    }
}