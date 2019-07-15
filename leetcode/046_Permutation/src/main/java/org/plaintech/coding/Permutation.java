package org.plaintech.coding;

import java.util.*;

class Permutation {
    class State{
        public int exchange;
        public int length;
        public State(int aExchange, int aLength) {
            exchange = aExchange;
            length = aLength;
        }
    }

    void addStates(LinkedList<State> stack, int length) {
        while (length >= 1) {
            stack.push(new State(0, length--));
        }
    }

    void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    List<Integer> array2list(int[] arr) {
        List<Integer> xs = new ArrayList<Integer>(arr.length);
        for (int i = 0; i < arr.length; ++i) {
            xs.add(arr[i]);
        }
        return xs;
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<State> stack = new LinkedList<State>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        addStates(stack, nums.length);
        while (stack.size() > 0) {
            State s = stack.pop();
            if (1 == s.length) {
                List<Integer> xs = array2list(nums);
                res.add(xs);
            } else {
                int start = nums.length - s.length;
                swap(nums, start, start + s.exchange);
                if (s.exchange < (s.length - 1)) {
                    s.exchange++;
                    swap(nums, start, start + s.exchange);
                    stack.push(s);
                    addStates(stack, s.length - 1);
                }
            }

        }

        return res;

    }

    static public void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Permutation p = new Permutation();
        List<List<Integer>> xss = p.permute(arr);
        System.out.println(xss);
    }
}
