#include <iostream>

using namespace std;

int main(int argc, char** argv) {
        enum Color { RED, BLUE, YELLOW };
        Color shoe_color;
        shoe_color = RED;
        cout << "what is the color of my shoe?" << endl << shoe_color << endl;
        return 0;
}
