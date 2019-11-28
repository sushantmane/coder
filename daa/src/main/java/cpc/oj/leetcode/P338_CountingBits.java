package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P338_CountingBits {

    public int[] countBits(int num) {
        List<Integer> lastSeq = Arrays.asList(1);
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        while (res.size() <= num) {
            List<Integer> tmpSeq = new ArrayList<>();
            for (int p : lastSeq) {
                res.add(p);
                tmpSeq.add(p);
                if (res.size() > num) {
                    break;
                }
            }
            if (res.size() > num) {
                break;
            }

            int index = 0;
            int partSize = lastSeq.size() / 2;
            while (partSize > 0) {
                index = index + partSize;
                partSize = partSize / 2;
                for (int j = index; j < lastSeq.size(); j++) {
                    res.add(lastSeq.get(j));
                    tmpSeq.add(lastSeq.get(j));
                    if (res.size() > num) {
                        break;
                    }
                }
                if (res.size() > num) {
                    break;
                }
            }
            if (res.size() > num) {
                break;
            }
            int highOnes = res.get(res.size() - 1) + 1;
            res.add(highOnes);
            tmpSeq.add(highOnes);

            // update last seq
            lastSeq = tmpSeq;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        P338_CountingBits obj = new P338_CountingBits();
        obj.countBits(150);
    }
}
