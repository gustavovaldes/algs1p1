package com.guga.algs1p1.week2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by guga
 */
public class DequeTest {

    @Test
    public void testFirst() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        Assert.assertFalse(deque.isEmpty());
        Assert.assertEquals(4d, deque.size(),0d);

        Assert.assertEquals(4, (int) deque.removeFirst());
        Assert.assertEquals(3, (int) deque.removeFirst());
        Assert.assertEquals(1, (int) deque.removeLast());
        Assert.assertEquals(2, (int) deque.removeLast());
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0d, deque.size(),0d);
    }


    @Test
    public void testLast() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);

        Assert.assertEquals(1, (int) deque.removeFirst());
        Assert.assertEquals(2, (int) deque.removeFirst());
        Assert.assertEquals(4, (int) deque.removeLast());
        Assert.assertEquals(3, (int) deque.removeLast());
    }

    @Test
    public void testFirstLast() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(3);
        deque.addFirst(2);
        deque.addLast(4);
        deque.addLast(5);
        deque.addFirst(1);

        Assert.assertEquals(1, (int) deque.removeFirst());
        Assert.assertEquals(2, (int) deque.removeFirst());
        Assert.assertEquals(3, (int) deque.removeFirst());
        Assert.assertEquals(5, (int) deque.removeLast());
        Assert.assertEquals(4, (int) deque.removeLast());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmpty() {
        Deque<String> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NullPointerException.class)
    public void testNullFirst() {
        Deque<String> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullLast() {
        Deque<String> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test
    public void testIterator() {
        Deque<Long> deque = new Deque<>();
        deque.addLast(1l);
        deque.addLast(2l);
        deque.addLast(3l);
        deque.addLast(4l);
        deque.addLast(5l);

        Long l = 1L;
        for (Long aLong : deque) {
            Assert.assertEquals(l, aLong);
            l++;
        }
        Assert.assertEquals(l, Long.valueOf(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextException() {
        Deque<Long> deque = new Deque<>();
        deque.addFirst(1L);
        deque.addLast(2L);
        Iterator<Long> it = deque.iterator();
        Long l = 1L;
        while (it.hasNext()) {
            Assert.assertEquals(l, it.next());
            l++;
        }
        it.next();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        Deque<Long> deque = new Deque<>();
        deque.addFirst(1L);
        deque.addLast(2L);
        Iterator<Long> it = deque.iterator();
        Assert.assertEquals(1L, (long) it.next());
        it.remove();
    }

    @Test
    public void testAddFirstRemoveLast(){
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(0);
        Assert.assertEquals(0,(int)deque.removeLast());
        deque.addFirst(2);
        deque.addFirst(3);
        Assert.assertEquals(2,(int)deque.removeLast());
    }

    @Test
    public void testIteratorAfterMixedOperations(){
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addFirst(6);
        deque.addFirst(7);
        deque.addLast(8);
        deque.removeFirst();//7
        deque.addLast(10);
        deque.removeLast();//    ==> 10
        Integer[] result = new Integer[]{6,3,2,1,4,5,8};
        int i=0;
        for (Integer value : deque) {
            Assert.assertEquals(result[i], value);
            i++;
        }
        Assert.assertEquals(7,i);
        i=0;
        System.out.println();
        while (!deque.isEmpty()){
            Assert.assertEquals(result[i], deque.removeFirst());
            i++;
        }
        Assert.assertEquals(7,i);
    }
}
