import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (String s : sol.generateParenthesis(3)) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {

        StringBuilder builder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            builder.append("(");
        }
        list.add(builder.toString());
        for (int i = 1; i <= n; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                list.addAll(Add(new StringBuilder(list.get(j)), i));
            }
        }

        list.removeIf(p -> p.length() != (n * 2));

        return list;
    }

    private List<String> Add(StringBuilder builder, int idx) {
        int count = 0;
        int rightCount = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '(') {
                count++;
            } else {
                rightCount++;
            }
            if (count == idx) {
                for (int j = 0; j < count - rightCount; j++){
                    builder.insert(i + 1, ")");
                    list.add(builder.toString());
                }
                break;
            }
        }
        return list;
    }
}