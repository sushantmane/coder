#include <fstream>
#include <iostream>

int main(int argc, char** argv) {
    std::ifstream inFile;
    inFile.open("CMakeLists.txt");
    if (inFile.fail()) {
        std::cerr << "Failed to open file for reading" << std::endl;
        exit(1);
    }
    char c;
    while (inFile.get(c)) {
        std::cout << c;
    }
    std::cout << std::endl;
    return 0;
}
