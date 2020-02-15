#include <iostream>

using namespace std;

int main(int argc, char** argv) {
    int* ptr = new int;
    *ptr = 101;
    cout << "val:" << *ptr << endl;
    delete ptr;
    return 0;
}
