class Solution {

    // a ⊕ 0=a
    // a ⊕ a = 0
    // a ⊕ b ⊕ a = (a ⊕ a) ⊕ b = 0 ⊕ b = b
    // ⊕ => XOR

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}