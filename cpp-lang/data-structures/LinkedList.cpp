//
// Created by Sushant Mane on 10/24/19.
//

#include <iostream>
#include "LinkedList.h"

void LinkedList::addNode(int data) {
    Node *n = new Node();
    n->data = data;
    n->next = nullptr;
    if (!head) {
        head = n;
        return;
    }
    Node *ptr = head;
    while (ptr->next) {
        ptr = ptr->next;
    }
    ptr->next = n;
}

void LinkedList::print() {
    Node *ptr = head;
    while (ptr) {
        std::cout << ptr->data << " ";
        ptr = ptr->next;
    }
}
