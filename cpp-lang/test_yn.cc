#include <iostream>
#include <string>
#include <vector>

std::vector <std::string> NonEmpty(std::vector <std::string> v) {
    std::vector <std::string> res(v.size());
    int j = 0;
    for (int i = 0; i < v.size(); i++) {
        if (v[i].size() != 0) {
            res[j++] = v[i];
        }
    }
    res.resize(j);
    return res;
}

int main(int argc, char** argv) {
    std::vector <std::string> v = {"hello", "", "bye", "", "", "!"};
    std::vector <std::string> res = NonEmpty(v);
    for (int i = 0; i < res.size(); i++) {
        std::cout << i << " - " << res[i] << std::endl;
    }
    return 0;
}
