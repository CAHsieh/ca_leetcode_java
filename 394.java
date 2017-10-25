import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.decodeString("2[2[cd]2[ab]]"));
        System.out.println(sol.decodeString("2[b]"));
        System.out.println(sol.decodeString("3[a]2[bc]"));
        System.out.println(sol.decodeString("10[a]"));
    }

    public String decodeString(String s) {

        StringBuilder ans = new StringBuilder();
        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {

                StringBuilder repeatBuilder = new StringBuilder();
                StringBuilder resultBuilder = new StringBuilder();
                String c = stringStack.pop();
                while (!c.equals("[")) {
                    repeatBuilder.insert(0, c);
                    c = stringStack.pop();
                }

                StringBuilder timesBuilder = new StringBuilder();
                c = stringStack.peek();
                while (c.charAt(0)>='0' && c.charAt(0)<='9') {
                    stringStack.pop();
                    timesBuilder.insert(0, c);
                    if(stringStack.isEmpty()) break;
                    c = stringStack.peek();
                }
                int times = Integer.valueOf(timesBuilder.toString());
                while (times-- > 0) {
                    resultBuilder.append(repeatBuilder);
                }
                stringStack.add(resultBuilder.toString());
            } else {
                stringStack.add(s.substring(i, i + 1));
            }
        }

        while (!stringStack.isEmpty()) {
            ans.insert(0,stringStack.pop());
        }

        return ans.toString();
    }
}