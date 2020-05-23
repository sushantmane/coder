#include <iostream>
#include <vector>

int main(int argc, char** argv) {
    std::vector<int> v(10);
    // v.push_back(1);
    v[9] = 10;
    std::cout << v[0] << std::endl;
    std::cout << v[9] << std::endl;
    return 0;
}
