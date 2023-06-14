package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

/**
 * 1172. Dinner Plate Stacks
 */

public class S1172 {
    // note: the index of stacks will not change
    private int capacity;
    private List<Deque<Integer>> stacks = new ArrayList<>();
    private TreeSet<Integer> idxes = new TreeSet<>(); // index of nonfull stacks

    public S1172(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        if (!idxes.isEmpty() && idxes.first() >= stacks.size())
            idxes.clear();

        if (idxes.isEmpty()) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.add(val);
            stacks.add(stack);
            if (stack.size() < capacity)
                idxes.add(stacks.size() - 1);
        } else {
            Deque<Integer> stack = stacks.get(idxes.first());
            stack.push(val);
            if (stack.size() == capacity)
                idxes.pollFirst();
        }
    }

    public int pop() {
        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty())
            return -1;

        Deque<Integer> stack = stacks.get(index);

        if (stack.size() == capacity)
            idxes.add(index);
        int val = stacks.get(index).pop();
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return val;
    }
}
