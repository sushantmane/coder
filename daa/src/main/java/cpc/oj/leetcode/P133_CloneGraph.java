package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class P133_CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public Node cloneGraph(Node node) {
        return null;
    }


    public void bfs(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Set<Node> discovered = new HashSet<>();
        Set<Node> processed = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        discovered.add(node);
        Node clone = new Node();
        clone.val = node.val;

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            processed.add(cur);
            System.out.println("processing:" + cur.val);

            for (Node nbr : cur.neighbors) {
                if (!processed.contains(nbr)) {
                    System.out.println("Edge: " + cur.val + ", " + nbr.val);
                    Node curClone = map.get(cur);
                    if (curClone == null) {
                        curClone = new Node();
                        curClone.val = cur.val;
                        curClone.neighbors = new LinkedList<>();
                        map.put(cur, curClone);
                    }
                    Node nbrClone = map.get(nbr);
                    if (nbrClone == null) {
                        nbrClone = new Node();
                        nbrClone.val = nbr.val;
                        nbrClone.neighbors = new LinkedList<>();
                        map.put(nbr, nbrClone);
                    }
                    nbrClone.neighbors.add(curClone);
                    curClone.neighbors.add(nbrClone);
                }
                if (!discovered.contains(nbr)) {
                    queue.add(nbr);
                    discovered.add(nbr);
                }
            }
        }

        for (Node n :  discovered) {
            System.out.println(n.neighbors + " " + map.get(n).neighbors);
        }
    }

    public Node createGraph() {
        Node v1 = new Node();
        v1.val = 1;
        v1.neighbors = new ArrayList<>();

        Node v2 = new Node();
        v2.val = 2;
        v2.neighbors = new ArrayList<>();

        Node v3 = new Node();
        v3.val = 3;
        v3.neighbors = new ArrayList<>();

        Node v4 = new Node();
        v4.val = 4;
        v4.neighbors = new ArrayList<>();

        v1.neighbors.add(v2);
        v1.neighbors.add(v4);

        v2.neighbors.add(v1);
        v2.neighbors.add(v3);

        v3.neighbors.add(v2);
        v3.neighbors.add(v4);

        v4.neighbors.add(v1);
        v4.neighbors.add(v3);

        return v1;
    }

    public static void main(String[] args) {
        P133_CloneGraph obj = new P133_CloneGraph();
        Node root = obj.createGraph();
        obj.bfs(root);
    }
}