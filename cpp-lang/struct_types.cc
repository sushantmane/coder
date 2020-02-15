#include <iostream>

using namespace std;

struct Education {
    const char* major;
    int grad_year;
};

struct Student {
    const char* name;
    int id;
    Education edu;
};

int main(int argc, char** argv) {
        Student s1;
        s1.name = "Sushant Mane";
        s1.id = 2;
        s1.edu.major = "Computer Science";
        s1.edu.grad_year = 2021;
        cout << "name:" << s1.name << endl;
        cout << "id:" << s1.id << endl;
        cout << "major:" << s1.edu.major << endl;
        cout << "grad year:" << s1.edu.grad_year << endl;
        return 0;
}
