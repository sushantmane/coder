#include <iostream>
#include <fstream>

void Compare(std::istream& in1, std::istream& in2, std::ostream& out) {
    out << "LGTM" << std::endl;
    char c1;
    char c2;
    while (in1.get(c1)) {
        if (!in2.get(c2) || c1 != c2) {
            out << "not equal" << std::endl;
            return;
        }
    }
    out << "equal" << std::endl;
}

int main(int argc, char** argv) {
    std::ifstream file1;
    std::ifstream file2;
    file1.open("input1");
    if (file1.fail()) {
        std::cerr << "Failed to open input1 file for reading" << std::endl;
        exit(1);
    }
    file2.open("input2");
    if (file2.fail()) {
        std::cerr << "Failed to open input2 file for reading" << std::endl;
        exit(1);
    }
    Compare(file1, file2, std::cout);
    return 0;
}
