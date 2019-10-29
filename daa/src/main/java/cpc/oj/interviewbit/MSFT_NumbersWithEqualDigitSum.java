package cpc.oj.interviewbit;

import java.util.HashMap;
import java.util.Map;

public class MSFT_NumbersWithEqualDigitSum {

    private int addDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public int solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        int sum = -1;
        int j = 0;
        for (int i : arr) {
            int digSum = addDigits(i);
            if (map.containsKey(digSum)) {
                int index = map.get(digSum);
                int dupSum = arr[index] + i;
                if (dupSum > sum) {
                    sum = dupSum;
                }
            }
            map.put(addDigits(i), j);
        }
        return sum;
    }
}
