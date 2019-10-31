package cpc.oj.leetcode;

public class P1108_DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                str.append("[.]");
                continue;
            }
            str.append(c);
        }
        return str.toString();
    }
}
