#include <iostream>

using namespace std;

union Info {
    double GPA;
    bool isRa;
};

int main(int argc, char** argv) {
        Info i;
        i.GPA = 3.7;
        cout << "gpa: " << i.GPA << endl;
        cout << sizeof (Info) << endl;
        return 0;
}
