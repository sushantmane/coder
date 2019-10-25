//
// Created by Sushant Mane on 10/24/19.
//

#include "LinkedList.h"

int main() {
    LinkedList *list = new LinkedList();
    list->addNode(11);
    list->addNode(12);
    list->addNode(13);
    list->addNode(14);
    list->addNode(15);
    list->print();
    return 0;
}
