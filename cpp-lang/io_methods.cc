#include <iostream>

int main(int argc, char** argv) {
    int x;
    int sum = 0;
    for (int i = 0; i < 10; i++) {
        std::cin >> x;
        sum += x;
    }
    std::cout << "sum:" << sum << std::endl;
    return 0;
}
