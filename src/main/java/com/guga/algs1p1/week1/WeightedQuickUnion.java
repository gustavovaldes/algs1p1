package com.guga.algs1p1.week1;


/**
 * Created by guga
 *
 * initialize : N
 * find(connected): lg(N)
 * union:  lg(N)
 *
 * weight is by size, not height
 *
 */
public class WeightedQuickUnion {

    private int[] id;
    private int N;
    private int[] size;
    public WeightedQuickUnion(int N){
        id = new int[N];
        size = new int[N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;

        }
    }

    public boolean connected(int p, int q){
        return(root(p) == root(q));
    }

    public void union(int p, int q){ //change root of p to point root of q
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    public int root(int i){
        while(i!=id[i]){
            i= id[i];//chase parent until reach the root
        }
        return i;
    }

    //just for exercises
    public int[] getValues(){
        return id;
    }


}
