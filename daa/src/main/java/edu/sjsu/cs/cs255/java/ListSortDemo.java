package edu.sjsu.cs.cs255.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListSortDemo {

    static class Request {
        int reqId;

        Request(int reqId) {
            this.reqId = reqId;
        }

        public int getXid() {
            return reqId;
        }

        public void print() {
            System.out.println("ReqId: " + reqId);
        }
    }

    public static void main(String[] args) {
        List<Request> requests = new LinkedList<>();
        for (int i = 10; i > 0; i--) {
            requests.add(new Request(i));
        }
//        requests.stream().forEach(Request::print);
//        requests.sort(Comparator.comparing(Request::getXid));
//        Collections.sort(requests, Comparator.comparingInt(Request::getXid));
        Collections.sort(requests, (Request r1, Request r2) -> r1.getXid() - r2.getXid());
        requests.stream().forEach(Request::print);

    }
}
