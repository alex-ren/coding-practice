package org.plaintech.utils;

import java.util.*;
import java.util.function.BiFunction;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Of no use now since I use the java.uitl.function.BiFunction.
interface IComparator<E> {

    int compare(E x, E y);
}

public class ArrayHeap<E> {
    static Logger LOGGER = LoggerFactory.getLogger(ArrayHeap.class);

    private int size;
    private ArrayList<E> elements;
    private BiFunction<? super E, ? super E, Integer> comparator;

    public ArrayHeap(int aCapacity, BiFunction<? super E, ? super E, Integer> aComparator) {
        size = 0;
        elements = new ArrayList<>(aCapacity + 1);
        elements.add(null);
        comparator = aComparator;
    }

    public ArrayHeap(Collection<? extends E> aElements, BiFunction<? super E, ? super E, Integer> aComparator) {
        size = aElements.size();
        elements = new ArrayList<>(size + 1);
        elements.add(null);
        for (E e: aElements) {
            elements.add(e);
        }
        comparator = aComparator;
        heapify();
    }

    public void add(E e) {
        elements.add(e);
        size++;
        heapifyUp(size);
    }

    private void assertRange(int pos) {
        if (pos <= 0 || pos > size) {
            throw new OutOfRangeException(pos, 1, size);
        }
    }

    private void heapifyUp(int pos) {
        LOGGER.info("heapifyUp Pos is {}.", pos);
        assertRange(pos);
        while (pos > 1) {
            int father = pos / 2;
            if (comparator.apply(elements.get(pos), elements.get(father)) > 0) {
                swap(pos, father);
                pos = father;
            } else {
                break;
            }
        }
    }

    private void heapify() {
        for (int i = size / 2; i > 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapifyDown(int pos) {
        assertRange(pos);

        int left = pos * 2;
        int right = left + 1;

        int largest = pos;

        if (left <= size) {
            if (comparator.apply(elements.get(left), elements.get(pos)) > 0) {
                largest = left;
            }
        }

        if (right <= size) {
            if (comparator.apply(elements.get(right), elements.get(largest)) > 0) {
                largest = right;
            }
        }

        if (largest != pos) {
            swap(pos, largest);
            heapifyDown(largest);
            return;
        }
    }

    void swap(int i, int j) {
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    /*
     * Sort in increasing order.
     */
    void heapSort() {
        int original = size;
        while (size > 1) {
            swap(1, size);
            size--;
            heapifyDown(1);
        }
        size = original;
    }

    public ArrayList<E> getElements() {
        ArrayList<E> res = new ArrayList<>(elements);
        res.remove(0);
        return res;
    }

    public static void main(String[] args) {
        LOGGER.info("This is from LOGGER.info.");
        System.out.println("This is from System.out.println.");
    }
}