#include <iostream>
#include <vector>

int main(int argc, char** argv) {
    std::vector<int> arr {1, 2, 3, 4, 5};
    arr[0] = 22;
    for (const int& i : arr) {
        std::cout << i << std::endl;
    }
    std::cout << "size:" << arr.size() << std::endl;
    arr.erase(arr.begin() + 2);
    std::cout << arr.size() << std::endl;
    arr.clear();
    std::cout << arr.size() << std::endl;
    return 0;
}
