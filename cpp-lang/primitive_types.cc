#include <iostream>

using namespace std;

bool ArrayEq(int a[], int b[], int size) {
    for (int i = 0; i < size; i++) {
        if (a[i] != b[i]) {
            return false;
        }
    }
    return true;
}

int main(int argc, char** argv) {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {1, 2, 3, 4, 6};
        cout << "result:" << ArrayEq(a, b, sizeof (a) / sizeof (a[0])) << endl;
        return 0;
}
