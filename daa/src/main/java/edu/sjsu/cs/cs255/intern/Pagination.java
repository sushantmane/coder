package edu.sjsu.cs.cs255.intern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pagination {

    static class Product {
        String name;
        int relevance;
        int price;

        public Product(String name, int relevance, int price) {
            this.name = name;
            this.relevance = relevance;
            this.price = price;
        }
    }

    private static Comparator<Product> getComparator(int s, int order) {
        System.out.println(s + " so:" + order);
        Comparator<Product> comparator = null;
        switch (s) {
            case 0:
                comparator = new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (order == 0) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.name.compareTo(o1.name);
                    }
                };
                break;
            case 1:
                comparator = new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (order == 0) {
                            return Integer.compare(o1.relevance, o2.relevance);
                        }
                        return Integer.compare(o2.relevance, o1.relevance);
                    }
                };
                break;
            case 2:
                comparator = new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (order == 0) {
                            return Integer.compare(o1.price, o2.price);
                        }
                        return Integer.compare(o2.price, o1.price);
                    }
                };
        }
        return comparator;
    }

    // sortParam:
    // 0 - name; 1- relevance; 2 - price
    // sortOrder:
    // 0 - asc; 1 - desc
    private static void fetchItemsToDisplay(String[][] items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {
        int nItems = items.length;
        List<Product> products = new ArrayList<>();
        for (String[] item : items) {
            products.add(new Product(item[0], Integer.parseInt(item[1]), Integer.parseInt(item[2])));
        }
        Comparator<Product> comparator = getComparator(sortParameter, sortOrder);
        Collections.sort(products, comparator);
        int pages = nItems / itemPerPage;
        int pageBase = pages * pageNumber;
        for (int i = pageBase; i < itemPerPage && i < products.size(); i++) {
            System.out.println(products.get(i).name);
        }
    }

    public static void main(String[] args) {
        String items[][] = {
                {"owjevtkuyv","58584272","62930912"},
                {"rpaqgbjxik","9425650","96088250"},
                {"dfbkasyqcn","37469674","46363902"},
                {"vjrrisdfxe","18666489","88046739"}
        };

//        String[][] items = {{"n1", "10", "15"}, {"n2", "3", "4"}, {"n3", "17", "8"}};
//        String[][] items = {{"owjevtkuyv", "58584272", "62930912"}, {"n2", "3", "4"}, {"n3", "17", "8"}};
        fetchItemsToDisplay(items, 2, 1, 2, 0);
    }
}
