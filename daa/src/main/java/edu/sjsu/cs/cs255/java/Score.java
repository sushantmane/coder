package edu.sjsu.cs.cs255.java;

public class Score {

    int computerN2(int n) {
        int prev = -11;
        int current = -1;
        int len = 0;
        int score = 0;

        while (n > 0) {
            current = n % 10;
            System.out.println(current);
            n = n / 10;
            if (prev != -11) {
                if (current - prev == 1) {
                    len++;
                } else {
                    System.out.println("len: " + (len * len));
                    score += len * len;
                    len = 1;
                }
            } else {
                len++;
            }
            prev = current;
        }
        score += len * len;
        System.out.println("score: " + score);
        return 0;
    }

    public static void main(String[] args) {
        int a = 9765320;
        Score score = new Score();
//        score.computerN2(a);
        score.con5(1550515550);
    }

    int con5(int n) {
        int con = 0;
        int curr;
        int score = 0;

        while (n > 0) {
            curr = n % 10;
            n = n / 10;
            if (curr == 5) {
                if (con == 0) {
                    con = 1;
                } else if (con == 1) {
                    score += 3;
                    con++;
                } else {
                    score += 6;
                    con++;
                }
            } else {
                con = 0;
            }
        }
        System.out.println(score);
        return score;
    }
}
