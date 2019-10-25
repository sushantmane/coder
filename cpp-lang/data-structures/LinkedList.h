//
// Created by Sushant Mane on 10/24/19.
//

#ifndef CPP_LANG_LINKEDLIST_H
#define CPP_LANG_LINKEDLIST_H


class LinkedList {

public:
    struct Node {
        int data;
        Node *next;
    };

    LinkedList() {}

    void addNode(int data);
    void print();

private:
    Node *head;
};


#endif //CPP_LANG_LINKEDLIST_H
