import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
/**
 * Here is simulate ans
 * think about math solution when use go
 */
class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
        System.out.println(sol.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));
        System.out.println(sol.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 50));
        System.out.println(
                sol.leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> coolTimes = new HashMap<>();
        List<StringBuilder> allTasks = new ArrayList<>();

        for (char c : tasks) {
            boolean isAdd = false;
            for (int i = 0; i < allTasks.size(); i++) {
                if (allTasks.get(i).charAt(0) == c) {
                    allTasks.get(i).append(c);
                    isAdd = true;
                }
            }
            if (!isAdd) {
                allTasks.add(new StringBuilder().append(c));
                coolTimes.put(c, 0);
            }
        }

        Comparator<StringBuilder> comparator = new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder s1, StringBuilder s2) {
                return s2.length() - s1.length();
            }
        };

        allTasks.sort(comparator);
        int qkTimes = 0;
        int remainingTask = tasks.length;
        while (remainingTask > 0) {
            boolean isExec = false;
            char executeTask = ' ';

            for (int j = 0; j < allTasks.size() && !isExec; j++) {
                if (0 == allTasks.get(j).length())
                    continue;
                int times = coolTimes.getOrDefault(allTasks.get(j).charAt(0), 0);
                if (times == 0) {
                    executeTask = allTasks.get(j).charAt(0);
                    isExec = true;

                    coolTimes.put(executeTask, n);
                    allTasks.get(j).deleteCharAt(allTasks.get(j).length() - 1);
                    remainingTask--;

                    if (allTasks.get(j).length() == 0) {
                        coolTimes.remove(executeTask);
                    }

                    // System.out.print(executeTask + " ");
                }
            }
            if (remainingTask == 0)
                break;

            int minCoolTimes = -1;
            for (char key : coolTimes.keySet()) {
                if (key != executeTask && coolTimes.get(key) > 0) {
                    coolTimes.put(key, coolTimes.get(key) - 1);
                }
                if (minCoolTimes == -1 || coolTimes.get(key) < minCoolTimes)
                    minCoolTimes = coolTimes.get(key);
                // System.out.println(executeTask + "," + key + " " + coolTimes.get(key));
            }

            if (minCoolTimes > 0) {
                qkTimes += minCoolTimes;
                // System.out.println("qk" + minCoolTimes + " ");
                for (char key : coolTimes.keySet()) {
                    int times = coolTimes.get(key) - minCoolTimes;
                    // System.out.println("qk " + key + " " + times);
                    coolTimes.put(key, times);

                }
            }

            allTasks.sort(comparator);
        }

        return tasks.length + qkTimes;
    }
}