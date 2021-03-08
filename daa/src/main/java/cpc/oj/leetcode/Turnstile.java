package cpc.oj.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Turnstile {
    public static int[] getTimes1(int numCustomers, int[] arrTime, int[] direction) {
        int[] res = new int[arrTime.length];

        int p = 1;
        int t = 0;
        int i = 0;

        int turn = 1;
        List<Integer> waitList = new LinkedList<>();
        while (p <= numCustomers) {
            t++;

            while (i < arrTime.length && arrTime[i] == t) {
                waitList.add(i);
                i++;
            }
//
//            if (waitList.size() == 1) {
//                int idx = waitList.remove(0);
//                res[idx] = t;
//                turn = direction[idx];
//                p++;
//                continue;
//            }

            boolean exit = false;
            for (int j = 0; j < waitList.size(); j++) {
                if (direction[waitList.get(j)] == turn) {
                    int idx = waitList.remove(j);
                    res[idx] = t;
                    p++;
                    turn = direction[idx];
                    exit = true;
                    break;
                }
            }

            if (exit) {
                continue;
            }

            if (waitList.size() > 0) {
                int idx = waitList.remove(0);
                res[idx] = t;
                p++;
                turn = direction[idx];
            } else {
                turn = 1;
            }
        }

        return res;
    }

    public static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
        int[] res = new int[arrTime.length];
        Queue<Integer> enterQueue = new LinkedList<>();
        Queue<Integer> exitQueue = new LinkedList<>();
        int time = 0;  // time
        int pIdx = 0; // person index
        int turn = 1; // default turn
        int processed = 0;
        int waiting = 0;
        while (processed < numCustomers) {
            time++;
            while (pIdx < arrTime.length && arrTime[pIdx] == time) {
                if (direction[pIdx] == 1) {
                    exitQueue.add(pIdx);
                } else {
                    enterQueue.add(pIdx);
                }
                waiting++;
                pIdx++;
            }

            int personsTurn;
            if (waiting >= 1) {
                if ((turn == 1 && exitQueue.size() > 0) || enterQueue.size() == 0) {
                    personsTurn = exitQueue.remove();
                } else {
                    personsTurn = enterQueue.remove();
                }
                res[personsTurn] = time;
                turn = direction[personsTurn];
                processed++;
                waiting--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int numPersons = 5;
        //                 0  1  2  3  4
        int[] arrTime =   {1, 2, 2, 4, 4};
        int[] direction = {0, 1, 0, 0, 1};
        int[] res = getTimes(numPersons, arrTime, direction);
        Arrays.stream(res).forEach(k -> System.out.print(k + " "));

        System.out.println();
        numPersons = 4;
        arrTime = new int[]{1, 1, 2, 6};
        direction = new int[]{0, 1, 1, 0};
        res = getTimes(numPersons, arrTime, direction);
        Arrays.stream(res).forEach(k -> System.out.print(k + " "));
    }
}
