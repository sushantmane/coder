#include <iostream>

using namespace std;

int main(int argc, char** argv) {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
        sum += i;
    }
    cout << "sum: " << sum << endl;
    return 0;
}
