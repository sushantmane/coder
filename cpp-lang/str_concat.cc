#include <iostream>
#include <string>

int main(int argc, char** argv) {
    std::string s = "1";
    int cnt = 4;
    char c = '1';
    s += std::to_string(cnt);
    s += c;
    std::cout << s;
}
