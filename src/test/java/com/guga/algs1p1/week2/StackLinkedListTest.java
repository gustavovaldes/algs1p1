package com.guga.algs1p1.week2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class StackLinkedListTest {

    @Test
    public void testString(){
        boolean pass = false;
        Stack<String> stack = new StackLinkedList<>();
        stack.push("one");
        stack.push("two");
        Assert.assertEquals("two",stack.pop());
        stack.push("three");
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(2, stack.size());
        Assert.assertEquals("three",stack.pop());
        Assert.assertEquals("one",stack.pop());
        Assert.assertTrue(stack.isEmpty());
        try{
        stack.pop();
        }catch (RuntimeException e){
            pass=true;
            Assert.assertEquals("Empty Stack!!!",e.getMessage());
        }
        Assert.assertTrue(pass);//todo replace  with Mockito.
    }

    @Test
    public void testInt(){
        Stack<Integer> stack = new StackLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Integer count = 5;
        while(!stack.isEmpty()){
            Assert.assertEquals(count, stack.pop());
            count--;
        }
        Assert.assertEquals(count, new Integer(0));
    }

    public void testIterator(){
        Stack<Integer> stack = new StackLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for (Integer integer : stack) {

        }
    }
}
