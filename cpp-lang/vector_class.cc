#include <iostream>
#include <vector>

int main(int argc, char** argv) {
    std::vector <int> v1(10);
    std::vector <char> v2(5);

    for (int i = 0; i < v1.size(); i++) {
        v1[i] = 10 + i;
    }

    for (int i = 0; i < v1.size(); i++) {
        std::cout << i << " - " << v1[i] << std::endl;
    }

    // resize vector
    v1.resize(2 * v1.size());

    for (int i = 0; i < v1.size(); i++) {
        std::cout << i << " - " << v1[i] << std::endl;
    }

    std::vector <int> v3(20);

    std::cout << "v1 =?= v3: " << (v1 == v3) << std::endl;

    for (int i = 0; i < v1.size(); i++) {
            v3[i] = v1[i];
    }
    std::cout << "v1 =?= v3: " << (v1 == v3) << std::endl;
    v1[19] = 77;
    std::cout << "v1 =?= v3: " << (v1 == v3) << std::endl;


    return 0;
}
