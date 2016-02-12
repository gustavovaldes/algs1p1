package com.guga.algs1p1.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class ThreeSumFastTest {

    @Test
    public void test(){
        int[] values = {30, -40, -20, -10, 40, 0, 10, 5};
        Assert.assertEquals(4,ThreeSumFast.count(values));
    }
}
