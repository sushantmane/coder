#include "IntList.h"

IntList::IntList(): Items(new int[SIZE]), numItems(0), arraySize(SIZE) {
}

IntList::~IntList() {
    delete[] Items;
}

IntList::IntList(const IntList& L): Items(new int[L.arraySize]),
                                    numItems(L.numItems),
                                    arraySize(L.arraySize) {
    for (int i = 0; i < numItems; i++) {
        Items[i] = L.Items[i];
    }
}

IntList& IntList::operator=(const IntList &L) {
    if (this == &L) {
        return *this;
    }
    delete[] Items;
    Items = new int[L.arraySize];
    arraySize = L.arraySize;
    numItems = L.numItems;
    for (int i = 0; i < numItems; i++) {
        Items[i] = L.Items[i];
    }
    return *this;
}

void IntList::operator+=(int n) {
    AddToEnd(n);
}

void IntList::AddToEnd(int k) {
    if (numItems == arraySize) {
        Resize();
    }
    Items[numItems] = k;
    numItems++;
}

void IntList::Resize() {
    int* newArr = new int[2 * arraySize];
    for (int i = 0; i < arraySize; i++) {
        newArr[i] = Items[i];
    }
    arraySize = 2 * arraySize;
    delete[]  Items;
    Items = newArr;
}

void IntList::Print(std::ostream& out) const {
    out << "[";
    for (int i = 0; i < numItems; i++) {
        out << Items[i] << ' ';
    }
    out << ']';
}

int main(int argc, char** argv) {
    IntList list;
    for (int i = 0; i < 32; i++) {
            list.AddToEnd(i);
    }
    list.Print(std::cout);
    return 0;
}
