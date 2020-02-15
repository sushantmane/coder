#include <iostream>

class IntList {
    public:
        IntList();
        ~IntList();
        IntList(const IntList& L);
        IntList& operator=(const IntList& L);
        void operator+=(int n);
        void AddToEnd(int k);
        void Print(std::ostream& out) const;

    private:
        void Resize();
        static const int SIZE = 10;
        int* Items;
        int numItems;
        int arraySize;
};
