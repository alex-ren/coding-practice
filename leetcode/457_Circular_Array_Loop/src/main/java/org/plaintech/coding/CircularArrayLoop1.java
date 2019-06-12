package org.plaintech.coding;

class CircularArrayLoop1 {

    private int findUnvisited(Boolean[] visited, int pos) {
        while (pos < visited.length) {
            if (false == visited[pos]) {
                return pos;
            } else {
                pos++;
            }
        }

        return pos;
    }

    private int nextPos(int[] nums, int pos) {
        int next = (pos + nums[pos]) % nums.length;
        if (next < 0) {
            return nums.length + next;
        } else {
            return next;
        }
    }

    public boolean circularArrayLoop(int[] nums) {
        Boolean[] visited = new Boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            visited[i] = false;
        }

        int start = 0;
        while (true) {
            start = findUnvisited(visited, start);
            int curPos = start;

            if (visited.length == curPos) {
                return false;
            }

            int direction = nums[curPos];

            int count = 0;
            while (true) {
                visited[curPos] = true;
                int nextPos = nextPos(nums, curPos);
                if (nextPos == curPos) {
                    break;  // length of the loop is 1.
                }

                int nextDirection = nums[nextPos];
                if (direction * nextDirection < 0) {
                    break;  // change of direction
                }


                curPos = nextPos;
                count++;
                if (count >= nums.length) {
                    return true;
                }
            }

        }
    }
}