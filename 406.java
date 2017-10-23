import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
/**
 * 這裡的考量是先看前面人數
 * 若從身高為考量點，從高到矮的話
 * 程式可以簡短很多
 * （搭配comparator）
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 1) return people;

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<people.length;i++){
            ArrayList<Integer> list = map.containsKey(people[i][1])?map.get(people[i][1]):new ArrayList<>();
            boolean isAdd = false;
            for(int j=0;j<list.size();j++){
                if(list.get(j) < people[i][0]){
                    list.add(j,people[i][0]);
                    isAdd = true;
                    break;
                }
            }
            if (!isAdd) {
                list.add(people[i][0]);
            }
            map.put(people[i][1],list);
        }

        TreeSet<Integer> keys = new TreeSet<>();
        keys.addAll(map.keySet());


        ArrayList<int[]> ans = new ArrayList<>();

        for(int key:keys){
            ArrayList<Integer> list = map.get(key);

            for(int val:list){
                int idx = 0;
                int count = 0;
                for(;idx<ans.size() && count < key;idx++){
                    if(ans.get(idx)[0] >= val){
                        count++;
                    }
                }
                ans.add(idx,new int[]{val,key});
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}