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
public class WeightedQuickUnionPathCompression {

    private int[] id;
    private int N;
    private int[] size;
    public WeightedQuickUnionPathCompression(int N){
        id = new int[N];
        size = new int[N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 0;

        }
    }

    public boolean connected(int p, int q){
        return(root(p) == root(q));
    }

    public void union(int p, int q){ //change root of p to point root of q
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) return;

        // make smaller root point to larger one
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

    public int root(int i){
        int root = i;
        while(root!=id[root]){
            root= id[root];//chase parent until reach the root
        }
        while (i != root) {//from node to root update references
            int newp = id[i];
            id[i] = root;
            i = newp;
        }
        return i;
    }
}
