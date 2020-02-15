#include <iostream>

using namespace std;

void printer(int data) {
    cout << ">> " << data << endl;
}

int main(int argc, char** argv) {
    printer(12);
    return 0;
}
