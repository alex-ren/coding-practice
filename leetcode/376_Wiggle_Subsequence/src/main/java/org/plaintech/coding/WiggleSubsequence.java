package org.plaintech.coding;

import java.lang.Math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);

    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int updown = 0;
        int len = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            int next = nums[i + 1];
            if (next > cur) {
                if (updown <= 0) {
                    len++;
                }
                updown = 1;
                continue;
            } else if (next < cur) {
                if (updown >= 0) {
                    len++;
                }
                updown = -1;
                continue;
            } else {
                continue;
            }
        }

        int last2 = nums[nums.length - 2];
        int last = nums[nums.length - 1];

        if (last > last2 && updown <= 0) {
            len++;
        } else if (last < last2 && updown >= 0) {
            len++;
        }

        return len;
    }

    public static void main(String[] args) {
        Logger LOGGER = LoggerFactory.getLogger(WiggleSubsequence.class);
        WiggleSubsequence wiggle = new WiggleSubsequence();

        int[] testArr = new int[]{3, 4, 5, 3, 2};
        int length = wiggle.wiggleMaxLength(testArr);
        LOGGER.info("{} has wiggle subsequence of length {}", testArr, length);


    }
}