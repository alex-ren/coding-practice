package org.plaintech.utils;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestArrayHeap {
    Logger LOGGER = LoggerFactory.getLogger(TestArrayHeap.class);

    @Test
    public void test01() {
        LOGGER.info("This is test01.");

        ArrayHeap<Integer> heap = new ArrayHeap<>(
                Arrays.asList(5, 4, 7, 1, 100, 6, 3),
                (x, y) -> { if (x > y) { return 1; } else if (x == y) { return 0; } else { return -1; } }
                );

        Assert.assertEquals(Arrays.asList(100, 5, 7, 1, 4, 6, 3), heap.getElements());
        LOGGER.info("heap is {}", heap.getElements());

        heap.heapSort();
        LOGGER.info("sorted is {}", heap.getElements());
        Assert.assertEquals(Arrays.asList(1, 3, 4, 5, 6, 7, 100), heap.getElements());

    }

    @Test
    public void test02() {
        LOGGER.info("This is test02 .");
        System.out.println("Hello World!");

        ArrayHeap<Integer> heap = new ArrayHeap<>(
                100,
                (x, y) -> { if (x > y) { return 1; } else if (x == y) { return 0; } else { return -1; } }
        );

        heap.add(100);
        heap.add(5);
        heap.add(7);
        heap.add(1);
        heap.add(4);
        heap.add(6);
        heap.add(3);

        Assert.assertEquals(Arrays.asList(100, 5, 7, 1, 4, 6, 3), heap.getElements());
        LOGGER.info("heap is {}", heap.getElements());

        heap.heapSort();
        LOGGER.info("sorted is {}", heap.getElements());
        Assert.assertEquals(Arrays.asList(1, 3, 4, 5, 6, 7, 100), heap.getElements());

    }}
