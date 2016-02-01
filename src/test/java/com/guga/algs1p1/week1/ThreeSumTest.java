package com.guga.algs1p1.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class ThreeSumTest {

    @Test
    public void test(){
        int[] values = {30, -40, -20, -10, 40, 0, 10, 5};
        ThreeSum t = new ThreeSum(values);
        Assert.assertEquals(4,t.count());
    }
}
