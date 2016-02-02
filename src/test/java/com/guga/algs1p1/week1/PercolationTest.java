package com.guga.algs1p1.week1;

import com.guga.common.util.FileReaderUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by gvaldes
 */
public class PercolationTest {


    private Percolation createPercolation(String file){
        Scanner sc = new FileReaderUtil().readResource(file);
        int N = sc.nextInt();         // N-by-N percolation system
        Percolation perc = new Percolation(N);
        while (sc.hasNextInt()) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            perc.open(i, j);
        }
        return perc;
    }

    @Test
    public void testInput1(){
        Percolation percolation = createPercolation("/week1/input1.txt");
        Assert.assertTrue(percolation.percolates());
    }

    @Test
    public void testInput1No(){
        Percolation percolation = createPercolation("/week1/input1-no.txt");
        Assert.assertFalse(percolation.percolates());
    }

    @Test
    public void testInput2(){
        Percolation percolation = createPercolation("/week1/input2.txt");
        Assert.assertTrue(percolation.percolates());
    }

    @Test
    public void testInput2No(){
        Percolation percolation = createPercolation("/week1/input2-no.txt");
        Assert.assertFalse(percolation.percolates());
    }

    @Test
    public void testInput3(){
        Percolation percolation = createPercolation("/week1/input3.txt");
        Assert.assertTrue(percolation.percolates());
    }

    @Test
    public void testInput4(){
        Percolation percolation = createPercolation("/week1/input4.txt");
        Assert.assertTrue(percolation.percolates());
    }

    @Test
    public void testInput5(){
        Percolation percolation = createPercolation("/week1/input5.txt");
        Assert.assertTrue(percolation.percolates());
    }

    @Test
    public void testInput6(){
        Percolation percolation = createPercolation("/week1/input6.txt");
        Assert.assertTrue(percolation.percolates());
    }
    @Test
    public void testInput7(){
        Percolation percolation = createPercolation("/week1/input7.txt");
        Assert.assertTrue(percolation.percolates());
    }
    @Test
    public void testInput8(){
        Percolation percolation = createPercolation("/week1/input8.txt");
        Assert.assertTrue(percolation.percolates());
    }
    @Test
    public void testInput8No(){
        Percolation percolation = createPercolation("/week1/input8-no.txt");
        Assert.assertFalse(percolation.percolates());
    }
    @Test
    public void testInput10(){
        Percolation percolation = createPercolation("/week1/input10.txt");
        Assert.assertTrue(percolation.percolates());
    }
    @Test
    public void testInput10No(){
        Percolation percolation = createPercolation("/week1/input10-no.txt");
        Assert.assertFalse(percolation.percolates());
    }
    @Test
    public void testInput20(){
        Percolation percolation = createPercolation("/week1/input20.txt");
        Assert.assertTrue(percolation.percolates());
        Assert.assertTrue(percolation.isOpen(1, 1));
        Assert.assertTrue(percolation.isFull(1, 1));
        Assert.assertTrue(percolation.isOpen(20, 1));
        Assert.assertFalse(percolation.isFull(20, 1));
        Assert.assertTrue(percolation.isOpen(19, 6));
        Assert.assertTrue(percolation.isFull(19, 6));
        Assert.assertFalse(percolation.isOpen(4, 3));
        Assert.assertFalse(percolation.isFull(4, 3));

    }
    @Test
    public void testInput50(){
        Percolation percolation = createPercolation("/week1/input50.txt");
        Assert.assertTrue(percolation.percolates());
    }
    @Test
    public void testInputJerry47(){
        Percolation percolation = createPercolation("/week1/jerry47.txt");
        Assert.assertTrue(percolation.percolates());
    }
    @Test
    public void testInputSedgewick60(){
        Percolation percolation = createPercolation("/week1/sedgewick60.txt");
        Assert.assertTrue(percolation.percolates());
    }
    @Test
    public void testInputWayne98(){
        Percolation percolation = createPercolation("/week1/wayne98.txt");
        Assert.assertTrue(percolation.percolates());
    }
    @Test
    public void testInputGreeting57(){
        Percolation percolation = createPercolation("/week1/greeting57.txt");
        Assert.assertFalse(percolation.percolates());
    }
    @Test
    public void testInputHeart25(){
        Percolation percolation = createPercolation("/week1/heart25.txt");
        Assert.assertFalse(percolation.percolates());
    }

}
