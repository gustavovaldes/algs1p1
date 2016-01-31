package com.guga.algs1p1.week1;


/**
 * Created by guga
 *
 * initialize : N
 * find(connected): N (worst, tall tree)
 * union:  N
 */
public class QuickUnion {

    private int[] id;
    private int N;
    public QuickUnion(int N){
        id = new int[N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return(root(p) == root(q));
    }

    public void union(int p, int q){ //change root of p to point root of q
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }

    public int root(int i){
        while(i!=id[i]){
            i= id[i];//chase parent until reach the root
        }
        return i;
    }
}
