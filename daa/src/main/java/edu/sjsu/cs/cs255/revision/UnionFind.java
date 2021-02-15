package edu.sjsu.cs.cs255.revision;

public class UnionFind {

    int n;        // number of elements in set
    int[] parent; // parent element
    int[] size;   // size of component i

    int components;

    public UnionFind(int n) {
        this.n = n;
        this.parent = new int[n];
        this.size = new int[n];
        this.components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // return root node
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i]);
    }

    public int findIter(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public int findPathCompression(int i) {
        if (parent[i] == i) {
            return i;
        }
        int p = find(parent[i]);
        parent[i] = p;
        return p;
    }

    public void unionSets(int s1, int s2) {
        int r1 = find(s1);
        int r2 = find(s2);

        if (r1 == r2) {
            return;
        }

        if (size[r1] >= size[r2]) {
            parent[r2] = r1;
            size[r1] = size[r1] + size[r2];
        } else {
            parent[r1] = r2;
            size[r2]  = size[r1] + size[r2];
        }
    }

    public void unionSetsPc(int s1, int s2) {
        int r1 = findPathCompression(s1);
        int r2 = findPathCompression(s2);

        if (r1 == r2) {
            return;
        }

        if (size[r1] >= size[r2]) {
            parent[r2] = r1;
            size[r1] = size[r1] + size[r2];
        } else {
            parent[r1] = r2;
            size[r2]  = size[r1] + size[r2];
        }
        components--;
    }

    public boolean isSameComponent(int c1, int c2) {
        return find(c1) == findIter(c2);
    }

    public void test() {
        print();
        unionSets(1, 2);
        print();
        unionSets(5, 4);
        unionSets(9, 8);
        unionSets(7, 4);
        unionSets(5, 8);
        unionSets(0, 6);
        unionSets(0, 3);
        unionSets(3, 8);
        System.out.println(isSameComponent(1, 2));
        System.out.println(isSameComponent(1, 8));
        System.out.println(isSameComponent(6, 8));
        print();
        unionSets(2, 7);
        print();
    }

    public void testPc() {
        print();
        unionSetsPc(1, 2);
        print();
        unionSetsPc(5, 4);
        print();
        unionSetsPc(9, 8);
        print();
        unionSetsPc(7, 4);
        print();
        unionSetsPc(5, 8);
        print();
        System.out.println("c:8 size: " + getComponentSize(8));
        unionSetsPc(0, 6);
        print();
        unionSetsPc(0, 3);
        print();
        unionSetsPc(3, 8);
        print();
        System.out.println(isSameComponent(1, 2));
        System.out.println(isSameComponent(1, 8));
        System.out.println(isSameComponent(6, 8));
        unionSetsPc(2, 6);
        print();
        System.out.println(findPathCompression(0));
        print();
        System.out.println(findPathCompression(3));
        print();
        System.out.println(findPathCompression(2));
        print();

        System.out.println(findPathCompression(2));
        print();
    }

    private int getComponentSize(int i) {
        return size[find(i)];
    }

    private void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":" + parent[i]+ ":" + size[i] + " ");
        }
        System.out.println("nc:" + components);
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        unionFind.testPc();
    }
}
