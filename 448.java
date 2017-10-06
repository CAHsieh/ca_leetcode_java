import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] chk = new boolean[nums.length];
        ArrayList list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            chk[nums[i]-1] = true;
        }

        for(int i=0;i<nums.length;i++){
            if(!chk[i]) list.add(i+1);
        }

        return list;
    }
}