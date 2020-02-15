#include <iostream>

void ParamPassingModes(int a, int& b, const int& c) {
    a = 10;
    b = 20;
    std::cout << "a:" << a << " b:" << b << " c:" << c << std::endl;
}

int main(int argc, char** argv) {
    int a = 5;
    int b = 15;
    int c = 25;
    ParamPassingModes(a, b, c);
    std::cout << "a:" << a << " b:" << b << " c:" << c << std::endl;
    return 0;
}
