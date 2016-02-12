package com.guga.algs1p1.week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by guga
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int head, tail;
    private Item[] array;
    private static final int MIN_INITIAL_CAPACITY = 2;
    private int N;


    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        array = (Item[]) new Object[MIN_INITIAL_CAPACITY];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item Item) {
        if (Item == null) throw new NullPointerException();
        ensureCapacity();
        array[tail++] = Item;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        adjustCapacity();
        int i = head + StdRandom.uniform(N);
        N--;
        Item Item = array[i];
        array[i] = array[head];
        array[head++] = null;
        return Item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return array[head + StdRandom.uniform(N)];
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (tail == array.length - 1) {
            Item[] newArray = (Item[]) new Object[2 * array.length];
            for (int i = head; i <= tail; i++) {
                newArray[i - head] = array[i];
            }
            array = newArray;
            tail = tail - head;
            head = 0;
        }
    }

    @SuppressWarnings("unchecked")
    private void adjustCapacity() {
        if ((double) (tail - head) / (array.length) <= 0.25) {
            Item[] newArray = (Item[]) new Object[array.length / 2];
            for (int i = head; i <= tail; i++) {
                newArray[i - head] = array[i];
            }
            array = newArray;
            tail = tail - head;
            head = 0;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    @SuppressWarnings("unchecked")
    private class ArrayIterator implements Iterator<Item> {

        int index = 0;
        Item[] values = (Item[]) new Object[N];

        public ArrayIterator() {
            for (int i = head; i <= tail - 1; i++) {
                values[i - head] = array[i];
            }
            StdRandom.shuffle(values);
        }

        @Override
        public boolean hasNext() {
            return N > index;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                return values[index++];
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
