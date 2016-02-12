package com.guga.algs1p1.week2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class QueueArrayTest {
    @Test
    public void testString(){
        boolean pass = false;
        Queue<String> Queue = new QueueArray<>();
        Queue.enqueue("one");
        Queue.enqueue("two");
        Assert.assertEquals("one",Queue.dequeue());
        Queue.enqueue("three");
        Assert.assertFalse(Queue.isEmpty());
        Assert.assertEquals(2, Queue.size());
        Assert.assertEquals("two",Queue.dequeue());
        Assert.assertEquals("three",Queue.dequeue());
        Assert.assertTrue(Queue.isEmpty());
        try{
            Queue.dequeue();
        }catch (RuntimeException e){
            pass=true;
            Assert.assertEquals("Empty Queue!!!",e.getMessage());
        }
        Assert.assertTrue(pass);//todo replace  with Mockito or ExpectedException junit rule
    }

    @Test
    public void testInt(){
        Queue<Integer> Queue = new QueueArray<>();
        Queue.enqueue(1);
        Queue.enqueue(2);
        Queue.enqueue(3);
        Queue.enqueue(4);
        Queue.enqueue(5);
        Integer count = 1;
        while(!Queue.isEmpty()){
            Assert.assertEquals(count, Queue.dequeue());
            count++;
        }
        Assert.assertEquals(count, new Integer(6));
    }

    @Test
    public void testResize(){
        Queue<Integer> Queue = new QueueArray<>();
        for (int i= 1; i<100; i++){
            Queue.enqueue(i);
        }
        Integer i = 1;
        while(!Queue.isEmpty()){//todo add reflection analyzer to verify array size
            Assert.assertEquals(i, Queue.dequeue());
            i++;
        }
    }
}
