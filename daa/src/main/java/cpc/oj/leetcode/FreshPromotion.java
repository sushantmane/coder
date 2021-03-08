package cpc.oj.leetcode;

import java.util.Arrays;

public class FreshPromotion {

    static int winPrize(String[][] codeList, String[] shoppingCart) {
        for (String[] cl : codeList) {
            Arrays.stream(cl).forEach(k -> System.out.print(k + " "));
            System.out.print(" | ");
        }
        System.out.println();
        Arrays.stream(shoppingCart).forEach(k -> System.out.print(k + " "));
        System.out.println();
        int matchIdx = 0;
        int list = 0;
        while (list < codeList.length && matchIdx < shoppingCart.length) {
            System.out.println("matchIdx: " + matchIdx);
            int fcIdx = 0;
            String[] group = codeList[list];
            boolean match = true;
            for (int fruitIdx = matchIdx; fcIdx < group.length  &&  fruitIdx < shoppingCart.length; fruitIdx++) {
                System.out.println(group[fcIdx] + " " + shoppingCart[fruitIdx] + " " + fruitIdx);
                if (group[fcIdx].equals(shoppingCart[fruitIdx]) || group[fcIdx].equals("anything")) {
                    fcIdx++;
                } else {
                    match = false;
                    break;
                }
            }
            if (!match) {
                matchIdx++;
                continue;
            }
            matchIdx += group.length;
            list++;
        }
        System.out.println("list: " + list);
        if (list == codeList.length) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        String[][] codeList;
        String[] shoppingCart;
//        codeList = new String[][] {{"apple", "apple"}, {"banana", "anything", "banana"}};
//        shoppingCart = new String[]{"orange", "apple", "apple", "banana", "orange", "banana"};
//        System.out.println(winPrize(codeList, shoppingCart));
//
//        codeList = new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}};
//        shoppingCart = new String[]{"banana", "orange", "banana", "apple", "apple"};
//        System.out.println(winPrize(codeList, shoppingCart));

//
//        codeList = new String[][]{{"apple", "apple"}, {"banana", "anything", "banana"}};
//        shoppingCart = new String[]{"apple", "banana", "apple", "banana", "orange", "banana"};
//        System.out.println(winPrize(codeList, shoppingCart));

        // [[apple, apple], [apple, apple, banana]] shoppingCart = [apple, apple, apple, banana]
        codeList = new String[][]{{"apple", "apple"}, {"apple", "apple", "banana"}};
        shoppingCart = new String[]{"apple", "apple", "apple", "banana"};
        System.out.println(winPrize(codeList, shoppingCart));


    }
}
