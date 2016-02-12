package com.guga.algs1p1.week2;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by guga
 */
public class RandomizedQueueTest {

    @Test
    public void testEnqueueDequeue() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        Assert.assertEquals(4, queue.size());
        Assert.assertFalse(queue.isEmpty());

        List<Integer> list = new ArrayList<>();
        list.add(queue.dequeue());
        list.add(queue.dequeue());
        list.add(queue.dequeue());
        list.add(queue.dequeue());
        Collections.sort(list);
        Assert.assertEquals(1, (int) list.get(0));
        Assert.assertEquals(2, (int) list.get(1));
        Assert.assertEquals(3, (int) list.get(2));
        Assert.assertEquals(4, (int) list.get(3));

        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmpty() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.dequeue();
    }

    @Test(expected = NullPointerException.class)
    public void testEnqueueNull() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue(null);
    }


    @Test
    public void testIterator() {
        RandomizedQueue<Long> queue = new RandomizedQueue<>();
        queue.enqueue(1L);
        queue.enqueue(2L);
        queue.enqueue(3L);
        queue.enqueue(4L);
        queue.enqueue(5L);

        Long l = 1L;
        for (Long aLong : queue) {
            System.out.println(aLong);
            l++;
        }
        Assert.assertEquals(l, Long.valueOf(6));


        /*
        Long x = 3L;
        queue.dequeue();
        queue.dequeue();
        for (Long aLong : queue) {
            Assert.assertEquals(x, aLong);
            x++;
        }
        Assert.assertEquals(Long.valueOf(6), x);


        Long LL = 3L;
        for (Long l1 : queue) {
            Long LL2 = 3L;
            for (Long l2 : queue) {
                Assert.assertEquals(l2, LL2);
                Assert.assertEquals(l1, LL);
                LL2++;
            }
            Assert.assertEquals(Long.valueOf(6), LL2);
            LL++;
        }
        Assert.assertEquals(Long.valueOf(6), LL);
        */
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextException() {
        RandomizedQueue<Long> queue = new RandomizedQueue<>();
        queue.enqueue(1L);
        queue.enqueue(2L);
        Iterator<Long> it = queue.iterator();
        int l = 0;
        while (it.hasNext()) {
            l++;
            System.out.println(it.next());
        }
        Assert.assertEquals(2, l);
        it.next();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        RandomizedQueue<Long> queue = new RandomizedQueue<>();
        queue.enqueue(1L);
        Iterator<Long> it = queue.iterator();
        Assert.assertEquals(1L, (long) it.next());
        it.remove();
    }

    @Test
    public void testEnqueueDequeueEmpty() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        Assert.assertEquals(0, queue.size());
        queue.enqueue(29);
        queue.enqueue(0);
        queue.enqueue(30);
        Assert.assertNotNull(queue.dequeue());
        queue.enqueue(5);
        Assert.assertNotNull(queue.dequeue());
        queue.enqueue(24);
        queue.enqueue(41);
        queue.enqueue(42);
        Assert.assertNotNull(queue.dequeue());
    }

    @Test
    public void testMixedOperations() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        Assert.assertEquals(0, queue.size());//        ==> 0
        queue.enqueue(204);
        Assert.assertEquals(204, (int) queue.dequeue());//     ==> 204
        Assert.assertTrue(queue.isEmpty());//    ==> true
        Assert.assertEquals(0, queue.size());// ==>0
        Assert.assertEquals(0, queue.size());// ==>0
        Assert.assertTrue(queue.isEmpty());// ==>true
        Assert.assertEquals(0, queue.size());// ==>0
        Assert.assertEquals(0, queue.size());// ==>0
        queue.enqueue(388);
        queue.enqueue(264);
        Assert.assertNotNull(queue.dequeue());// ==>null
    }

    @Test
    public void testSample() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.sample());
        }
    }

    @Test
    public void testRandomized() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        for (int i = 0; i < 500; i++) {


            int val = queue.sample();
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        for (Integer integer : map.keySet()) {
            System.out.println(integer + " : " + map.get(integer));
        }


    }

    private RandomizedQueue<String> newQueue() {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        return queue;
    }

    @Test
    public void testRandomizedString() {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 3000; i++) {

            RandomizedQueue<String> queue = newQueue();
            int x = 1;
            while (!"A".equals(queue.dequeue())) {
                x++;
            }
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }

        }

        for (Integer string : map.keySet()) {
            System.out.println(string + " : " + map.get(string));
        }


    }

    @Test
    public void testIteratorRandomOperations() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        queue.enqueue(16);
        queue.enqueue(17);
        queue.enqueue(18);
        queue.enqueue(19);
        queue.enqueue(20);
        queue.enqueue(21);
        queue.enqueue(22);
        queue.enqueue(23);
        queue.enqueue(24);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        //todo include array check
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }
}
