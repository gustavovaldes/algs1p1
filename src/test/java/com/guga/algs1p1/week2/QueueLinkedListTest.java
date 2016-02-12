package com.guga.algs1p1.week2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class QueueLinkedListTest {

    @Test
    public void testString(){
        boolean pass = false;
        Queue<String> stack = new QueueLinkedList<>();
        stack.enqueue("one");
        stack.enqueue("two");
        Assert.assertEquals("one",stack.dequeue());
        stack.enqueue("three");
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(2, stack.size());
        Assert.assertEquals("two",stack.dequeue());
        Assert.assertEquals("three",stack.dequeue());
        Assert.assertTrue(stack.isEmpty());
        try{
            stack.dequeue();
        }catch (RuntimeException e){
            pass=true;
            Assert.assertEquals("Empty Queue!!!",e.getMessage());
        }
        Assert.assertTrue(pass);//todo replace  with junit rule
    }

    @Test
    public void testInt(){
        Queue<Integer> stack = new QueueLinkedList<>();
        stack.enqueue(1);
        stack.enqueue(2);
        stack.enqueue(3);
        stack.enqueue(4);
        stack.enqueue(5);
        Integer count = 1;
        while(!stack.isEmpty()){
            Assert.assertEquals(count, stack.dequeue());
            count++;
        }
        Assert.assertEquals(count, new Integer(6));
    }
}
