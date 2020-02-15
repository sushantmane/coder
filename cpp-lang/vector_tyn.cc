#include <iostream>
#include <vector>

void Expand(std::vector<int>& v) {
    v.resize(2 * v.size());
}

int main(int argc, char** argv) {
    std::vector<int> v(1);
    for (int i = 0; i <= 16; i++) {
        if (v.size() < i) {
            std::cout << "vector size before calling expand: " << v.size() << std::endl;
            Expand(v);
            std::cout << "vector size after calling expand: " << v.size() << std::endl;
        }
        v[i - 1] = i;
    }
    std::cout << "[";
    for (int i = 0; i < v.size(); i++) {
        std::cout << v[i] << ' ';
    }
    std::cout << "]\n";
    return 0;
}
