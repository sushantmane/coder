package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeNumber {
    private Set map = new HashSet();

    public static void main(String[] args) {
        PrimeNumber obj = new PrimeNumber();
        System.out.println(obj.findNumberOfWays("11373"));
        System.out.println(obj.findNumberOfWays("2577692357737"));

    }

    public int findNumberOfWays(String input) {
        List<List<Integer>> ways = new ArrayList<>();
        List<Integer> results = new ArrayList<Integer>();
        findPermutations(input, results, ways);
        return ways.size();
    }

    public void findPermutations(String suffix,
                                 List<Integer> results, List<List<Integer>> resultSet) {

        if (suffix.length() == 0) {
            resultSet.add(new ArrayList<Integer>(results));
            System.out.println(results.toString());
            return;
        }

        for (int i = 0; i < suffix.length(); ++i) {
            if (i >= 3) {
                continue;
            }
            String snumber = suffix.substring(0, i + 1);

            int numb = Integer.parseInt(snumber);
            boolean isPrime = isPrimeNumber(numb);
            if (isPrime) {
                results.add(numb);
                findPermutations(suffix.substring(i + 1), results, resultSet);
                results.remove(results.size() - 1);
            }
        }

    }

    public boolean isPrimeNumber(int number) {
        if (map.contains(number)) {
            return true;
        }
        boolean isPrime = isPrime(number);
        if (isPrime) map.add(number);

        return isPrime;
    }

    boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)    // 2 is prime
            return true;
        //check if n is a multiple of 2
        if (n % 2 == 0)
            return false;
        //if not, then just check the odds
        for (int i = 3; i <= n / 2; i = i + 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
