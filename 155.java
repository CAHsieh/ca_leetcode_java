import java.util.HashMap;
import java.util.Stack;
import java.util.TreeSet;

class MinStack {

    Stack<Integer> stack = null;
    TreeSet<Integer> set = null;
    HashMap<Integer, Integer> map = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        set = new TreeSet<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        stack.push(x);
        set.add(x);
        int times = map.containsKey(x)?map.get(x):0;
        map.put(x,times+1);
    }

    public void pop() {
        int x = stack.pop();
        int times = map.get(x) - 1;
        if (0 == times) {
            set.remove(x);
        }
        map.put(x, times);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return set.first();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */