#include <iostream>
#include <string>

int main(int argc, char** argv) {
    std::string s1; // initialized to empty string
    std::string s2("second string"); // initialized to the string 'hello'
    std::string s3 = "third string"; // initialized to the string 'goodbye'
    std::cout << "s1 len: " << s1.size() << std::endl;
    std::cout << "s2 len: " << s2.size() << std::endl;
    std::cout << "s3 len: " << s3.size() << std::endl;

    if (s2 != s3) {
        std::cout << "s2 and s3 are not equal" << std::endl;
    }
    if (s1 == "") {
        std::cout << "s1 is empty string" << std::endl;
    }

    std::string s4 = s2 + s3;
    std::cout << "concat:" << s4 << std::endl;

    for (int i = 0; i < s4.size(); i++) {
        if (i >= s2.size()) {
            s4[i] = '-';
        }
        std::cout << s4[i] << std::endl;
    }

    return 0;
}
