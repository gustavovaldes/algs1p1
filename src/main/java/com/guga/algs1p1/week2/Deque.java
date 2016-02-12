package com.guga.algs1p1.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by guga
 * part 1 assignment week2
 * <p>
 * double linked list
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first, last;
    private int N;

    public Deque() {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item Item) {
        if (Item == null) throw new NullPointerException();
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.Item = Item;
        if (oldFirst != null) {  //todo improve logic with less conditions
            first.next = oldFirst;
            oldFirst.previous = first;
        } else if (last != null) {
            first.next = last;
            last.previous = first;
        } else if (last == null) {
            last = first;
        }
        N++;
    }

    public void addLast(Item Item) {
        if (Item == null) throw new NullPointerException();
        Node<Item> oldLast = last;
        last = new Node<>();
        last.Item = Item;
        if (oldLast != null) {
            last.previous = oldLast;
            oldLast.next = last;
        } else if (first != null) {
            last.previous = first;
            first.next = last;
        } else if (first == null) {
            first = last;
        }
        N++;
    }

    public Item removeFirst() {
        if (first != null) {
            Item Item = first.Item;
            first = first.next;
            if (first != null) first.previous = null;
            N--;
            if (isEmpty()) last = null;
            return Item;
        } else if (last != null) {
            Item Item = last.Item;
            last = null;
            N--;
            return Item;
        }
        throw new NoSuchElementException();
    }

    public Item removeLast() {
        if (last != null) {
            Item Item = last.Item;
            last = last.previous;
            if (last != null) last.next = null;
            N--;
            if (isEmpty()) first = null;
            return Item;
        } else if (first != null) {
            Item Item = first.Item;
            first = null;
            N--;
            return Item;
        }
        throw new NoSuchElementException();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node<Item> {
        Node<Item> next;
        Node<Item> previous;
        Item Item;
    }

    private class ListIterator implements Iterator<Item> {


        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item Item = current.Item;
            current = current.next;
            return Item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}
