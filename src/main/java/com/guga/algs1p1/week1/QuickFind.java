package com.guga.algs1p1.week1;

/**
 * Created by guga
 *
 * initialize : N
 * find(connected): 1 constant
 * union:  N (for N unions is N^2)  (too expensive)
 */
public class QuickFind {

    private int[] id;
    private int N;
    public QuickFind(int N){
        id = new int[N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return(id[p] == id[q]);
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < N; i++) {
            if(id[i]==pid) id[i]=qid;
        }
    }

    //just for exercises
    public int[] getValues(){
        return id;
    }

    public static void main(String args[]){

    }
}