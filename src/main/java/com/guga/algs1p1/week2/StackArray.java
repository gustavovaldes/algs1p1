package com.guga.algs1p1.week2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by guga
 * Simple Stack based on array.
 */
public class StackArray<T> implements Stack<T> {

    private T[] array;
    private int N = 0;

    private static final int MIN_INITIAL_CAPACITY = 10;
    private static final float DEFAULT_LOAD_FACTOR = 1f;
    private static final float DEFAULT_CLEAN_FACTOR = 0.25f;

    public StackArray() {
        array = (T[]) new Object[MIN_INITIAL_CAPACITY];
    }

    @Override
    public void push(T value) {//outbound exception if array is full
        ensureCapacity();
        array[N++] = value;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Empty Stack!!!");
        ensureCapacity();
        T val = array[--N];
        array[N] = null; //avoid loitering
        return val;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    private void ensureCapacity() {
        if (N / array.length >= DEFAULT_LOAD_FACTOR) {
            array = Arrays.copyOf(array, array.length * 2);
        } else if ((float)N / array.length <= DEFAULT_CLEAN_FACTOR && N > MIN_INITIAL_CAPACITY) {
            array = Arrays.copyOf(array, array.length / 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
